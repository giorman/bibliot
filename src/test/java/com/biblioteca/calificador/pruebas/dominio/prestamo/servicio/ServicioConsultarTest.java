package com.biblioteca.calificador.pruebas.dominio.prestamo.servicio;

import com.biblioteca.calificador.pruebas.dominio.prestamo.testdata.PrestamoTestData;
import com.biblioteca.dominio.prestamo.modelo.dto.PrestamoDto;
import com.biblioteca.dominio.prestamo.modelo.entidad.Prestamo;
import com.biblioteca.dominio.prestamo.puerto.RepositorioPrestamo;
import com.biblioteca.dominio.prestamo.servicios.ServicioConsultarPrestamo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;


import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class ServicioConsultarTest {

    @InjectMocks
    private ServicioConsultarPrestamo servicioConsultarPrestamo;

    @Mock
    private RepositorioPrestamo repositorioPrestamo;


    @Test
    public void validarConsultarPrestamoExitoso() {
        //Arrange
        Prestamo prestamo = new PrestamoTestData().prestamoPorDefecto().crear();
        PrestamoDto prestamoDto = new PrestamoDto(prestamo.getId(), prestamo.getIsbn(), prestamo.getIdentificacionUsuario(), prestamo.getTipoUsuario(), prestamo.getFechaMaximaDevolucion());
        Mockito.when(repositorioPrestamo.buscarPrestamo(1L)).thenReturn(Optional.of(prestamoDto));

        //Act
        PrestamoDto resultadoPrestamoDto = servicioConsultarPrestamo.ejecutar(1L);

        //Assert
        assertEquals(1L, resultadoPrestamoDto.getId());
        assertEquals("AKSUD58D75", resultadoPrestamoDto.getIsbn());
        assertEquals("8874858584", resultadoPrestamoDto.getIdentificacionUsuario());
        assertEquals(1, resultadoPrestamoDto.getTipoUsuario());
        assertEquals("13/09/2022", resultadoPrestamoDto.getFechaMaximaDevolucion());

        Mockito.verify(repositorioPrestamo).buscarPrestamo(1L);
    }

    @Test
    public void validarConsultarPrestamoNoExitoso() {

        //Arrange
        PrestamoDto prestamoDto = new PrestamoDto();
        Mockito.when(repositorioPrestamo.buscarPrestamo(1L)).thenReturn(Optional.of(prestamoDto));

        //Act
        PrestamoDto resultadoPrestamoDto = servicioConsultarPrestamo.ejecutar(1L);

        //Assert
        assertEquals(null, resultadoPrestamoDto.getId());

        Mockito.verify(repositorioPrestamo).buscarPrestamo(1L);
    }
}
