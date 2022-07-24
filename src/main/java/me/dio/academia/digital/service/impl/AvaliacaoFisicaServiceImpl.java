package me.dio.academia.digital.service.impl;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaForm;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaUpdateForm;
import me.dio.academia.digital.service.IAvaliacaoFisicaService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class AvaliacaoFisicaServiceImpl implements IAvaliacaoFisicaService {

    @Override
    public AvaliacaoFisica create(AvaliacaoFisicaForm form) {
        AvaliacaoFisica avaliacaoFisica = new AvaliacaoFisica();

        Aluno aluno = new Aluno();
        aluno.setNome("David");
        aluno.setCpf("111.111.111-09");
        aluno.setBairro("Bairro Jardim das Flores");
        aluno.setDataDeNascimento(LocalDate.of(2002, 01, 03));

        avaliacaoFisica.setAluno(aluno);
        avaliacaoFisica.setPeso(54);
        avaliacaoFisica.setAltura(1.8);

        return avaliacaoFisica;
    }

    @Override
    public AvaliacaoFisica get(Long id) {
        return null;
    }

    @Override
    public List<AvaliacaoFisica> getAll() {
        AvaliacaoFisica avaliacaoA = new AvaliacaoFisica();
        avaliacaoA.setPeso(54);
        avaliacaoA.setAltura(1.8);
        AvaliacaoFisica avaliacaoB = new AvaliacaoFisica();
        avaliacaoB.setPeso(54);
        avaliacaoB.setAltura(1.8);

        List<AvaliacaoFisica> avaliacoes = new ArrayList(){{
            add(avaliacaoA);
            add(avaliacaoB);
        }};

        return avaliacoes;
    }

    @Override
    public AvaliacaoFisica update(Long id, AvaliacaoFisicaUpdateForm formUpdate) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
