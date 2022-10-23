package com.biblioteca.dominio.prestamo.excepcion.validador;

import com.biblioteca.dominio.prestamo.excepcion.ExcepcionTipoUsuarioNoValido;
import com.biblioteca.dominio.prestamo.excepcion.ExcepcionValorObligatorio;
import com.biblioteca.dominio.prestamo.excepcion.ExcepcionMaximoCaracter;

public class ValidadorArgumento {

    private ValidadorArgumento() {
    }

    public static void validarObligatorio(Object valor, String mensaje) {
        if (valor == null) {
            throw new ExcepcionValorObligatorio(mensaje);
        }
    }

    public static void validarLongitudMaxima(String valor, int longitud, String mensaje) {
        if (valor.length() > longitud) {
            throw new ExcepcionMaximoCaracter(mensaje);
        }
    }

    public static void validarTipoUsuario(int valor, String mensaje) {
        if (valor < 1 || valor > 3) {
            throw new ExcepcionTipoUsuarioNoValido(mensaje);
        }
    }
}

