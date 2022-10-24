package com.biblioteca.test.pruebas.dominio.prestamo.servicio;

import com.biblioteca.test.pruebas.dominio.prestamo.testdata.PrestamoTestData;
import com.biblioteca.dominio.prestamo.modelo.dto.PrestamoExitosoDto;
import com.biblioteca.dominio.prestamo.modelo.entidad.Prestamo;
import com.biblioteca.dominio.prestamo.puerto.RepositorioPrestamo;
import com.biblioteca.dominio.prestamo.servicios.ServicioIngresarPrestamo;
import com.biblioteca.dominio.prestamo.modelo.dto.PrestamoDto;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;


import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class ServicioIngresarTest {

    @InjectMocks
    private ServicioIngresarPrestamo servicioIngresarPrestamo;

    @Mock
    private RepositorioPrestamo repositorioPrestamo;

    private Prestamo prestamo;
    private PrestamoTestData prestamoTestData;

    @BeforeEach
    public void crear() {
        prestamo = new PrestamoTestData().prestamoPorDefecto().crear();
        prestamoTestData = new PrestamoTestData().prestamoPorDefecto();
    }

    @Test
    public void validarIngresoPrestamoExitoso() {
        //Arrange
        Prestamo prestamo = new PrestamoTestData().prestamoPorDefecto().crear();
        PrestamoExitosoDto prestamoExitosoDto = new PrestamoExitosoDto(prestamo.getId(), prestamo.getFechaMaximaDevolucion());
        Mockito.when(repositorioPrestamo.guardarPrestamo(prestamo)).thenReturn(prestamoExitosoDto);

        //Act
        PrestamoExitosoDto resultadoPrestamoExitosoDto = servicioIngresarPrestamo.ejecutar(prestamo);

        //Assert
        Assertions.assertEquals(1, resultadoPrestamoExitosoDto.getId());
        Assertions.assertEquals("13/09/2022", resultadoPrestamoExitosoDto.getFechaMaximaDevolucion());

        Mockito.verify(repositorioPrestamo).guardarPrestamo(prestamo);
    }

    @Test
    public void validarIngresoPrestamoFallido() {
        //Arrange
        Prestamo prestamo = new PrestamoTestData().prestamoPorDefecto().crear();
        Mockito.when(repositorioPrestamo.guardarPrestamo(prestamo)).thenReturn(null);

        //Act
        PrestamoExitosoDto resultadoPrestamoExitosoDto = servicioIngresarPrestamo.ejecutar(prestamo);

        //Assert
        Assertions.assertEquals(null, resultadoPrestamoExitosoDto);
        Mockito.verify(repositorioPrestamo).guardarPrestamo(prestamo);
    }

    @Test
    public void validarPrestamoTipoInvitadoYaTieneUnLibro() {
        //Arrange
        Prestamo prestamo = new PrestamoTestData().prestamoPorDefecto().crear();
        PrestamoDto prestamoDto = new PrestamoDto(prestamo.getId(), prestamo.getIsbn(), prestamo.getIdentificacionUsuario(), prestamo.getTipoUsuario(), prestamo.getFechaMaximaDevolucion());
        Mockito.when(repositorioPrestamo.validarPrestamo("8874858584")).thenReturn(Optional.of(prestamoDto));

        //Act
        boolean result = servicioIngresarPrestamo.validarPrestamo(prestamo);

        //Assert
        Assertions.assertTrue(result);

    }

    @Test
    public void validarPrestamoTipoInvitadoNoTieneUnLibro() {

        //Arrange
        Prestamo prestamo = new PrestamoTestData().prestamoPorDefecto().crear();
        PrestamoDto prestamoDto = new PrestamoDto();
        Mockito.lenient().when(repositorioPrestamo.validarPrestamo("1111111111")).thenReturn(Optional.of(prestamoDto));

        //Act
        boolean result = servicioIngresarPrestamo.validarPrestamo(prestamo);

        //Assert
        Assertions.assertFalse(result);

    }
}
