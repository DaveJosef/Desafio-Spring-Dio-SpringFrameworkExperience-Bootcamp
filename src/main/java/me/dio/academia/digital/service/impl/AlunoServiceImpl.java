package me.dio.academia.digital.service.impl;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.service.IAlunoService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class AlunoServiceImpl implements IAlunoService {

    @Override
    public Aluno create() {
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

        List<String> avaliacoes = new ArrayList(){{
            add("AvaliacaoA");
            add("AvaliacaoB");
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
    public Aluno update() {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<String> getAllAvaliacaoFisicaId() {

        List<String> avaliacoes = new ArrayList(){{
            add("AvaliacaoA");
            add("AvaliacaoB");
        }};

        return avaliacoes;
    }
}
