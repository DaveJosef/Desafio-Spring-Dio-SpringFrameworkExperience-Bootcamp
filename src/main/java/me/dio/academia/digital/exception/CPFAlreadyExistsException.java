package me.dio.academia.digital.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CPFAlreadyExistsException extends Exception {

    public CPFAlreadyExistsException(String cpf) {
        super(String.format("Aluno com CPF: %s já está registrado", cpf));
    }
}
