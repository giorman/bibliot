package com.biblioteca.aplicacion.prestamo.comando.fabrica;

import com.biblioteca.dominio.prestamo.modelo.entidad.Prestamo;
import com.biblioteca.aplicacion.prestamo.comando.ComandoPrestamo;
import org.springframework.stereotype.Component;

@Component
public class FabricaPrestamo {

    public Prestamo crear(ComandoPrestamo comandoPrestamo) {

        return Prestamo.crear(null, comandoPrestamo.getIsbn(),
                comandoPrestamo.getIdentificacionUsuario(), comandoPrestamo.getTipoUsuario(), null);
    }
}
