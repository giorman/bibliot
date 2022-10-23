package com.biblioteca.infraestructura.prestamo.configuracion;

import com.biblioteca.dominio.prestamo.servicios.ServicioConsultarPrestamo;
import com.biblioteca.dominio.prestamo.servicios.ServicioIngresarPrestamo;
import com.biblioteca.dominio.prestamo.puerto.RepositorioPrestamo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfiguracionServicio {
    @Bean
    public ServicioIngresarPrestamo servicioIngresarPrestamo(RepositorioPrestamo repositorioPrestamo) {
        return new ServicioIngresarPrestamo(repositorioPrestamo);
    }

    @Bean
    public ServicioConsultarPrestamo servicioConsultarPrestamo(RepositorioPrestamo repositorioPrestamo) {
        return new ServicioConsultarPrestamo(repositorioPrestamo);
    }

}
