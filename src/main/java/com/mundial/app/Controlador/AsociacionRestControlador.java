package com.mundial.app.Controlador;

import com.mundial.app.Entidades.Asociacion;
import com.mundial.app.Repositorio.AsociacionRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/asociaciones")
public class AsociacionRestControlador {

    @Autowired
    private AsociacionRepositorio asociacionRepositorio;

    @GetMapping
    public List<Asociacion> getAll() {
        return asociacionRepositorio.findAll();
    }

    @GetMapping("/{id}")
    public Asociacion getById(@PathVariable String id) {
        return asociacionRepositorio.findById(id).orElseThrow();
    }

    @PostMapping
    public Asociacion create(@RequestBody Asociacion asociacion) {
        return asociacionRepositorio.save(asociacion);
    }

    @PutMapping("/{id}")
    public Asociacion update(@PathVariable String id, @RequestBody Asociacion asociacion) {
        asociacion.setId(id);
        return asociacionRepositorio.save(asociacion);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        asociacionRepositorio.deleteById(id);
    }
}