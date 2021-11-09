/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wyl.libreria.servicios;

import com.wyl.libreria.entidades.Editorial;
import com.wyl.libreria.repositorios.EditorialRepositorio;
import com.wyl.libreria.validaciones.Validacion;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author recos
 */
@Service
public class EditorialServicio {

    @Autowired
    private EditorialRepositorio editorialRepo;

    public void agregarEditorial(String nombre) throws Exception {
        Validacion.validarNombre(nombre);
        Editorial editorial = new Editorial();
        editorial.setNombre(nombre);
        editorial.setAlta(Boolean.TRUE);
        editorialRepo.save(editorial);
    }

    public void modificarEditorialPorId(String id, String nombre, Boolean alta) throws Exception {
        Validacion.validadId(id);
        Validacion.validarNombre(nombre);

        Optional<Editorial> editorial = editorialRepo.findById(id);

        if (editorial.isPresent()) {
            Editorial editorialModificada = editorial.get();
            editorialModificada.setNombre(nombre);
            editorialModificada.setAlta(alta);
            editorialRepo.save(editorialModificada);
        }
    }

    public void listarEditoriales() {
        
    }

    public void darBajaEditorial(String id) throws Exception {
        Validacion.validadId(id);
        Optional<Editorial> editorial = editorialRepo.findById(id);
        if (editorial.isPresent()) {
            Editorial editorialModificada = editorial.get();
            editorialModificada.setAlta(Boolean.FALSE);
            editorialRepo.save(editorialModificada);
        }
    }

    public void darAltaEditorial(String id) throws Exception {
        Validacion.validadId(id);
        Optional<Editorial> editorial = editorialRepo.findById(id);
        if (editorial.isPresent()) {
            Editorial editorialModificada = editorial.get();
            editorialModificada.setAlta(Boolean.TRUE);
            editorialRepo.save(editorialModificada);
        }
    }
}
