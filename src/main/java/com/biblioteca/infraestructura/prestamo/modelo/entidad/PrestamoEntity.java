package com.biblioteca.infraestructura.prestamo.modelo.entidad;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "prestamo")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PrestamoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String isbn;

    private String identificacionUsuario;

    private Integer tipoUsuario;

    private String fechaMaximaDevolucion;

}
