package com.mundial.app.Controlador;

import com.mundial.app.Entidades.Asociacion;
import com.mundial.app.Repositorio.AsociacionRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/asociaciones")
public class AsociacionWebControlador {

    @Autowired
    private AsociacionRepositorio asociacionRepositorio;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("asociaciones", asociacionRepositorio.findAll());
        return "verAsociacion";
    }

    @GetMapping("/nueva")
    public String nueva(Model model) {
        model.addAttribute("asociacion", new Asociacion());
        return "formAsociacion";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Asociacion asociacion) {
        asociacionRepositorio.save(asociacion);
        return "redirect:/asociaciones";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable String id, Model model) {
        model.addAttribute("asociacion", asociacionRepositorio.findById(id).orElseThrow());
        return "formAsociacion";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable String id) {
        asociacionRepositorio.deleteById(id);
        return "redirect:/asociaciones";
    }
}