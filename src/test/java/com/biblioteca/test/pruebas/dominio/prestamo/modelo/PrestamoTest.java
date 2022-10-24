package com.biblioteca.test.pruebas.dominio.prestamo.modelo;


import com.biblioteca.dominio.prestamo.excepcion.ExcepcionValorObligatorio;
import com.biblioteca.dominio.prestamo.modelo.entidad.Prestamo;
import com.biblioteca.test.pruebas.dominio.prestamo.testdata.PrestamoTestData;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;


public class PrestamoTest {

    public static final String ISBN_ES_UN_CAMPO_OBLIGATORIO = "El isbn es un campo obligatorio";
    public static final String IDENTIFICACION_DEL_USUARIO_ES_UN_CAMPO_OBLIGATORIO = "La identificacion del usuario es un campo obligatorio";
    public static final String TIPO_DE_USUARIO_ES_UN_CAMPO_OBLIGATORIO = "El tipo de usuario es un campo obligatorio";



    @Test
    void crearPrestamoDeberiaCrearPrestamoExitosamente() {

        //Arrange
        PrestamoTestData prestamoTestData = new PrestamoTestData().prestamoPorDefecto();

        //Act
        Prestamo prestamo = prestamoTestData.crear();

        //Assert
        assertEquals(1L, prestamo.getId());
        assertEquals("AKSUD58D75", prestamo.getIsbn());
        assertEquals("8874858584", prestamo.getIdentificacionUsuario());
        assertEquals(1, prestamo.getTipoUsuario());
        assertEquals("13/09/2022", prestamo.getFechaMaximaDevolucion());
    }

    @Test
    void validarIdentificacionObligatorio() {
        //Arrange
        PrestamoTestData prestamoTestData = new PrestamoTestData().prestamoPorDefecto();
        prestamoTestData.ConIdentificacionUsuario(null);

        //Act
        ExcepcionValorObligatorio thrown = assertThrows(ExcepcionValorObligatorio.class, () -> {
            prestamoTestData.crear();
        });

        //Assert
        assertTrue(thrown.getMessage().contains(IDENTIFICACION_DEL_USUARIO_ES_UN_CAMPO_OBLIGATORIO));
    }

    @Test
    void validarIsbnObligatorio() {

        //Arrange
        PrestamoTestData prestamo = new PrestamoTestData().prestamoPorDefecto();
        prestamo.ConIsbn(null);

        //Act
        ExcepcionValorObligatorio thrown = assertThrows(ExcepcionValorObligatorio.class, () -> {
            prestamo.crear();
        });

        //Assert
        assertTrue(thrown.getMessage().contains(ISBN_ES_UN_CAMPO_OBLIGATORIO));
    }


    @Test
    void validarTipoUsuarioObligatorio() {

        //Arrange
        PrestamoTestData prestamo = new PrestamoTestData().prestamoPorDefecto();
        prestamo.ConTipoUsuario(null);

        //Act
        ExcepcionValorObligatorio thrown = assertThrows(ExcepcionValorObligatorio.class, () -> {
            prestamo.crear();
        });

        //Assert
        assertTrue(thrown.getMessage().contains(TIPO_DE_USUARIO_ES_UN_CAMPO_OBLIGATORIO));
    }

}
