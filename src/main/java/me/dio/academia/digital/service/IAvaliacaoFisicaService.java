package me.dio.academia.digital.service;

import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaForm;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaUpdateForm;

import java.util.List;

public interface IAvaliacaoFisicaService {

    /**
     * Cria uma avaliação física no Banco de Dados.
     * @param form - formulário referente aos dados para criação de avalição física
     * @return - avaliação física recém-criada.
     * */
    AvaliacaoFisica create(AvaliacaoFisicaForm form);

    /**
     * Recupera uma avaliação física do Banco de Dados de acordo com o seu id.
     * @param id - id da avaliação física a ser exibida.
     * @return avaliação física de acordo com o id forncecido.
     * */
    AvaliacaoFisica get(Long id);

    /**
     * Retorna todas as avaliações físicas que estão salvas no Banco de Dados.
     * @return - Uma lista com todas as avaliações físicas que estão salvas.
     * */
    List<AvaliacaoFisica> getAll();

    /**
     * Atualiza a avaliação física existente no Banco de Dados.
     * @param id - id da avaliação física que será atualizada.
     * @param formUpdate - formulário referente aos dados necessários para atualização da avaliação.
     * @return - avaliação física recém-atualizada
     * */
    AvaliacaoFisica update(Long id, AvaliacaoFisicaUpdateForm formUpdate);

    /**
     * Deleta uma avaliação física específica no Banco de Dados.
     * @param id - id da avaliação física que será removida.
     * */
    void delete(Long id);

}
