package com.biblioteca.test.pruebas.infraestructura.prestamo.controlador;

import com.biblioteca.test.pruebas.infraestructura.prestamo.testdata.ComandoPrestamoTestData;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.hamcrest.core.Is.is;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@AutoConfigureMockMvc
public class ComandoControladorTest {

    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private MockMvc mockMvc;

    private ComandoPrestamoTestData comandoPrestamoTestData = new ComandoPrestamoTestData();
    private DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @Test
    public void prestamoLibroUsuarioAfiliadoExitosa() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.post("/prestamo")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(comandoPrestamoTestData.comandoPorDefecto())))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.fechaMaximaDevolucion", is(fechaEntrega(10).format(formato))));
    }


    public LocalDate fechaEntrega(Integer dias) {
        LocalDate fecha = LocalDate.now();
        for (int i = 0; i < dias; i++) {
            fecha = fecha.plusDays(1);
            if (fecha.getDayOfWeek() == DayOfWeek.SATURDAY || fecha.getDayOfWeek() == DayOfWeek.SUNDAY) {
                i--;
            }
        }
        return fecha;
    }


}
