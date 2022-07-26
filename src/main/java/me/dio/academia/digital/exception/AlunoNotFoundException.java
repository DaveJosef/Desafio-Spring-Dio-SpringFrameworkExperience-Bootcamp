package me.dio.academia.digital.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AlunoNotFoundException extends Exception {

    public AlunoNotFoundException(Long id) {
        super(String.format("Aluno com ID: %s não encontrado", id));
    }
}
