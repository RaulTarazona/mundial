package com.mundial.app.Repositorio;

import com.mundial.app.Entidades.Club;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClubRepositorio extends MongoRepository<Club, String> {
}