package me.dio.academia.digital.service;

import me.dio.academia.digital.entity.form.AvaliacaoFisicaForm;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaUpdateForm;
import me.dio.academia.digital.exception.AlunoNotFoundException;
import me.dio.academia.digital.exception.AvaliacaoNotFoundException;

import java.util.List;

public interface IAvaliacaoFisicaService {

    /**
     * Cria uma avaliação física no Banco de Dados.
     * @param form - formulário referente aos dados para criação de avalição física
     * @return - avaliação física recém-criada.
     * */
    AvaliacaoFisicaForm create(AvaliacaoFisicaForm form) throws AlunoNotFoundException;

    /**
     * Recupera uma avaliação física do Banco de Dados de acordo com o seu id.
     * @param id - id da avaliação física a ser exibida.
     * @return avaliação física de acordo com o id forncecido.
     * */
    AvaliacaoFisicaForm get(Long id) throws AvaliacaoNotFoundException;

    /**
     * Retorna todas as avaliações físicas que estão salvas no Banco de Dados.
     * @return - Uma lista com todas as avaliações físicas que estão salvas.
     * */
    List<AvaliacaoFisicaForm> getAll();

    /**
     * Atualiza a avaliação física existente no Banco de Dados.
     * @param id - id da avaliação física que será atualizada.
     * @param formUpdate - formulário referente aos dados necessários para atualização da avaliação.
     * @return - avaliação física recém-atualizada
     * */
    AvaliacaoFisicaForm update(Long id, AvaliacaoFisicaUpdateForm formUpdate) throws AvaliacaoNotFoundException;

    /**
     * Deleta uma avaliação física específica no Banco de Dados.
     * @param id - id da avaliação física que será removida.
     * */
    void delete(Long id) throws AvaliacaoNotFoundException;

}
