package com.test.hellorest.pojos;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "texto")
public class Texto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6641068318244677232L;
	private Integer id;
	private String texto;
	
	public Texto() { 
	}
	
	public Texto(Integer id, String texto) {
		this.id = id;
		this.texto = texto;
				
	}
	
	@XmlElement
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@XmlElement
	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

}
