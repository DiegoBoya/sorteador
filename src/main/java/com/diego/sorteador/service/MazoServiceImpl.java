package com.diego.sorteador.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diego.sorteador.model.Carta;
import com.diego.sorteador.model.Mazo;
import com.diego.sorteador.repository.CartaRepository;

@Service
public class MazoServiceImpl implements MazoService{

	private static final Logger logger = LogManager.getLogger(MazoServiceImpl.class);
	
	@Autowired
	private Mazo mazo;
	
	//@Autowired
	//private CartaRepository cartaRepository;
	

	public MazoServiceImpl(Mazo mazo) {
		System.out.println("se crea el bean de mazoService");
		this.mazo = mazo;
	}
	
	@Override
	public String agregarCartasAlMazo(Carta... cartasNuevas) {
		int i = 0;
		String resultado = null;
		try {
			logger.info("Se intena agregar " + cartasNuevas.length + "cartas nuevas");
			for (Carta c : cartasNuevas) {
				mazo.getListaCartasActivas().add(c);
				i++;
			}
			resultado = "Se agregaron " + i + " cartas nuevas";
		} catch (Exception e) {
			resultado = "Error al agregar las cartas";
		}
		return resultado;
	}

	/*
	 * este es llamado por el controller, al apretase el boton en el front
	 */
	@Override
	public String sacarCarta(String name) {
		
		//logger.info("inicia proceso para sacar una carta del mazo para el invitado " + name);
		
		Carta carta = null;
		String response = "El invitade " + name;
		
		if (mazo.getListaCartasActivas().size() == 0 || mazo.getListaCartasActivas().isEmpty()) {
			this.mezclartodasLasCartas();
		}
		
		carta = getCarta();
		response = response + " para ingresar al cumple debe: " + carta.getDescription();
		logger.info(response);
		return response;
	}
	
	
	@Override
	public Carta getCarta() {
		Carta carta = null;
		int indice = posicionRandom();
		
		if (indice < 0) {
			logger.info("no hay cartas en el mazo, se tienen que crear las cartas");
			return null;
		} else {
			carta = mazo.getListaCartasActivas().remove(indice);
			mazo.getListaCartasUsadas().add(carta);
			logger.info(" se retira la carta: " + carta.toString());
		}
		return carta;
	}
	
	
	@Override
	public int posicionRandom() {
		//obtiene la cantidad de cartas que hay en el mazo para poder elegir un numero random entre todas ellas
		int cant = mazo.getListaCartasActivas().size() - 1;
		
		//devuelve un numero entre 0 y (size()-1)
		int indice = (int) Math.floor(Math.random()*cant);
		
		logger.info("Se retira la carta numero " + indice + ".\nAhora quedan en el mazo " + (cant) + " cartas!!" );
		return indice;
	}

	
	@Override
	public String listarCartasActivas() {
		StringBuilder sb = new StringBuilder();

		System.out.println("---------------------------------------------------------------------");
		logger.info(" listando cartas activas:");
		for (Carta c : mazo.getListaCartasActivas()) {
			sb.append(c.getDescription() + "\n");
			System.out.println(c.toString());
		}
		System.out.println("---------------------------------------------------------------------");
		return sb.toString();
	}
	
	
	@Override
	public String listarCartasUsadas() {
		StringBuilder sb = new StringBuilder();

		System.out.println("---------------------------------------------------------------------");
		logger.info(" listando cartas usadas:");
		for (Carta c : mazo.getListaCartasUsadas()) {
			sb.append(c.getDescription() + "\n");
			System.out.println(c.toString());
		}
		System.out.println("---------------------------------------------------------------------");
		return sb.toString();
	}

	@Override
	public void mezclartodasLasCartas() {
		logger.info(" Ups! nos quedamos sin cartas!! vamos a mezclar!");
		mazo.getListaCartasActivas().addAll(mazo.getListaCartasUsadas());
		logger.info("mezzclando...");
		logger.info("Mazo unificado con exito...");
		
	}

	
	
}
