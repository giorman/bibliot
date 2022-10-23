package com.biblioteca.infraestructura.prestamo.adaptador;


import com.biblioteca.infraestructura.prestamo.modelo.entidad.PrestamoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface RepositorioJpaPrestamo extends JpaRepository<PrestamoEntity, Long> {

    @Query("SELECT prestamo FROM PrestamoEntity prestamo WHERE prestamo.identificacionUsuario = :identificacionUsuario")
    PrestamoEntity validarPrestamo(@Param("identificacionUsuario") String identificacionUsuario);

}
