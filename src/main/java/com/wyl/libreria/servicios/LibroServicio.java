/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wyl.libreria.servicios;

import com.wyl.libreria.entidades.Libro;
import com.wyl.libreria.repositorios.LibroRepositorio;
import com.wyl.libreria.validaciones.Validacion;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author recos
 */
@Service
public class LibroServicio {
    @Autowired
    private LibroRepositorio libroRepo;
    
    public void agregarUnLibro(String isbn, Integer anio, Integer ejemplares) throws Exception{
        
        Validacion.validarISBN(isbn);
        Validacion.validarAnio(anio);
          
        
        Libro libro = new Libro();
        
        libro.setIsbn(isbn);
        libro.setAnio(anio);
        libro.setEjemplares(ejemplares);
        libro.setAlta(Boolean.TRUE);
        
        
        libroRepo.save(libro);
        
    }
    
    
    
    public void modificarLibroPorId(String id, String isbn, Integer anio, Integer ejemplares) throws Exception{
        
        Validacion.validarISBN(isbn);
        Validacion.validarAnio(anio);
        
        Optional<Libro> libro = libroRepo.findById(id);
        if(libro.isPresent()){
            Libro libroModificado = libro.get();
            libroModificado.setIsbn(isbn);
            libroModificado.setAnio(anio);
            libroModificado.setEjemplares(ejemplares);
        }
    }
    
    
    
    
    //    public void eliminarLibroPorId(String id) throws Exception{
//        if(libroRepo.existsById(id)){
//            libroRepo.deleteById(id);
//        }
//    }
    
}
