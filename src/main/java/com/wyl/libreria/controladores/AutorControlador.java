/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wyl.libreria.controladores;

import com.wyl.libreria.entidades.Autor;
import com.wyl.libreria.servicios.AutorServicio;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author recos
 */
@Controller
@RequestMapping("/autor")
public class AutorControlador {
    
    @Autowired
    AutorServicio autorServi;
    
    
    @GetMapping("/")
    public String pageAutor(ModelMap modelo){
        List<Autor> listaAutores = autorServi.consultarAutores();
        List<Integer> indices = new ArrayList<>();
        int i = 1;
        for (Autor listaAutor : listaAutores) {
            indices.add(i);
            i++;
        }
        
        modelo.addAttribute("identificador",indices);
        modelo.addAttribute("autores", listaAutores );
        return "autor/autor.html";
    }
    
    @PostMapping("/")
    public String pageAutorNuevo(ModelMap modelo, @RequestParam String nombreAutor) {
        try {
            autorServi.agregarAutor(nombreAutor);
            modelo.put("exito", "Carga Exitosa !!!".toUpperCase());
        } catch (Exception e) {
            modelo.put("error", e.getMessage().toUpperCase());
        }
        return "autor/autor.html";
    }
    
    
    
}
