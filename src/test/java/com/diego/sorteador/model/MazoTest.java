package com.diego.sorteador.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.diego.sorteador.service.MazoServiceImpl;

class MazoTest {

	@Autowired
	MazoServiceImpl mazoService;
	
	@Test
	void test() {
		int i = mazoService.posicionRandom();
		System.out.println("testeo obtencion del numero random");
		assertTrue(i > 0);
	}

}
