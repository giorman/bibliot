package com.biblioteca.aplicacion.prestamo.comando.manejador;

import com.biblioteca.aplicacion.prestamo.comando.ComandoPrestamo;
import com.biblioteca.aplicacion.prestamo.comando.fabrica.FabricaPrestamo;
import com.biblioteca.dominio.prestamo.modelo.dto.PrestamoExitosoDto;
import com.biblioteca.dominio.prestamo.servicios.ServicioIngresarPrestamo;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ManejadorIngresarPrestamo {

    private final FabricaPrestamo fabricaPrestamo;
    private final ServicioIngresarPrestamo servicioIngresarPrestamo;

    ManejadorIngresarPrestamo(ServicioIngresarPrestamo servicioIngresarPrestamo,FabricaPrestamo fabricaPrestamo){
        this.servicioIngresarPrestamo = servicioIngresarPrestamo;
        this.fabricaPrestamo=fabricaPrestamo;
    }

    @Transactional
    public PrestamoExitosoDto ejecutar(ComandoPrestamo comandoPrestamo){
        return servicioIngresarPrestamo.ejecutar(fabricaPrestamo.crear(comandoPrestamo));
    }
}
