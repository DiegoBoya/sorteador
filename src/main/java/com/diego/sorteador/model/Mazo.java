package com.diego.sorteador.model;

import java.util.List;
import java.util.stream.Stream;



public class Mazo {
	
	private List<Carta> listaCartasActivas;
	private List<Carta> listaCartasUsadas;
	
	public Mazo() {
		
	}
	
	public Mazo(Carta...cartasNuevas ) {
		int i = 0;
		for(Carta c: cartasNuevas) {
			listaCartasActivas.add(c);
		i++;
		}
		System.out.println("Se agregaron " + i + " cartas nuevas");
	}
	
	/*
	 * este es llamado por el controller, al apretase el boton en el front
	 */
	public Carta getCarta() {
		
		int indice = posicionRandom();
		
		Carta carta = this.listaCartasActivas.remove(indice);
		this.listaCartasUsadas.add(carta);
		System.out.println(carta.toString());
		return carta;
	}
	
	public int posicionRandom() {
		//obtiene la cantidad de cartas que hay en el mazo para poder elegir un numero random entre todas ellas
		int cant = this.listaCartasActivas.size() - 1;
		
		//devuelve un numero entre 0 y (size()-1)
		int indice = (int) Math.floor(Math.random()*cant);
		
		return indice;
	}

	public void listarCartasActivas() {
		for (Carta c: this.listaCartasActivas) {
			System.out.println("---------------------------------------------------------------------");
			System.out.println(" listando cartas activas:");
			c.toString();
			System.out.println("---------------------------------------------------------------------");
		}
	}
	
	public void mezclartodasLasCartas() {
		
		Stream<Carta> cartas = this.listaCartasUsadas.stream();
		this.listaCartasActivas.add(cartas);
	}
	
	
}
