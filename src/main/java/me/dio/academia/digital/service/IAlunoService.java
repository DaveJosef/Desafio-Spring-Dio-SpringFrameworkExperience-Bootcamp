package me.dio.academia.digital.service;

import me.dio.academia.digital.entity.Aluno;

import java.util.List;

public interface IAlunoService {

    /**
     * Cria um aluno.
     * @return Aluno recém-criado.
     * */
    Aluno create();

    /**
     * Retorna um aluno salvo no banco de dados pelo seu id.
     * @param id id do aluno que será exibido.
     * @return Aluno de acordo com o id fornecido.
     * */
    Aluno get(Long id);

    /**
     * Retorna os alunos.
     * @return Uma lista de alunos.
     * */
    List<Aluno> getAll();

    /**
     * Atualiza o aluno.
     * @return Aluno recém-atualizado.
     * */
    Aluno update();

    /**
     * Deleta um aluno específico.
     * @param id id do aluno que será removido.
     * */
    void delete(Long id);

    /**
     * @return Uma lista com todas as avaliações do aluno.
     * */
    List<String> getAllAvaliacaoFisicaId();

}
