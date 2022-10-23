package com.biblioteca.infraestructura.prestamo.adaptador;

import com.biblioteca.dominio.prestamo.modelo.dto.PrestamoExitosoDto;
import com.biblioteca.dominio.prestamo.modelo.entidad.Prestamo;
import com.biblioteca.infraestructura.prestamo.modelo.entidad.PrestamoEntity;
import com.biblioteca.dominio.prestamo.modelo.dto.PrestamoDto;
import org.springframework.stereotype.Component;

@Component
public class MapeadorPrestamo {

    public PrestamoDto mapperEntityToPrestamoDto(PrestamoEntity prestamoEntity) {
        PrestamoDto objeto = null;
        objeto = new PrestamoDto(
                prestamoEntity.getId(),
                prestamoEntity.getIsbn(),
                prestamoEntity.getIdentificacionUsuario(),
                prestamoEntity.getTipoUsuario(),
                prestamoEntity.getFechaMaximaDevolucion());

        return objeto;
    }

    public PrestamoExitosoDto mapperEntityToPrestamoExitosoDto(PrestamoEntity prestamoEntity) {
        PrestamoExitosoDto objeto = null;
        objeto = new PrestamoExitosoDto(
                prestamoEntity.getId(),
                prestamoEntity.getFechaMaximaDevolucion());

        return objeto;
    }

    public PrestamoEntity mapperDominioToEntity(Prestamo prestamo) {
        PrestamoEntity objeto = null;
        objeto = new PrestamoEntity(
                prestamo.getId(),
                prestamo.getIsbn(),
                prestamo.getIdentificacionUsuario(),
                prestamo.getTipoUsuario(),
                prestamo.getFechaMaximaDevolucion());

        return objeto;
    }


}
