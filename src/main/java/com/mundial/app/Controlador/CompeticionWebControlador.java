package com.mundial.app.Controlador;

import com.mundial.app.Entidades.Competicion;
import com.mundial.app.Repositorio.CompeticionRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/competiciones")
public class CompeticionWebControlador {

    @Autowired
    private CompeticionRepositorio competicionRepositorio;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("competiciones", competicionRepositorio.findAll());
        return "verCompeticion";
    }

    @GetMapping("/nueva")
    public String nueva(Model model) {
        model.addAttribute("competicion", new Competicion());
        return "formCompeticion";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Competicion competicion) {
        competicionRepositorio.save(competicion);
        return "redirect:/competiciones";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable String id, Model model) {
        model.addAttribute("competicion", competicionRepositorio.findById(id).orElseThrow());
        return "formCompeticion";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable String id) {
        competicionRepositorio.deleteById(id);
        return "redirect:/competiciones";
    }
}