package com.mundial.app.Controlador;

import com.mundial.app.Entidades.Jugador;
import com.mundial.app.Repositorio.JugadorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/jugadores")
public class JugadorRestControlador {

    @Autowired
    private JugadorRepositorio jugadorRepositorio;

    @GetMapping
    public List<Jugador> getAll() {
        return jugadorRepositorio.findAll();
    }

    @GetMapping("/{id}")
    public Jugador getById(@PathVariable String id) {
        return jugadorRepositorio.findById(id).orElseThrow();
    }

    @PostMapping
    public Jugador create(@RequestBody Jugador jugador) {
        return jugadorRepositorio.save(jugador);
    }

    @PutMapping("/{id}")
    public Jugador update(@PathVariable String id, @RequestBody Jugador jugador) {
        jugador.setId(id);
        return jugadorRepositorio.save(jugador);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        jugadorRepositorio.deleteById(id);
    }
}