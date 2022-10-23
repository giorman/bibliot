package com.biblioteca.infraestructura.prestamo.configuracion;

import com.biblioteca.dominio.prestamo.modelo.dto.MensajeDto;
import com.biblioteca.dominio.prestamo.excepcion.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;


@ControllerAdvice
@RestController
public class ConfiguracionExcepcion {

    public static final String ERROR_INESPERADO = "Error inesperado comuniquese con el desarrollador";

    @ExceptionHandler({ExcepcionUsuarioInvitadoTieneLibro.class, ExcepcionMaximoCaracter.class, ExcepcionTipoUsuarioNoValido.class})
    public ResponseEntity<?> excepcionesBadRequest(Exception e) {
        return new ResponseEntity<>(new MensajeDto(e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({ExcepcionPrestamoNoExiste.class})
    public ResponseEntity<?> prestmaoNoExiste(Exception e) {
        return new ResponseEntity<>(new MensajeDto(e.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({ExcepcionValorObligatorio.class})
    public ResponseEntity<?> valorObligatorio(Exception e) {
        return new ResponseEntity<>(new MensajeDto(e.getMessage()), HttpStatus.UNPROCESSABLE_ENTITY);
    }

//    @ExceptionHandler({Exception.class})
//    public ResponseEntity<?> cualquierExcepcion(Exception e){
//        return new ResponseEntity<>(new MensajeDto(ERROR_INESPERADO), HttpStatus.BAD_REQUEST);
//    }


}
