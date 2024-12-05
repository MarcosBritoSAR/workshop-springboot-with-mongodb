package com.compass.marcosbrito.semana5.resources.exception;

import com.compass.marcosbrito.semana5.services.Exception.ObjectNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice //Isso avisa ao Spring que essa classe trata possiveis erros nas minhas requisçoes
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class) //Quando ocorrer essa excecao, é preciso esse tratamento a baixo
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {
        /*  Return Entity - Type StandardError            - Type excption          - tratamento da excecao*/

        HttpStatus status = HttpStatus.NOT_FOUND; //erro 404
        StandardError err = new StandardError(System.currentTimeMillis(), status.value(), "Não encontrado", e.getMessage(), request.getRequestURI());
                                            /*Tempo do erro                valor404 -             descricao      -    message     -   caminho da exception */
        return ResponseEntity.status(status).body(err);
    }
}