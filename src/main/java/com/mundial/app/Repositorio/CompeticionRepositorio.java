package com.mundial.app.Repositorio;

import com.mundial.app.Entidades.Competicion;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompeticionRepositorio extends MongoRepository<Competicion, String> {
}