package com.diego.sorteador.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConstructorBinding
@ConfigurationProperties(prefix = "user")
public class User {
	
	
	private String email;
	private Integer age;
	
	public User(String email, Integer age) {
		super();
		this.email = email;
		this.age = age;
	}

	
	@Override
	public String toString() {
		return "El usuario: " + this.email + ", tiene la edad de:" + this.age;
	}
}
