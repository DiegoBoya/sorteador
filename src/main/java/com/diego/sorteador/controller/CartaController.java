package com.diego.sorteador.controller;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diego.sorteador.model.Carta;
import com.diego.sorteador.repository.CartaRepository;

@RestController
@RequestMapping("/carta")
public class CartaController {
	
	@Autowired
	CartaRepository cartaRepository;

	@GetMapping("/getAll")
	public List<Carta> getAllCartasFromDB(){
		return (List<Carta>) cartaRepository.findAll();
	}
	
	/*
	 * Then, if the carta.isPresent(), we return a 200 OK HTTP response and 
	 * set the carta instance as the body of the response. Else, we return a ResponseEntity.notFound()
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Carta> getCartaById(@PathVariable Integer id) {
		
		Optional<Carta> carta = cartaRepository.findById(id);
		
		if (carta.isPresent()) {
			return ResponseEntity.ok().body(carta.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}
		
	/*
	 * The save() method from the repository saves a new Carta if it doesn't already exist. 
	 * If the Carta with the given id already exists, it throws an exception. 
	 * If successful, it returns the persisted Carta.
	 */
	@PostMapping("/add")
	public Carta saveCarta(@RequestBody Carta carta){
		return cartaRepository.save(carta);
		
	}
		
		
	
	
	
}
