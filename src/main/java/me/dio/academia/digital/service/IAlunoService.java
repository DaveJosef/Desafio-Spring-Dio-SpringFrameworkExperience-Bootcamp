package me.dio.academia.digital.service;

import me.dio.academia.digital.entity.form.AlunoForm;
import me.dio.academia.digital.entity.form.AlunoUpdateForm;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaForm;
import me.dio.academia.digital.entity.form.MatriculaForm;
import me.dio.academia.digital.exception.AlunoNotFoundException;
import me.dio.academia.digital.exception.CPFAlreadyExistsException;

import java.util.List;

public interface IAlunoService {

    /**
     * Cria um aluno e o salva no Banco de Dados.
     * @param form formulário referente aos dados para criação de um aluno.
     * @return Aluno recém-criado.
     * */
    AlunoForm create(AlunoForm form) throws CPFAlreadyExistsException;

    /**
     * Retorna um aluno salvo no Banco de Dados pelo seu id.
     * @param id id do aluno que será exibido.
     * @return Aluno de acordo com o id fornecido.
     * */
    AlunoForm get(Long id) throws AlunoNotFoundException;

    /**
     * Retorna os alunos salvos no Banco de Dados.
     * @return Uma lista de alunos.
     * */
    List<AlunoForm> getAll(String dataDeNascimento);

    /**
     * Atualiza o aluno no Banco de Dados.
     * @param id id do aluno que será atualizado.
     * @param formUpdate formulário referente aos dados para atualização do aluno.
     * @return Aluno recém-atualizado.
     * */
    AlunoForm update(Long id, AlunoUpdateForm formUpdate) throws AlunoNotFoundException;

    /**
     * Deleta um aluno específico no Banco de Dados.
     * @param id id do aluno que será removido.
     * */
    void delete(Long id) throws AlunoNotFoundException;

    /**
     * @param id id do aluno no Banco de Dados do qual será recuperada a lista de avaliações.
     * @return Uma lista com todas as avaliações do aluno.
     * */
    List<AvaliacaoFisicaForm> getAllAvaliacaoFisicaId(Long id) throws Exception;

    List<MatriculaForm> getMatriculaId(Long id) throws Exception;
}
