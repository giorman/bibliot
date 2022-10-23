package com.biblioteca.dominio.prestamo.puerto;

import com.biblioteca.dominio.prestamo.modelo.dto.PrestamoExitosoDto;
import com.biblioteca.dominio.prestamo.modelo.entidad.Prestamo;
import com.biblioteca.dominio.prestamo.modelo.dto.PrestamoDto;


import java.util.Optional;


public interface RepositorioPrestamo {

    PrestamoExitosoDto guardarPrestamo(Prestamo prestamo);

    Optional<PrestamoDto> validarPrestamo(String identificacion);

    Optional<PrestamoDto> buscarPrestamo(Long identificacion);
}
