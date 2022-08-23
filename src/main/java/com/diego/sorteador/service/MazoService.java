package com.diego.sorteador.service;

import org.apache.logging.log4j.Logger;
import org.hibernate.annotations.common.util.impl.Log;
import org.springframework.beans.factory.annotation.Autowired;

import com.diego.sorteador.model.Carta;
import com.diego.sorteador.model.Mazo;

public class MazoService {
	
	@Autowired
	private Mazo mazo;
	
	@Autowired
	Log logger;
	
	public MazoService(Mazo mazo) {
		this.mazo = mazo;
	}

	/*
	 * este es llamado por el controller, al apretase el boton en el front
	 */
	public String sacarCarta(String name) {
		
		//logger.info("inicia proceso para sacar una carta del mazo para el invitado " + name);
		
		Carta carta = null;
		
		if (mazo.getListaCartasActivas().size() == 0 || mazo.getListaCartasActivas().isEmpty()) {
			this.mezclartodasLasCartas();
		}
		
		carta = getCarta();
		
		return carta.toString();
	}
	
	
	
	public Carta getCarta() {
		
		int indice = posicionRandom();
		
		Carta carta = mazo.getListaCartasActivas().remove(indice);
		mazo.getListaCartasUsadas().add(carta);
		System.out.println(" se retira la carta: " + carta.toString());
		return carta;
	}
	
	public int posicionRandom() {
		//obtiene la cantidad de cartas que hay en el mazo para poder elegir un numero random entre todas ellas
		int cant = mazo.getListaCartasActivas().size() - 1;
		
		//devuelve un numero entre 0 y (size()-1)
		int indice = (int) Math.floor(Math.random()*cant);
		
		System.out.println(" se retira la carta numero " + indice + ". \n Ahora quedan en el mazo " + (cant) + "cartas!!" );
		return indice;
	}

	public void listarCartasActivas() {
			System.out.println("---------------------------------------------------------------------");
			System.out.println(" listando cartas activas:");
			for (Carta c: mazo.getListaCartasActivas()) {
			System.out.println(c.toString());
		}
			System.out.println("---------------------------------------------------------------------");
	}
	
	public void listarCartasUsadas() {
		System.out.println("---------------------------------------------------------------------");
		System.out.println(" listando cartas usadas:");
		for (Carta c: mazo.getListaCartasUsadas()) {
		System.out.println(c.toString());
	}
		System.out.println("---------------------------------------------------------------------");
}
	
	public void mezclartodasLasCartas() {
		System.out.println(" Ups! nos quedamos sin cartas!! vamos a mezclar!");
		mazo.getListaCartasActivas().addAll(mazo.getListaCartasUsadas());
		System.out.println("mezzclando...");
		System.out.println("Mazo unificado con exito...");
		
	}
}
