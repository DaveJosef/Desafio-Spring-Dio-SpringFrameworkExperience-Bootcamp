package me.dio.academia.digital.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AvaliacaoFisica {

    private Long id;
    private Aluno aluno;
    private LocalDateTime dataDaAvaliacao = LocalDateTime.now();
    private double peso;
    private double altura;

}
