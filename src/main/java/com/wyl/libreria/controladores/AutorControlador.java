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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author recos
 */
@Controller
@RequestMapping("/autor/")
public class AutorControlador {
    
    @Autowired
    AutorServicio autorServi;
    
    
    @GetMapping("/")
    public String pageAutor(ModelMap modelo){
        List<Autor> listaAutores = autorServi.consultarAutores();
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
    
    @GetMapping("/{id}")
    public String darAltaBajaAutor(ModelMap modelo,@PathVariable(value = "id") String idProducto){
        try {
            boolean estado = autorServi.darAltaBajaAutorPorId(idProducto);
            String mensaje = "El autor fue dado de " + (estado? "alta" : "baja") + " correcatmente";
            modelo.put("exito", mensaje);
        } catch (Exception e) {
            modelo.put("error",e.getMessage());
        }
        return "autor/autor.html";
    }
    
    @GetMapping("/autor/modificar")
    public String modificarAutor(ModelMap modelo){
        modelo.put("modificar", "Modificar");
        return "autor/autor.html";
    }
    
    
}
