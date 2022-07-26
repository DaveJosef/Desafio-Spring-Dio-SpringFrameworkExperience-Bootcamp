package me.dio.academia.digital.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AlunoAlreadyHasMatriculaException extends Exception {

    public AlunoAlreadyHasMatriculaException(Long id) {
        super(String.format("O aluno de ID: %s já está matriculado no sistema", id));
    }
}
