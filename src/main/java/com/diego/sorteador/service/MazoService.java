package com.diego.sorteador.service;

import com.diego.sorteador.model.Carta;

public interface MazoService {

	public String agregarCartasAlMazo(Carta... cartasNuevas);
	public String sacarCarta(String name) ;
	public Carta getCarta() ;
	public int posicionRandom();
	public String listarCartasActivas();
	public void mezclartodasLasCartas() ;
	public String listarCartasUsadas() ;
	
	
	
}
