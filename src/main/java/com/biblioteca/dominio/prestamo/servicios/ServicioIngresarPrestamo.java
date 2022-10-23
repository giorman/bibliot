package com.biblioteca.dominio.prestamo.servicios;

import com.biblioteca.dominio.prestamo.modelo.dto.PrestamoExitosoDto;
import com.biblioteca.dominio.prestamo.excepcion.ExcepcionUsuarioInvitadoTieneLibro;
import com.biblioteca.dominio.prestamo.modelo.dto.PrestamoDto;
import com.biblioteca.dominio.prestamo.modelo.entidad.Prestamo;
import com.biblioteca.dominio.prestamo.puerto.RepositorioPrestamo;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class ServicioIngresarPrestamo {

    public static final int AFILIADO_DIAS = 10;
    public static final int EMPLEADO_DIAS = 8;
    public static final int INVITADO_DIAS = 7;
    public static final int USUARIO_INVITADO = 3;
    public static final int USUARIO_EMPLEADO = 2;
    public static final int USUARIO_AFILIADO = 1;
    private DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private final RepositorioPrestamo repositorioPrestamo;

    public ServicioIngresarPrestamo(RepositorioPrestamo repositorioPrestamo) {
        this.repositorioPrestamo = repositorioPrestamo;
    }

    public PrestamoExitosoDto ejecutar(Prestamo prestamo) {
        String mensaje = "El usuario con identificación " + prestamo.getIdentificacionUsuario() + " ya tiene un libro prestado por lo cual no se le puede realizar otro préstamo";
        if (prestamo.getTipoUsuario() == USUARIO_INVITADO && validarPrestamo(prestamo)) {
            throw new ExcepcionUsuarioInvitadoTieneLibro(mensaje);
        }
        prestamo.setFechaMaximaDevolucion(validarTipoUsuario(prestamo).format(formato));
        PrestamoExitosoDto prestamoGuardado = repositorioPrestamo.guardarPrestamo(prestamo);

        return prestamoGuardado;
    }


    public Boolean validarPrestamo(Prestamo prestamo) {

        try {
            Optional<PrestamoDto> prestamoDto = repositorioPrestamo.validarPrestamo(prestamo
                    .getIdentificacionUsuario());
            return prestamoDto.isPresent();
        } catch (Exception e) {

        }
        return false;
    }


    public LocalDate validarTipoUsuario(Prestamo prestamo) {
        switch (prestamo.getTipoUsuario()) {
            //afiliado3
            case USUARIO_AFILIADO:
                return fechaEntrega(AFILIADO_DIAS);
            //empleado
            case USUARIO_EMPLEADO:
                return fechaEntrega(EMPLEADO_DIAS);
            //invitado
            case USUARIO_INVITADO:
                return fechaEntrega(INVITADO_DIAS);
            default:
                return null;
        }
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
