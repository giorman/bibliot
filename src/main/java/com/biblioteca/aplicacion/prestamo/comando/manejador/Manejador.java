package com.biblioteca.aplicacion.prestamo.comando.manejador;

import com.biblioteca.aplicacion.prestamo.comando.fabrica.FabricaPrestamo;
import org.springframework.transaction.annotation.Transactional;

public interface Manejador<C>  {

        @Transactional
        void ejecutar(C comando);
}
