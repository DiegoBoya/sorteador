package com.diego.sorteador.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diego.sorteador.model.Mazo;
import com.diego.sorteador.service.MazoService;

@RestController
@RequestMapping("/mazo")
public class MazoController {

	private static final Logger logger = LogManager.getLogger(MazoController.class);
	
	MazoService mazoService = new MazoService(new Mazo());

	@GetMapping("/sacarCarta/{name}")
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
			response = new ResponseEntity<String>(e.getCause().toString() , HttpStatus.INTERNAL_SERVER_ERROR);
			logger.info(e);
		}

		return response;
	}

}
