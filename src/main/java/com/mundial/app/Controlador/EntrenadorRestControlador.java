package com.mundial.app.Controlador;

import com.mundial.app.Entidades.Entrenador;
import com.mundial.app.Repositorio.EntrenadorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/entrenadores")
public class EntrenadorRestControlador {

    @Autowired
    private EntrenadorRepositorio entrenadorRepositorio;

    @GetMapping
    public List<Entrenador> getAll() {
        return entrenadorRepositorio.findAll();
    }

    @GetMapping("/{id}")
    public Entrenador getById(@PathVariable String id) {
        return entrenadorRepositorio.findById(id).orElseThrow();
    }

    @PostMapping
    public Entrenador create(@RequestBody Entrenador entrenador) {
        return entrenadorRepositorio.save(entrenador);
    }

    @PutMapping("/{id}")
    public Entrenador update(@PathVariable String id, @RequestBody Entrenador entrenador) {
        entrenador.setId(id);
        return entrenadorRepositorio.save(entrenador);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        entrenadorRepositorio.deleteById(id);
    }
}