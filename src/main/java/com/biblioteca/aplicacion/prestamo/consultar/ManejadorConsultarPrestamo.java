package com.biblioteca.aplicacion.prestamo.consultar;

import com.biblioteca.dominio.prestamo.servicios.ServicioConsultarPrestamo;
import com.biblioteca.dominio.prestamo.modelo.dto.PrestamoDto;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ManejadorConsultarPrestamo {

    private final ServicioConsultarPrestamo servicioConsultarPrestamo;

    public ManejadorConsultarPrestamo(ServicioConsultarPrestamo servicioConsultarPrestamo) {
        this.servicioConsultarPrestamo= servicioConsultarPrestamo;
    }

    @Transactional
    public PrestamoDto ejecutar(Long id){
        return servicioConsultarPrestamo.ejecutar(id);
    }
}
