
var restdb = require('./restdb');
var express = require('express');
var o2x = require('object-to-xml');
var bodyParser = require('body-parser')

var app = express();
app.use(bodyParser.urlencoded({
  extended: true
}));

function sendResponse(data, req, res) {
	
	function toXML() {
		
		var obj = {
			    '?xml version="1.0" encoding="utf-8"?' : null
			};
		
		if(Array.isArray(data)) {
			obj.textos = {
					texto: data
			};
			
		} else {
			obj.texto = data;
		}
		 
		return res.send(o2x(obj));
	}
	
	res.format({
		  text: function(){
		    res.send( JSON.stringify(data) );
		  },
		  
		  'text/xml': toXML,
		  
		  xml: toXML,
		  
		  json: function(){
		    res.send( data );
		  }
		});
}


app.get('/textos/:id', function(req, res){
	
	var text = restdb.get( parseInt(req.param("id")) );
	
	if(!text) {
		res.send(404, 'Not Found');
	} else {
		sendResponse(text, req, res);
	}
	
}); 

app.post('/textos', function(req, res){
	
	var texto = req.body.texto;
	
	if(!texto) {
		res.send(406, 'Texto invalido');
		
	} else { 
		sendResponse(restdb.add(texto), req, res);
	}
	
});

app.put('/textos/:id', function(req, res){
	
	var id = parseInt(req.param("id"));
	 
	var textonew = req.body.texto;
	
	if(!restdb.get( id )) {
		res.send(404, 'Not found');
		
	} else { 
		if(!textonew) {
			res.send(406, 'Texto invalido');
			
		} else {
			sendResponse(restdb.set(id, textonew), req, res);
		}
	}
});

app.get('/textos', function(req, res){	
	sendResponse(restdb.getAll(), req, res);
});

console.log("listen on 3000")
app.listen(3000);
