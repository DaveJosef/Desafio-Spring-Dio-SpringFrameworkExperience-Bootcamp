package me.dio.academia.digital.service;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.Matricula;
import me.dio.academia.digital.entity.form.AlunoForm;
import me.dio.academia.digital.entity.form.AlunoUpdateForm;

import java.util.List;

public interface IAlunoService {

    /**
     * Cria um aluno e o salva no Banco de Dados.
     * @param form formulário referente aos dados para criação de um aluno.
     * @return Aluno recém-criado.
     * */
    Aluno create(AlunoForm form);

    /**
     * Retorna um aluno salvo no Banco de Dados pelo seu id.
     * @param id id do aluno que será exibido.
     * @return Aluno de acordo com o id fornecido.
     * */
    Aluno get(Long id);

    /**
     * Retorna os alunos salvos no Banco de Dados.
     * @return Uma lista de alunos.
     * */
    List<Aluno> getAll(String dataDeNascimento);

    /**
     * Atualiza o aluno no Banco de Dados.
     * @param id id do aluno que será atualizado.
     * @param formUpdate formulário referente aos dados para atualização do aluno.
     * @return Aluno recém-atualizado.
     * */
    Aluno update(Long id, AlunoUpdateForm formUpdate);

    /**
     * Deleta um aluno específico no Banco de Dados.
     * @param id id do aluno que será removido.
     * */
    void delete(Long id) throws Exception;

    /**
     * @param id id do aluno no Banco de Dados do qual será recuperada a lista de avaliações.
     * @return Uma lista com todas as avaliações do aluno.
     * */
    List<AvaliacaoFisica> getAllAvaliacaoFisicaId(Long id) throws Exception;

    Matricula getMatriculaId(Long id) throws Exception;
}
