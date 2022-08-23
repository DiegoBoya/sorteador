package com.diego.sorteador.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diego.sorteador.service.MazoService;

@RestController
@RequestMapping("/mazo")
public class MazoController {

	
	MazoService mazoService;

	@GetMapping("/sacarCarta")
	public ResponseEntity<String> sacarCarta(@PathVariable String name) {
		ResponseEntity<String> response = null;
		boolean succes = true;

		try {

			String resp = mazoService.sacarCarta(name);
			
			if (resp.isEmpty()) {
				response = new ResponseEntity<String>("error al obtener la carta", HttpStatus.NOT_FOUND);
			} else {
				response = new ResponseEntity<String>("poner el resultado de la carta que salio", HttpStatus.OK);
			}
		} catch (Exception e) {

		}

		return response;
	}

}
