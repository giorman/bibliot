package com.biblioteca.test.pruebas.dominio.prestamo.testdata;

import com.biblioteca.dominio.prestamo.modelo.entidad.Prestamo;

import java.time.format.DateTimeFormatter;


public class PrestamoTestData {

    private Long id;
    private String isbn;
    private String identificacionUsuario;
    private Integer tipoUsuario;
    private String fechaMaximaDevolucion;
    private DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public PrestamoTestData prestamoPorDefecto() {
        this.id = 1l;
        this.isbn = "AKSUD58D75";
        this.identificacionUsuario = "8874858584";
        this.tipoUsuario = 1;
        this.fechaMaximaDevolucion = "13/09/2022";
        return this;
    }

    public Prestamo crear() {
        return Prestamo.crear(id, isbn, identificacionUsuario, tipoUsuario, fechaMaximaDevolucion);
    }

    public PrestamoTestData ConId(Long id) {
        this.id = id;
        return this;
    }

    public PrestamoTestData ConIsbn(String isbn) {
        this.isbn = isbn;
        return this;
    }

    public PrestamoTestData ConIdentificacionUsuario(String identificacionUsuario) {
        this.identificacionUsuario = identificacionUsuario;
        return this;
    }

    public PrestamoTestData ConTipoUsuario(Integer tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
        return this;
    }

    public PrestamoTestData ConFechaMaxima(String fechaMaximaDevolucion) {
        this.fechaMaximaDevolucion = fechaMaximaDevolucion;
        return this;
    }


}
