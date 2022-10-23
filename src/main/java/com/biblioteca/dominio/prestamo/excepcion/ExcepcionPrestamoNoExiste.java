package com.biblioteca.dominio.prestamo.excepcion;

public class ExcepcionPrestamoNoExiste extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ExcepcionPrestamoNoExiste(String message) {
        super(message);
    }
}
