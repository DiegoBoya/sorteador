package com.diego.sorteador.model;

import java.util.ArrayList;
import java.util.List;



public class Mazo {
	
	private List<Carta> listaCartasActivas;
	private List<Carta> listaCartasUsadas;
	
	public Mazo() {
		listaCartasActivas = new ArrayList<Carta>();
		listaCartasUsadas = new ArrayList<Carta>();
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


	
	
	
	
}
