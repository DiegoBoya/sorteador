package com.diego.sorteador.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diego.sorteador.model.Carta;
import com.diego.sorteador.model.Mazo;
import com.diego.sorteador.service.MazoService;
import com.diego.sorteador.service.MazoServiceImpl;

@RestController
@RequestMapping("/mazo")
public class MazoController {

	private static final Logger logger = LogManager.getLogger(MazoController.class);

	@Autowired
	MazoService mazoService;
	
	@GetMapping("/sacarCarta/{name}")
	public ResponseEntity<String> sacarCarta(@PathVariable String name) {
		ResponseEntity<String> response = null;
		boolean succes = true;

		try {

			logger.info("Se saca una carta del mazo para " + name);
			String resp = mazoService.sacarCarta(name);
			
			if (resp.isEmpty()) {
				response = new ResponseEntity<String>("error al obtener la carta", HttpStatus.NOT_FOUND);
			} else {
				response = new ResponseEntity<String>(resp, HttpStatus.OK);
			}
		} catch (Exception e) {
			response = new ResponseEntity<String>(e.getCause().toString() , HttpStatus.INTERNAL_SERVER_ERROR);
			logger.info(e);
		}

		return response;
	}

	
	@PostMapping("/agregarCartas")
	public ResponseEntity<String> agregarCarta(@RequestBody Carta... cartasNuevas){
		ResponseEntity<String> response = null;
		
		try {

			logger.info("Inicia el procedimiento apra agregar cartas al Mazo");
			String resp = mazoService.agregarCartasAlMazo(cartasNuevas);
			
			if (resp.toLowerCase().contains("error")) {
				response = new ResponseEntity<String>(resp, HttpStatus.NOT_FOUND);
			} else {
				response = new ResponseEntity<String>(resp, HttpStatus.OK);
			}
		} catch (Exception e) {
			response = new ResponseEntity<String>(e.getCause().toString() , HttpStatus.INTERNAL_SERVER_ERROR);
			logger.info(e);
		}

		return response;
	}
	
	
}
