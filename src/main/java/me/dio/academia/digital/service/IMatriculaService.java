package me.dio.academia.digital.service;

import me.dio.academia.digital.entity.Matricula;

import java.util.List;

public interface IMatriculaService {

    /**
     * Cria uma matrícula.
     * @return - matrícula recém criada.
     * */
    Matricula create();

    /**
     * Retorna uma matrícula que está salva de acordo com o seu id.
     * @param id - id da matrícula que será exibida.
     * @return - matrícula de acordo com o id fornecido.
     * */
    Matricula get(Long id);

    /**
     * Retorna todas as matrículas que estão salvas.
     * @return - uma lista com todas as matrículas que estão salvas.
     * */
    List<Matricula> getAll(String bairro);

    /**
     * Deleta uma matrícula específica.
     * @return - id da matrícula que será removida.
     * */
    void delete(Long id);

}
