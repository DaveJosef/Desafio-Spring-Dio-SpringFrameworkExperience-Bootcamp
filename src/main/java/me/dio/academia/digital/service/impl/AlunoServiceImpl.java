package me.dio.academia.digital.service.impl;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.Matricula;
import me.dio.academia.digital.entity.form.AlunoForm;
import me.dio.academia.digital.entity.form.AlunoUpdateForm;
import me.dio.academia.digital.infra.utils.JavaTimeUtils;
import me.dio.academia.digital.repository.AlunoRepositoy;
import me.dio.academia.digital.repository.MatriculaRepository;
import me.dio.academia.digital.service.IAlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class AlunoServiceImpl implements IAlunoService {

    @Autowired
    private AlunoRepositoy repositoy;
    @Autowired
    private MatriculaRepository matriculaRepository;

    @Override
    public Aluno create(AlunoForm form) {
        Aluno aluno = new Aluno();
        aluno.setNome(form.getNome());
        aluno.setCpf(form.getCpf());
        aluno.setBairro(form.getBairro());
        aluno.setDataDeNascimento(form.getDataDeNascimento());

        return repositoy.save(aluno);
    }

    @Override
    public Aluno get(Long id) {
        Optional<Aluno> alunoInDB = repositoy.findById(id);
        if (alunoInDB.isPresent()) {
            return alunoInDB.get();
        }
        return null;
    }

    @Override
    public List<Aluno> getAll(String dataDeNascimento) {

        if (dataDeNascimento == null) {
            return repositoy.findAll();
        } else {
            LocalDate localDate = LocalDate.parse(dataDeNascimento, JavaTimeUtils.LOCAL_DATE_FORMATTER);
            return repositoy.findByDataDeNascimento(localDate);
        }

    }

    @Override
    public Aluno update(Long id, AlunoUpdateForm formUpdate) {
        Optional<Aluno> alunoInDB = repositoy.findById(id);
        if (alunoInDB.isPresent()) {
            Aluno aluno = alunoInDB.get();
            if (formUpdate.getNome() != null)
                aluno.setNome(formUpdate.getNome());
            if (formUpdate.getBairro() != null)
                aluno.setBairro(formUpdate.getBairro());
            if (formUpdate.getDataDeNascimento() != null)
                aluno.setDataDeNascimento(formUpdate.getDataDeNascimento());

            return repositoy.save(aluno);
        }
        return null;
    }

    @Override
    public void delete(Long id) throws Exception {
        verifyIfExists(id);
        Optional<Matricula> matriculaDoAluno = matriculaRepository.findByAlunoId(id);
        if (matriculaDoAluno.isPresent()) {
            matriculaRepository.delete(matriculaDoAluno.get());
        }
    }

    @Override
    public List<AvaliacaoFisica> getAllAvaliacaoFisicaId(Long id) throws Exception {
        verifyIfExists(id);
        Optional<Aluno> alunoOptional = repositoy.findById(id);
        return alunoOptional.get().getAvaliacoes();

    }

    @Override
    public Matricula getMatriculaId(Long id) throws Exception {
        verifyIfExists(id);
        Optional<Matricula> matriculaDoAluno = matriculaRepository.findByAlunoId(id);
        if (matriculaDoAluno.isPresent()) {
            return matriculaDoAluno.get();
        }
        return null;
    }

    private void verifyIfExists(Long id) throws Exception {
        Optional<Aluno> alunoInDB = repositoy.findById(id);
        if (!alunoInDB.isPresent()) {
            throw new Exception("Aluno not found :/");
        }
    }
}
