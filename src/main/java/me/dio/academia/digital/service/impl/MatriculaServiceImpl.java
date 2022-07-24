package me.dio.academia.digital.service.impl;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.Matricula;
import me.dio.academia.digital.entity.form.MatriculaForm;
import me.dio.academia.digital.service.IMatriculaService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class MatriculaServiceImpl implements IMatriculaService {

    @Override
    public Matricula create(MatriculaForm form) {
        Matricula matricula = new Matricula();

        Aluno aluno = new Aluno();
        aluno.setNome("David");
        aluno.setCpf("111.111.111-09");
        aluno.setBairro("Bairro Jardim das Flores");
        aluno.setDataDeNascimento(LocalDate.of(2002, 01, 03));

        matricula.setAluno(aluno);

        return matricula;
    }

    @Override
    public Matricula get(Long id) {
        Matricula matricula = new Matricula();
        matricula.setId(id);

        return matricula;
    }

    @Override
    public List<Matricula> getAll(String bairro) {
        Matricula matriculaA = new Matricula();
        Matricula matriculaB = new Matricula();

        List<Matricula> matriculas = new ArrayList(){{
            add(matriculaA);
            add(matriculaB);
        }};

        return matriculas;
    }

    @Override
    public void delete(Long id) {

    }
}
