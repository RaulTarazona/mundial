package com.mundial.app.Controlador;

import com.mundial.app.Entidades.Jugador;
import com.mundial.app.Repositorio.JugadorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/jugadores")
public class JugadorWebControlador {

    @Autowired
    private JugadorRepositorio jugadorRepositorio;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("jugadores", jugadorRepositorio.findAll());
        return "verJugador";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("jugador", new Jugador());
        return "formJugador";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Jugador jugador) {
        jugadorRepositorio.save(jugador);
        return "redirect:/jugadores";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable String id, Model model) {
        model.addAttribute("jugador", jugadorRepositorio.findById(id).orElseThrow());
        return "formJugador";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable String id) {
        jugadorRepositorio.deleteById(id);
        return "redirect:/jugadores";
    }
}