package com.diego.sorteador.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.diego.sorteador.model.Mazo;
import com.diego.sorteador.pojo.User;
import com.diego.sorteador.service.MazoService;
import com.diego.sorteador.service.MazoServiceImpl;

/*
 * clase que tiene configuracion adicional de nuestros beans
 */
@Configuration
@EnableConfigurationProperties(User.class)
public class ConfigurationBean {
	
}
