package me.dio.academia.digital.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AvaliacaoNotFoundException extends Exception {

    public AvaliacaoNotFoundException(Long id) {
        super(String.format("Avaliação Física com ID: %s não encontrada", id));
    }
}
