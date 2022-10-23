package com.biblioteca.dominio.prestamo.excepcion;

public class ExcepcionMaximoCaracter extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ExcepcionMaximoCaracter(String message) {
        super(message);
    }
}
