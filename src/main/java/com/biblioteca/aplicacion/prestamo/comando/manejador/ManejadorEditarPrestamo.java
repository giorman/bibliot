package com.biblioteca.aplicacion.prestamo.comando.manejador;

import com.biblioteca.aplicacion.prestamo.comando.ComandoPrestamo;
import com.biblioteca.aplicacion.prestamo.comando.fabrica.FabricaPrestamo;
import com.biblioteca.dominio.prestamo.servicios.ServicioEditarPrestamo;

public class ManejadorEditarPrestamo implements  Manejador<ComandoPrestamo>{

    private final FabricaPrestamo fabricaPrestamo;
    private final ServicioEditarPrestamo servicioEditarPrestamo;

    public ManejadorEditarPrestamo(FabricaPrestamo fabricaPrestamo, ServicioEditarPrestamo servicioEditarPrestamo) {
        this.fabricaPrestamo = fabricaPrestamo;
        this.servicioEditarPrestamo= servicioEditarPrestamo;

    }

    @Override
    public void ejecutar(ComandoPrestamo comandoPrestamo) {
        servicioEditarPrestamo.ejecutar(fabricaPrestamo.crear(comandoPrestamo));

    }

}
