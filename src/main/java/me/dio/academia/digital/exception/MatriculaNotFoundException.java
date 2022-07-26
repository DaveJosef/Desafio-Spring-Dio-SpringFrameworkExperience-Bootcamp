package me.dio.academia.digital.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MatriculaNotFoundException extends Exception {

    public MatriculaNotFoundException(Long id) {
        super(String.format("Matricula com ID: %s não encontrada", id));
    }
}
