package com.diego.sorteador;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.annotations.common.util.impl.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.diego.sorteador.model.Carta;
import com.diego.sorteador.model.ComponentDependency;
import com.diego.sorteador.model.Mazo;
import com.diego.sorteador.pojo.User;
import com.diego.sorteador.service.MazoService;
import com.diego.sorteador.service.MazoServiceImpl;

//@Configuration
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class SorteadorApplication implements CommandLineRunner{
	
	private static final Logger logger = LogManager.getLogger(SorteadorApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(SorteadorApplication.class, args);
		/*
		Mazo mazo = new Mazo();
		MazoService mazoServiceImpl = new MazoServiceImpl(mazo);
		
		//definicion de cartas
		Carta c1 = new Carta("toma un shot c1", true);
		Carta c2 = new Carta("toma un shot c2", true);
		Carta c3 = new Carta("toma un shot c3", true);
		Carta c4 = new Carta("hacer 5 sentadillas", false);
		Carta c5 = new Carta(" hacer la vertical", false);
		Carta c6 = new Carta("ofrecer faso a JL", false);
		Carta c7 = new Carta("Izanagui en el metegol, si no lo entendes, te falta cultura Uchiha", false);
		Carta c8 = new Carta("ruidos extraños en la habitacion", false);
		Carta c9 = new Carta("Denu: tape el inodoro", false);

		
		logger.info("argando tanda de cartas al Mazo:");
		mazoServiceImpl.agregarCartasAlMazo(c1, c2, c3, c4, c5, c6, c7, c8, c9);
		
		mazoServiceImpl.listarCartasActivas();
		System.out.println("sacando cartas: :D");
		mazoServiceImpl.sacarCarta("Diego");
		mazoServiceImpl.listarCartasUsadas();
		mazoServiceImpl.sacarCarta("Ninis");
		mazoServiceImpl.listarCartasUsadas();
		mazoServiceImpl.sacarCarta("gonza");
		mazoServiceImpl.listarCartasUsadas();
		mazoServiceImpl.sacarCarta("maty");
		mazoServiceImpl.listarCartasUsadas();
		mazoServiceImpl.sacarCarta("bel");
		mazoServiceImpl.listarCartasUsadas();
		mazoServiceImpl.sacarCarta("nacho");
		mazoServiceImpl.listarCartasUsadas();
		mazoServiceImpl.sacarCarta("pepe");
		mazoServiceImpl.listarCartasUsadas();
		mazoServiceImpl.sacarCarta("popo");
		mazoServiceImpl.listarCartasUsadas();
		mazoServiceImpl.sacarCarta("pablo");
		mazoServiceImpl.listarCartasUsadas();
		mazoServiceImpl.sacarCarta("pacita");
		mazoServiceImpl.listarCartasUsadas();
		System.out.println("mezclando cartas");
		mazoServiceImpl.mezclartodasLasCartas();
		//mazo.listarCartasActivas();
		*/
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("applicacion levantada exitosamente, que comience la noche!");

		

		
	}
	

}
