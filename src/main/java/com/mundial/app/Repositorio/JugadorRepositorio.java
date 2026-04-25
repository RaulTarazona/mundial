package com.mundial.app.Repositorio;

import com.mundial.app.Entidades.Jugador;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JugadorRepositorio extends MongoRepository<Jugador, String> {
}