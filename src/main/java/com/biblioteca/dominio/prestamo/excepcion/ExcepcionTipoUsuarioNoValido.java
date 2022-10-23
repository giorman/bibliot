package com.biblioteca.dominio.prestamo.excepcion;

public class ExcepcionTipoUsuarioNoValido extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ExcepcionTipoUsuarioNoValido(String message) {
        super(message);
    }
}
