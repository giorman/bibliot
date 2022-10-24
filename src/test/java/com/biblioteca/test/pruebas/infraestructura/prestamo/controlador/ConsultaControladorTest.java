package com.biblioteca.test.pruebas.infraestructura.prestamo.controlador;

import com.biblioteca.test.pruebas.infraestructura.prestamo.testdata.ComandoPrestamoTestData;
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

import java.time.format.DateTimeFormatter;

import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@AutoConfigureMockMvc
public class ConsultaControladorTest {

    @Autowired
    private MockMvc mockMvc;

    private ComandoPrestamoTestData comandoPrestamoTestData = new ComandoPrestamoTestData();
    private DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @Test
    public void consultarPrestamoLibroExitosa() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/prestamo/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id",is(1)))
                .andExpect(jsonPath("$.fechaMaximaDevolucion", is("13/09/2022")))
                .andExpect(jsonPath("$.isbn", is("HAKHD585D4")))
                .andExpect(jsonPath("$.identificacionUsuario", is("2222222222")))
                .andExpect(jsonPath("$.tipoUsuario", is(2)));
    }

    @Test
    public void consultarPrestamoLibroNoExiste() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/prestamo/2")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.mensaje", is("El prestamo no existe")));
    }
}
