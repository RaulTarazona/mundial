package com.mundial.app.Repositorio;

import com.mundial.app.Entidades.Entrenador;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntrenadorRepositorio extends MongoRepository<Entrenador, String> {
}