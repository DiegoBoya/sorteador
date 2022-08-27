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
	MazoService mazoServiceImpl;

//	Carta c1 = new Carta("toma un shot c1", true);
//	Carta c2 = new Carta("toma un shot c2", true);
//	Carta c3 = new Carta("toma un shot c3", true);
//	Carta c4 = new Carta("hacer 5 sentadillas", false);
//	Carta c5 = new Carta(" hacer la vertical", false);
//	Carta c6 = new Carta("ofrecer faso a JL", false);
//	Carta c7 = new Carta("Izanagui en el metegol, si no lo entendes, te falta cultura Uchiha", false);
//	Carta c8 = new Carta("ruidos extraños en la habitacion", false);
//	Carta c9 = new Carta("Denu: tape el inodoro", false);

	public MazoController(MazoService mazoServiceImpl) {
		this.mazoServiceImpl = mazoServiceImpl;
		// mazoServiceImpl.agregarCartasAlMazo(c1, c2, c3, c4, c5, c6, c7, c8, c9);
		System.out.println("se crea el bean de mazoController");
	}

	@GetMapping("/sacarCarta/{name}")
	public ResponseEntity<String> sacarCarta(@PathVariable String name) {
		ResponseEntity<String> response = null;
		boolean succes = true;
		String resp = null;
		String previa = name + " debe cumplir con la siguiente prenda: ";
		// TODO : a la carta agregarle lo que vendira despues de debe y un numero de carta
		try {

			if (name.contains("gon")) {
				resp =  name + " recibe un picanazo en el culo";
				return new ResponseEntity<String>(resp, HttpStatus.OK);
			}

			logger.info("Se saca una carta del mazo para " + name);
			resp = mazoServiceImpl.sacarCarta(name);

			if (resp.isEmpty()) {
				response = new ResponseEntity<String>("error al obtener la carta", HttpStatus.NOT_FOUND);
			} else {
				response = new ResponseEntity<String>(resp, HttpStatus.OK);
			}

		} catch (Exception e) {
			response = new ResponseEntity<String>(e.getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
			logger.info(e);
		}

		return response;
	}

	@PostMapping("/agregarCartas")
	public ResponseEntity<String> agregarCarta(@RequestBody Carta... cartasNuevas) {
		ResponseEntity<String> response = null;

		try {

			logger.info("Inicia el procedimiento apra agregar cartas al Mazo");
			String resp = mazoServiceImpl.agregarCartasAlMazo(cartasNuevas);

			if (resp.toLowerCase().contains("error")) {
				response = new ResponseEntity<String>(resp, HttpStatus.NOT_FOUND);
			} else {
				response = new ResponseEntity<String>(resp, HttpStatus.OK);
			}
		} catch (Exception e) {
			response = new ResponseEntity<String>(e.getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
			logger.info(e);
		}

		return response;
	}

	@GetMapping("/listarActivas")
	public ResponseEntity<String> listarActivas() {
		ResponseEntity<String> response = null;

		try {
			logger.info("se listan las cartas activas");
			String activas = mazoServiceImpl.listarCartasActivas();
			response = new ResponseEntity<String>(activas, HttpStatus.OK);
		} catch (Exception e) {
			response = new ResponseEntity<String>(e.getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
			logger.info(e);
		}
		return response;
	}

	@GetMapping("/listarUsadas")
	public ResponseEntity<String> listarUsadas() {
		ResponseEntity<String> response = null;

		try {
			logger.info("se listan las cartas activas");
			String usadas = mazoServiceImpl.listarCartasUsadas();
			response = new ResponseEntity<String>(usadas, HttpStatus.OK);
		} catch (Exception e) {
			response = new ResponseEntity<String>(e.getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
			logger.info(e);
		}
		return response;
	}

}
