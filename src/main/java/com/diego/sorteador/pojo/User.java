package com.diego.sorteador.pojo;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;


public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private Integer id;
	
	private String name;

	
	public User(String name) {
		super();
		this.name = name;
	}

	
	@Override
	public String toString() {
		return "El usuario: " + this.name ;
	}
}
