package com.biblioteca.aplicacion.prestamo.comando;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class ComandoPrestamo {

    private String isbn;
    private String identificacionUsuario;
    private Integer tipoUsuario;


    public String getIsbn() {
        return isbn;
    }

    public String getIdentificacionUsuario() {
        return identificacionUsuario;
    }

    public Integer getTipoUsuario() {
        return tipoUsuario;
    }


}
