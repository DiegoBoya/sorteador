package com.diego.sorteador.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.diego.sorteador.model.Carta;

@Repository
public interface CartaRepository extends CrudRepository<Carta, Integer>{

}
