package me.dio.academia.digital.service.impl;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AlunoForm;
import me.dio.academia.digital.entity.form.AlunoUpdateForm;
import me.dio.academia.digital.service.IAlunoService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class AlunoServiceImpl implements IAlunoService {

    @Override
    public Aluno create(AlunoForm form) {
        Aluno aluno = new Aluno();
        aluno.setNome("David");
        aluno.setCpf("111.111.111-09");
        aluno.setBairro("Bairro Jardim das Flores");
        aluno.setDataDeNascimento(LocalDate.of(2002, 01, 03));

        return aluno;
    }

    @Override
    public Aluno get(Long id) {
        return null;
    }

    @Override
    public List<Aluno> getAll() {
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

        Aluno alunoJoao = new Aluno(1L, "Joao", "111.111.111-09", "Bairro Jardim das Flores", LocalDate.of(2002, 01, 03), avaliacoes);
        Aluno alunoMaria = new Aluno(2L, "Maria", "111.111.111-10", "Bairro Jardim das Flores", LocalDate.of(2002, 01, 04), avaliacoes);
        List<Aluno> alunos = new ArrayList(){{
            add(alunoJoao);
            add(alunoMaria);
        }};

        return alunos;
    }

    @Override
    public Aluno update(Long id, AlunoUpdateForm formUpdate) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<AvaliacaoFisica> getAllAvaliacaoFisicaId(Long id) {

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
}
