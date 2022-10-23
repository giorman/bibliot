package com.biblioteca.calificador.pruebas.infraestructura.prestamo.testdata;


public class ComandoPrestamoTestData {

    private String isbn;
    private String identificacionUsuario;
    private int tipoUsuario;

    public ComandoPrestamoTestData comandoPorDefecto() {
        this.isbn = "HKSDHK54D5";
        this.identificacionUsuario = "5548454889";
        this.tipoUsuario = 1;

        return this;
    }



    public String getIsbn() {
        return isbn;
    }

    public String getIdentificacionUsuario() {
        return identificacionUsuario;
    }

    public int getTipoUsuario() {
        return tipoUsuario;
    }


}
