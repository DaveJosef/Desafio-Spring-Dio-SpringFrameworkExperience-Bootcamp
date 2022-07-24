package me.dio.academia.digital.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Matricula {

    private Long id;
    private Aluno aluno;
    private LocalDateTime dataDaMatricula = LocalDateTime.now();

}
