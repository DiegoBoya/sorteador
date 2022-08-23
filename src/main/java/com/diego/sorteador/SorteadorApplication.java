package com.diego.sorteador;

import org.hibernate.annotations.common.util.impl.Log;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import com.diego.sorteador.model.Carta;
import com.diego.sorteador.model.Mazo;
import com.diego.sorteador.service.MazoService;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class SorteadorApplication {

	public static void main(String[] args) {
		SpringApplication.run(SorteadorApplication.class, args);
		
		System.out.println("argando tanda de cartas al Mazo:");
		Carta c1 = new Carta("toma un shot c1", true);
		Carta c2 = new Carta("toma un shot c2", true);
		Carta c3 = new Carta("toma un shot c3", true);
		Carta c4 = new Carta("hacer 5 sentadillas", false);
		Carta c5 = new Carta(" hacer la vertical", false);
		Carta c6 = new Carta("ofrecer faso a JL", false);
		Carta c7 = new Carta("Izanagui en el metegol, si no lo entendes, te falta cultura Uchiha", false);
		Carta c8 = new Carta("ruidos extraños en la habitacion", false);
		Carta c9 = new Carta("Denu: tape el inodoro", false);
		
		Mazo mazo = new Mazo(c1, c2, c3, c4, c5, c6, c7, c8, c9);
		
		Log logger;
		
		MazoService mazoService = new MazoService(mazo);
		
		mazoService.listarCartasActivas();
		System.out.println("sacando cartas: :D");
		
		mazoService.sacarCarta("Diego");
		mazoService.listarCartasUsadas();
		
		mazoService.sacarCarta("Ninis");
		mazoService.listarCartasUsadas();
		
		mazoService.sacarCarta("gonza");
		mazoService.listarCartasUsadas();
		
		mazoService.sacarCarta("maty");
		mazoService.listarCartasUsadas();
		
		mazoService.sacarCarta("bel");
		mazoService.listarCartasUsadas();
		
		mazoService.sacarCarta("nacho");
		mazoService.listarCartasUsadas();
		
		mazoService.sacarCarta("pepe");
		mazoService.listarCartasUsadas();
		
		mazoService.sacarCarta("popo");
		mazoService.listarCartasUsadas();
		
		mazoService.sacarCarta("pablo");
		mazoService.listarCartasUsadas();
		
		mazoService.sacarCarta("pacita");
		mazoService.listarCartasUsadas();
		
		/*
		 * 
		 * System.out.println("1" + mazoService.posicionRandom());
		 * System.out.println("2" + mazoService.posicionRandom());
		 * System.out.println("3" + mazoService.posicionRandom());
		 * System.out.println("4" + mazoService.posicionRandom());
		 */
		System.out.println("mezclando cartas");
		mazoService.mezclartodasLasCartas();
	
		//mazo.listarCartasActivas();
	}
	

}
