package com.test.hellorest;

import java.util.Collection;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import com.test.hellorest.pojos.Texto;

@Path("/")
public class TextosResource {

	private RestDB db = new RestDB();

	public TextosResource() {
	}

	@GET
	@Path("/textos/{id}")
	@Produces({"application/json", "text/xml"})
	public Texto getTexto(@PathParam("id")  int id) {
		
		Texto txt = db.get( id );
		
		if(txt == null) throw new WebApplicationException(Response.Status.NOT_FOUND);
		
		return txt;
	}
 
	
	@POST
	@Path("/textos")
	@Produces({"application/json", "text/xml"})
	public Texto create(@FormParam("texto") String texto) {
		
		Texto txt = db.add( texto );
		
		if(txt == null) throw new WebApplicationException(Response.Status.NOT_ACCEPTABLE);
		
		return txt;
	}
	
	@PUT
	@Path("/textos/{id}")
	@Produces({"application/json", "text/xml"})
	public Texto update(@PathParam("id")  int id, @FormParam("texto") String texto) {
		
		Texto txt = db.get( id );
		
		if(txt == null) throw new WebApplicationException(Response.Status.NOT_ACCEPTABLE);
		
		txt.setTexto(texto);
		
		return db.set( txt );
	}
	
	@GET
	@Path("/textos")
	@Produces({"application/json", "text/xml"})
	public Collection<Texto> all() {
		 
		return db.getAll();
	}

}
