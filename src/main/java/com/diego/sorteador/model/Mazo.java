package com.diego.sorteador.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;


@Component
public class Mazo {
	
	//@OneToMany
	//private Carta carta;
	
	private List<Carta> listaCartasActivas;
	private List<Carta> listaCartasUsadas;
	
	public Mazo() {
		listaCartasActivas = new ArrayList<Carta>();
		listaCartasUsadas = new ArrayList<Carta>();
		System.out.println("se crea bean de Mazo");
	}
	


	public List<Carta> getListaCartasActivas() {
		return listaCartasActivas;
	}

	public void setListaCartasActivas(List<Carta> listaCartasActivas) {
		this.listaCartasActivas = listaCartasActivas;
	}

	public List<Carta> getListaCartasUsadas() {
		return listaCartasUsadas;
	}

	public void setListaCartasUsadas(List<Carta> listaCartasUsadas) {
		this.listaCartasUsadas = listaCartasUsadas;
	}


	/*
	 * @Override public void saludar() { System.out.println(" soy el Mazo"); }
	 */
	
	
	
}
