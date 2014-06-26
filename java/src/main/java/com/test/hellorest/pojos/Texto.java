package com.test.hellorest.pojos;

import java.io.Serializable;

public class Texto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6641068318244677232L;
	private Integer id;
	private String texto;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Texto() {
	}
}
