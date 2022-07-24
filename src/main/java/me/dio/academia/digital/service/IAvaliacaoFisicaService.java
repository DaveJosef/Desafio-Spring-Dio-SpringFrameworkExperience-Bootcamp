package me.dio.academia.digital.service;

import me.dio.academia.digital.entity.AvaliacaoFisica;

import java.util.List;

public interface IAvaliacaoFisicaService {

    /**
     * Cria uma avaliação física.
     * @return - avaliação física recém-criada.
     * */
    AvaliacaoFisica create();

    /**
     * Retorna uma avaliação física de acordo com o seu id.
     * @param id - id da avaliação física a ser exibida.
     * @return avaliação física de acordo com o id forncecido.
     * */
    AvaliacaoFisica get(Long id);

    /**
     * Retorna todas as avaliações físicas que estão salvas.
     * @return - Uma lista com todas as avaliações físicas que estão salvas.
     * */
    List<AvaliacaoFisica> getAll();

    /**
     * Atualiza a avaliação física.
     * @return - avaliação física recém-atualizada
     * */
    AvaliacaoFisica update();

    /**
     * Deleta uma avaliação física específica.
     * @param id - id da avaliação física que será removida.
     * */
    void delete(Long id);

}
