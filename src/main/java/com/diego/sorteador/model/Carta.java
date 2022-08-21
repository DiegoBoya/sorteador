package com.diego.sorteador.model;

import org.springframework.data.annotation.Id;

public class Carta {
	
	@Id
	private Integer id;
	
	private String name;
	
	private String description;
	
	private boolean isAlcohol;
	
	public Carta() {
		
	}
	
	public Carta(String name, String descripcion, boolean alc) {
		this.name = name;
		this.description = descripcion;
		this.isAlcohol = alc;
	}

	public Integer getId() {
		return id;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isAlcohol() {
		return isAlcohol;
	}

	public void setAlcohol(boolean isAlcohol) {
		this.isAlcohol = isAlcohol;
	}
	
	
}
