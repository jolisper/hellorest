package com.test

import com.twitter.finatra._
import com.twitter.finatra.ContentType._

object App extends FinatraServer {
  register(new TextosResource(new RestDB))
}

class TextosResource(db:RestDB) extends Controller {
   
  get("/textos/:id") { request =>
    val id = request.routeParams("id").toInt
    
    db.get(id)
    	.map( text => sendResponse( request, text )  )
    	.getOrElse( sendError(404, "Not found") )
    	.toFuture
    
  }
  
  
  post("/textos") { request => 
    
    request.params.get("texto")
    	.map( text => sendResponse( request, db.create(text) )  )
    	.getOrElse( sendError(406, "Invalid text") )
    	.toFuture
     
  }
  
  put("/textos/:id") { request =>
    val id = request.routeParams("id").toInt
    
    {
	    for ( existent <- db.get(id);
	    	  texto <- request.params.get("texto");
	    	  resp <- Some(sendResponse( request, db.set(existent, texto) )) ) yield resp
    }
	.getOrElse( sendError(404, "Not found") )
	.toFuture
    
  }
  
  get("/textos") { request => 
    sendResponse( request, db.all ).toFuture
  }
  
  
  def sendResponse(request:Request, data:Any) = {
    
    val accepts = request.accepts
     
    if(accepts.exists( { case x:Xml => true; case _ => false } )) {
      render.body("<xml todo='make it' />").contentType("text/xml")
      
    } else if ( accepts.exists( { case x:Json => true;  case _ => false } ) ) {
      render.json(data)
      
    } else {
      render.plain( data toString )
    }
    
  }
  
  def sendError(code:Int, err:String) = {
    render.body(err)
        .contentType("text/plain")
        .status(code)
  }
  

}