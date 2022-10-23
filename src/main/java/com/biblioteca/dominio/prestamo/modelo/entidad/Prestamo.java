package com.biblioteca.dominio.prestamo.modelo.entidad;

import static com.biblioteca.dominio.prestamo.excepcion.validador.ValidadorArgumento.validarLongitudMaxima;
import static com.biblioteca.dominio.prestamo.excepcion.validador.ValidadorArgumento.validarTipoUsuario;
import static com.biblioteca.dominio.prestamo.excepcion.validador.ValidadorArgumento.validarObligatorio;

import java.time.format.DateTimeFormatter;

public class Prestamo {
    private static final String TIPO_DE_USUARIO_NO_PERMITIDO_BIBLIOTECA = "Tipo de usuario no permitido en la biblioteca";
    private static final String ISBN_USUARIO_MAXIMO_10_CARACTERES = "El isbn no puede tener mas de 10 caracteres";
    private static final String IDENTIFICACION_USUARIO_MAXIMO_10_CARACTERES = "La identificacion no puede tener mas de 10 caracteres";
    private static final int MAXIMA_LONGITUD = 10;
    public static final String ISBN_ES_UN_CAMPO_OBLIGATORIO = "El isbn es un campo obligatorio";
    public static final String IDENTIFICACION_DEL_USUARIO_ES_UN_CAMPO_OBLIGATORIO = "La identificacion del usuario es un campo obligatorio";
    public static final String TIPO_DE_USUARIO_ES_UN_CAMPO_OBLIGATORIO = "El tipo de usuario es un campo obligatorio";

    private Long id;
    private String isbn;
    private String identificacionUsuario;
    private Integer tipoUsuario;
    private String fechaMaximaDevolucion;
    private DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private Prestamo(Long id, String isbn, String identificacionUsuario, Integer tipoUsuario, String fechaMaximaDevolucion) {
        this.id = id;
        this.isbn = isbn;
        this.identificacionUsuario = identificacionUsuario;
        this.tipoUsuario = tipoUsuario;
        this.fechaMaximaDevolucion = fechaMaximaDevolucion;
    }

    public static Prestamo crear(Long id, String isbn, String identificacionUsuario, Integer tipoUsuario, String fechaMaximaDevolucion) {
        validarObligatorio(isbn, ISBN_ES_UN_CAMPO_OBLIGATORIO);
        validarObligatorio(identificacionUsuario, IDENTIFICACION_DEL_USUARIO_ES_UN_CAMPO_OBLIGATORIO);
        validarObligatorio(tipoUsuario, TIPO_DE_USUARIO_ES_UN_CAMPO_OBLIGATORIO);
        validarLongitudMaxima(isbn, MAXIMA_LONGITUD, ISBN_USUARIO_MAXIMO_10_CARACTERES);
        validarLongitudMaxima(identificacionUsuario, MAXIMA_LONGITUD, IDENTIFICACION_USUARIO_MAXIMO_10_CARACTERES);
        validarTipoUsuario(tipoUsuario, TIPO_DE_USUARIO_NO_PERMITIDO_BIBLIOTECA);
        return new Prestamo(id, isbn, identificacionUsuario, tipoUsuario, fechaMaximaDevolucion);
    }

    public Long getId() {
        return id;
    }

    public String getFechaMaximaDevolucion() {
        return fechaMaximaDevolucion;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getIdentificacionUsuario() {
        return identificacionUsuario;
    }

    public Integer getTipoUsuario() {
        return tipoUsuario;
    }

    public void setFechaMaximaDevolucion(String fechaMaximaDevolucion) {
        this.fechaMaximaDevolucion = fechaMaximaDevolucion;
    }
}
