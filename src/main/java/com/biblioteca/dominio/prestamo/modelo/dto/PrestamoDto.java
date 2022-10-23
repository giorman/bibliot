package com.biblioteca.dominio.prestamo.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PrestamoDto {
    private Long id;
    private String isbn;
    private String identificacionUsuario;
    private Integer tipoUsuario;
    private String fechaMaximaDevolucion;


}
