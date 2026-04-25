package com.mundial.app.Controlador;

import com.mundial.app.Entidades.Entrenador;
import com.mundial.app.Repositorio.EntrenadorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/entrenadores")
public class EntrenadorWebControlador {

    @Autowired
    private EntrenadorRepositorio entrenadorRepositorio;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("entrenadores", entrenadorRepositorio.findAll());
        return "verEntrenador";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("entrenador", new Entrenador());
        return "formEntrenador";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Entrenador entrenador) {
        entrenadorRepositorio.save(entrenador);
        return "redirect:/entrenadores";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable String id, Model model) {
        model.addAttribute("entrenador", entrenadorRepositorio.findById(id).orElseThrow());
        return "formEntrenador";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable String id) {
        entrenadorRepositorio.deleteById(id);
        return "redirect:/entrenadores";
    }
}