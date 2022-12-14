
package com.diego.sorteador.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;

@Entity
@Table(name = "Carta")
public class Carta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="carta_id")
	private Integer id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "isAlcohol")
	private boolean isAlcohol;
	
	public Carta() {
		
	}
	
	//constructor por defecto con ALCOHOL == false
	public Carta(String descripcion) {
		this.description = descripcion;
		this.name = "Sin nombre";
		this.isAlcohol = false;
	}
	
	public Carta(String descripcion, boolean alc) {
		this.description = descripcion;
		this.isAlcohol = alc;
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

	@Override
	public String toString() {
		return "Carta [id=" + id + ", description=" + description + ", isAlcohol=" + isAlcohol + "]";
	}
	
	
	
	
}