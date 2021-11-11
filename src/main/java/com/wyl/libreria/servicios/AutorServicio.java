/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wyl.libreria.servicios;

import com.wyl.libreria.entidades.Autor;
import com.wyl.libreria.repositorios.AutorRepositorio;
import com.wyl.libreria.validaciones.Validacion;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author recos
 */
@Service
public class AutorServicio {
    
    @Autowired
    AutorRepositorio autorRepo;
    
    public void agregarAutor(String nombreAutor) throws Exception{
        Validacion.validarNombre(nombreAutor);
        Autor autor = new Autor();
        autor.setNombre(nombreAutor);
        autor.setAlta(Boolean.TRUE);
        autorRepo.save(autor);
    }
    
    public List<Autor> consultarAutores(){
        return autorRepo.findAll();
    }
    
    public boolean darAltaBajaAutorPorId(String id){
        Autor autor = autorRepo.getById(id);
        autor.setAlta(!autor.getAlta());
        autorRepo.save(autor);
        return autor.getAlta();
    }
}
