package com.biblioteca.infraestructura.prestamo.controlador;

import com.biblioteca.aplicacion.prestamo.consultar.ManejadorConsultarPrestamo;
import com.biblioteca.dominio.prestamo.modelo.dto.PrestamoDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/prestamo")
@Api(tags = "Controlador Consulta Prestamo")
public class ControladorConsultaPrestamo {

    private final ManejadorConsultarPrestamo manejadorConsultarPrestamo;

    public ControladorConsultaPrestamo(ManejadorConsultarPrestamo manejadorConsultarPrestamo) {
        this.manejadorConsultarPrestamo = manejadorConsultarPrestamo;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id-prestamo}")
    @ApiOperation("consultar un prestamo")
    PrestamoDto consultarPrestamo(@PathVariable(value = "id-prestamo") Long id) {
        PrestamoDto prestamo = manejadorConsultarPrestamo.ejecutar(id);

        return prestamo;
    }


}
