package com.biblioteca.dominio.prestamo.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PrestamoExitosoDto {
    private Long id;
    private String fechaMaximaDevolucion;

}
