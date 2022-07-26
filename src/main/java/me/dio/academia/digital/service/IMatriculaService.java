package me.dio.academia.digital.service;

import me.dio.academia.digital.entity.form.MatriculaForm;
import me.dio.academia.digital.exception.AlunoAlreadyHasMatriculaException;
import me.dio.academia.digital.exception.AlunoNotFoundException;
import me.dio.academia.digital.exception.MatriculaNotFoundException;

import java.util.List;

public interface IMatriculaService {

    /**
     * Cria uma matrícula e a salva no Banco de Dados.
     * @param form - formulário referente aos dados necessários para a criação da matrícula.
     * @return - matrícula recém criada.
     * */
    MatriculaForm create(MatriculaForm form) throws AlunoNotFoundException, AlunoAlreadyHasMatriculaException;

    /**
     * Retorna uma matrícula que está salva no Banco de Dados de acordo com o seu id.
     * @param id - id da matrícula que será exibida.
     * @return - matrícula de acordo com o id fornecido.
     * */
    MatriculaForm get(Long id) throws MatriculaNotFoundException;

    /**
     * Retorna todas as matrículas que estão salvas no Banco de Dados.
     * @return - uma lista com todas as matrículas que estão salvas.
     * */
    List<MatriculaForm> getAll(String bairro);

    /**
     * Deleta uma matrícula específica no Banco de Dados.
     * @param id - id da matrícula que será removida.
     * */
    void delete(Long id) throws MatriculaNotFoundException;

}
