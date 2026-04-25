package com.mundial.app.Controlador;

import com.mundial.app.Entidades.Competicion;
import com.mundial.app.Repositorio.CompeticionRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/competiciones")
public class CompeticionRestControlador {

    @Autowired
    private CompeticionRepositorio competicionRepositorio;

    @GetMapping
    public List<Competicion> getAll() {
        return competicionRepositorio.findAll();
    }

    @GetMapping("/{id}")
    public Competicion getById(@PathVariable String id) {
        return competicionRepositorio.findById(id).orElseThrow();
    }

    @PostMapping
    public Competicion create(@RequestBody Competicion competicion) {
        return competicionRepositorio.save(competicion);
    }

    @PutMapping("/{id}")
    public Competicion update(@PathVariable String id, @RequestBody Competicion competicion) {
        competicion.setId(id);
        return competicionRepositorio.save(competicion);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        competicionRepositorio.deleteById(id);
    }
}