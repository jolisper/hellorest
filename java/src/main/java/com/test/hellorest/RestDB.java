package com.test.hellorest;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import com.test.hellorest.pojos.Texto;

public class RestDB {

	private Map<Integer, Texto> db = new HashMap<>();
	
	public Texto get(int id) {
		return db.get(id);
	}

	public Texto add(String texto) {
		if(texto != null) {
			Texto txt = new Texto(Math.abs(new Random().nextInt()), texto);
			db.put(txt.getId(), txt);
			
			return txt;
		}
		return null;
	}

	public Texto set(Texto txt) {
		
		if(txt.getId() == null || !db.containsKey(txt.getId())) {
			return null;
		}
		
		db.put(txt.getId(), txt);
		
		return txt;
	}

	public Collection<Texto> getAll() {
		return db.values();
	}

}
