package me.dio.academia.digital.service;

import me.dio.academia.digital.entity.Matricula;
import me.dio.academia.digital.entity.form.MatriculaForm;

import java.util.List;

public interface IMatriculaService {

    /**
     * Cria uma matrícula e a salva no Banco de Dados.
     * @param form - formulário referente aos dados necessários para a criação da matrícula.
     * @return - matrícula recém criada.
     * */
    Matricula create(MatriculaForm form);

    /**
     * Retorna uma matrícula que está salva no Banco de Dados de acordo com o seu id.
     * @param id - id da matrícula que será exibida.
     * @return - matrícula de acordo com o id fornecido.
     * */
    Matricula get(Long id);

    /**
     * Retorna todas as matrículas que estão salvas no Banco de Dados.
     * @return - uma lista com todas as matrículas que estão salvas.
     * */
    List<Matricula> getAll(String bairro);

    /**
     * Deleta uma matrícula específica no Banco de Dados.
     * @return - id da matrícula que será removida.
     * */
    void delete(Long id);

}
