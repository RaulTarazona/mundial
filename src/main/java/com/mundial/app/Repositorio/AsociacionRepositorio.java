package com.mundial.app.Repositorio;

import com.mundial.app.Entidades.Asociacion;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsociacionRepositorio extends MongoRepository<Asociacion, String> {
}