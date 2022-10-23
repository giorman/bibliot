package com.biblioteca.infraestructura.prestamo.adaptador;

import com.biblioteca.dominio.prestamo.modelo.dto.PrestamoExitosoDto;
import com.biblioteca.dominio.prestamo.modelo.entidad.Prestamo;
import com.biblioteca.dominio.prestamo.puerto.RepositorioPrestamo;
import com.biblioteca.infraestructura.prestamo.modelo.entidad.PrestamoEntity;
import com.biblioteca.dominio.prestamo.modelo.dto.PrestamoDto;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public class RepositorioAdaptador implements RepositorioPrestamo {

    private final RepositorioJpaPrestamo repositorioJpaPrestamo;
    private final MapeadorPrestamo mapeadorPrestamo;

    public RepositorioAdaptador(RepositorioJpaPrestamo repositorioJpaPrestamo, MapeadorPrestamo mapeadorPrestamo) {
        this.repositorioJpaPrestamo = repositorioJpaPrestamo;
        this.mapeadorPrestamo = mapeadorPrestamo;
    }

    @Override
    public PrestamoExitosoDto guardarPrestamo(Prestamo prestamo) {
        PrestamoEntity prestamoEntity = mapeadorPrestamo.mapperDominioToEntity(prestamo);
        PrestamoEntity resultado = repositorioJpaPrestamo.save(prestamoEntity);
        return mapeadorPrestamo.mapperEntityToPrestamoExitosoDto(resultado);
    }

    @Override
    public Optional<PrestamoDto> validarPrestamo(String identificacion) {
        PrestamoEntity resultado = repositorioJpaPrestamo.validarPrestamo(identificacion);
        Optional<PrestamoDto> optional = Optional.of(mapeadorPrestamo.mapperEntityToPrestamoDto(resultado));
        return optional;
    }


    @Override
    public Optional<PrestamoDto> buscarPrestamo(Long identificacion) {
        Optional<PrestamoEntity> prestamoEntity = repositorioJpaPrestamo.findById(identificacion);
        Optional<PrestamoDto> optional = Optional.of(mapeadorPrestamo.mapperEntityToPrestamoDto(prestamoEntity.get()));
        return optional;
    }
}
