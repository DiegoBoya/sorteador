package com.diego.sorteador;

import org.hibernate.annotations.common.util.impl.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.diego.sorteador.model.Carta;
import com.diego.sorteador.model.ComponentDependency;
import com.diego.sorteador.model.Mazo;
import com.diego.sorteador.service.MazoServiceImpl;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class SorteadorApplication implements CommandLineRunner{
	
	@Autowired
	@Qualifier("mazo")
	private ComponentDependency mazo;
	
	@Autowired
	@Qualifier("carta")
	private ComponentDependency carta;
	
	/*
	 * // Inyeccion de dependencias a traves del constructor public
	 * SorteadorApplication (ComponentDependency mazo, ComponentDependency carta) {
	 * this.carta = carta; this.mazo = mazo; }
	 */

	public static void main(String[] args) {
		SpringApplication.run(SorteadorApplication.class, args);
		
		
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		mazo.saludar();
		carta.saludar();
	}
	

}
