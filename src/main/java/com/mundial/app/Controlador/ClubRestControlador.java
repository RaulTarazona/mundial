package com.mundial.app.Controlador;

import com.mundial.app.Entidades.Club;
import com.mundial.app.Repositorio.ClubRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/clubes")
public class ClubRestControlador {

    @Autowired
    private ClubRepositorio clubRepositorio;

    @GetMapping
    public List<Club> getAll() {
        return clubRepositorio.findAll();
    }

    @GetMapping("/{id}")
    public Club getById(@PathVariable String id) {
        return clubRepositorio.findById(id).orElseThrow();
    }

    @PostMapping
    public Club create(@RequestBody Club club) {
        return clubRepositorio.save(club);
    }

    @PutMapping("/{id}")
    public Club update(@PathVariable String id, @RequestBody Club club) {
        club.setId(id);
        return clubRepositorio.save(club);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        clubRepositorio.deleteById(id);
    }
}