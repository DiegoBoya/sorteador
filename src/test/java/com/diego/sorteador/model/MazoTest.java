package com.diego.sorteador.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.diego.sorteador.service.MazoService;

class MazoTest {

	@Autowired
	MazoService mazoService;
	
	@Test
	void test() {
		int i = mazoService.posicionRandom();
		System.out.println("testeo obtencion del numero random");
		assertTrue(i > 0);
	}

}
