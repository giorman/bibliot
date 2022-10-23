package com.biblioteca.dominio.prestamo.servicios;

import com.biblioteca.dominio.prestamo.excepcion.ExcepcionPrestamoNoExiste;
import com.biblioteca.dominio.prestamo.modelo.dto.PrestamoDto;
import com.biblioteca.dominio.prestamo.puerto.RepositorioPrestamo;

import java.util.Optional;

public class ServicioConsultarPrestamo {

    private final RepositorioPrestamo repositorioPrestamo;

    public ServicioConsultarPrestamo(RepositorioPrestamo repositorioPrestamo) {
        this.repositorioPrestamo = repositorioPrestamo;
    }

    public PrestamoDto ejecutar(Long id) {
        PrestamoDto prestamoDto = validarExiste(id);

        return prestamoDto;
    }

    private PrestamoDto validarExiste(Long id) {
        Optional<PrestamoDto> prestamoDto;
        try {
            prestamoDto = repositorioPrestamo.buscarPrestamo(id);
        } catch (Exception e) {
            throw new ExcepcionPrestamoNoExiste("El prestamo no existe");
        }
        return prestamoDto.get();
    }

}
