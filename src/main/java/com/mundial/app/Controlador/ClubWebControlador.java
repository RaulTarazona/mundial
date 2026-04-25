package com.mundial.app.Controlador;

import com.mundial.app.Entidades.Club;
import com.mundial.app.Repositorio.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/clubes")
public class ClubWebControlador {

    @Autowired
    private ClubRepositorio clubRepositorio;

    @Autowired
    private AsociacionRepositorio asociacionRepositorio;

    @Autowired
    private EntrenadorRepositorio entrenadorRepositorio;

    @Autowired
    private JugadorRepositorio jugadorRepositorio;

    @Autowired
    private CompeticionRepositorio competicionRepositorio;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("clubes", clubRepositorio.findAll());
        return "verClub";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("club", new Club());
        model.addAttribute("asociaciones", asociacionRepositorio.findAll());
        model.addAttribute("entrenadores", entrenadorRepositorio.findAll());
        model.addAttribute("jugadores", jugadorRepositorio.findAll());
        model.addAttribute("competiciones", competicionRepositorio.findAll());
        return "formClub";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Club club) {
        clubRepositorio.save(club);
        return "redirect:/clubes";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable String id, Model model) {
        model.addAttribute("club", clubRepositorio.findById(id).orElseThrow());
        model.addAttribute("asociaciones", asociacionRepositorio.findAll());
        model.addAttribute("entrenadores", entrenadorRepositorio.findAll());
        model.addAttribute("jugadores", jugadorRepositorio.findAll());
        model.addAttribute("competiciones", competicionRepositorio.findAll());
        return "formClub";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable String id) {
        clubRepositorio.deleteById(id);
        return "redirect:/clubes";
    }
}