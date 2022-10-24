package com.biblioteca.dominio.prestamo.servicios;

import com.biblioteca.dominio.prestamo.modelo.entidad.Prestamo;
import com.biblioteca.dominio.prestamo.puerto.RepositorioPrestamo;

public class ServicioEditarPrestamo {

    private final RepositorioPrestamo repositorioPrestamo;

    public ServicioEditarPrestamo(RepositorioPrestamo repositorioPrestamo) {
        this.repositorioPrestamo = repositorioPrestamo;
    }

    public void ejecutar(Prestamo prestamo){

    }
}
