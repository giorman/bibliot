package com.biblioteca.infraestructura.prestamo.controlador;

import com.biblioteca.aplicacion.prestamo.comando.ComandoPrestamo;
import com.biblioteca.aplicacion.prestamo.comando.manejador.ManejadorIngresarPrestamo;
import com.biblioteca.dominio.prestamo.modelo.dto.PrestamoExitosoDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/prestamo")
@Api(tags = "Controlador Prestamo")
public class ControladorComandoPrestamo {

    private final ManejadorIngresarPrestamo manejadorIngresarPrestamo;

    public ControladorComandoPrestamo(ManejadorIngresarPrestamo manejadorIngresarPrestamo) {
        this.manejadorIngresarPrestamo = manejadorIngresarPrestamo;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation("agregar un prestamo")
    PrestamoExitosoDto agregarPrestamo(@RequestBody ComandoPrestamo comandoPrestamo) {
        return manejadorIngresarPrestamo.ejecutar(comandoPrestamo);
    }

}
