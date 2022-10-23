package com.biblioteca.dominio.prestamo.excepcion;

public class ExcepcionUsuarioInvitadoTieneLibro extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ExcepcionUsuarioInvitadoTieneLibro(String message) {
        super(message);
    }
}
