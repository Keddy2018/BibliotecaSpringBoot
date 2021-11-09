/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wyl.libreria.validaciones;

/**
 *
 * @author recos
 */
public class Validacion {

    public static void validarISBN(String isbn) throws Exception {
        if (isbn.isEmpty()) {
            throw new Exception("La cadena isbn no puede ser vacia");
        } else if (isbn.length() >= 13) {
            throw new Exception("La longitud del isbn deve contener 13 caracteres numericos");
        }

    }

    public static void validarAnio(Integer anio) throws Exception {
        if (anio.toString().length() == 4) {
            throw new Exception("El año no tiene formato correcto");
        }
    }

    public static void validarNombre(String nombre) throws Exception {
        if (nombre.isEmpty()) {
            throw new Exception("El nombre del autor no puede estar vaciao");
        }

    }
    
    public static void validadId(String id) throws Exception{
        if(id.isEmpty()){
            throw new Exception("El id no puede ser un valor vacio");
        }
    }

}
