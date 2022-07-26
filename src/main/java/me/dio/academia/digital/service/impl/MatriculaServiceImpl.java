package me.dio.academia.digital.service.impl;

import lombok.AllArgsConstructor;
import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.Matricula;
import me.dio.academia.digital.entity.form.MatriculaForm;
import me.dio.academia.digital.exception.AlunoAlreadyHasMatriculaException;
import me.dio.academia.digital.exception.AlunoNotFoundException;
import me.dio.academia.digital.exception.MatriculaNotFoundException;
import me.dio.academia.digital.mapper.MatriculaMapper;
import me.dio.academia.digital.repository.AlunoRepositoy;
import me.dio.academia.digital.repository.MatriculaRepository;
import me.dio.academia.digital.service.IMatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class MatriculaServiceImpl implements IMatriculaService {

    private final MatriculaRepository matriculaRepository;
    private final AlunoRepositoy alunoRepositoy;
    private final MatriculaMapper matriculaMapper = MatriculaMapper.INSTANCE;

    @Override
    public MatriculaForm create(MatriculaForm form) throws AlunoNotFoundException, AlunoAlreadyHasMatriculaException {
        verifyIfAlunoAlreadyHasMatricula(form.getAlunoId());

        Matricula matricula = matriculaMapper.toModel(form);

        //Aluno alunoNoBanco = VerifyIfExistsUtils.verifyIfAlunoExists(form.getAlunoId());
        Aluno alunoNoBanco = verifyIfAlunoExists(form.getAlunoId());
        matricula.setAluno(alunoNoBanco);

        Matricula matriculaSalva = matriculaRepository.save(matricula);
        return matriculaMapper.toForm(matriculaSalva);
    }

    private void verifyIfAlunoAlreadyHasMatricula(Long id) throws AlunoAlreadyHasMatriculaException {
        List<Matricula> matriculas = matriculaRepository.findByAlunoId(id);
        if (matriculas.size() > 0) {
            throw new AlunoAlreadyHasMatriculaException(id);
        }
    }

    @Override
    public MatriculaForm get(Long id) throws MatriculaNotFoundException {
        Matricula matriculaNoBanco = verifyIfExists(id);
        return matriculaMapper.toForm(matriculaNoBanco);
    }

    @Override
    public List<MatriculaForm> getAll(String bairro) {

        List<Matricula> matriculasEncontradas;
        if (bairro == null) {
            matriculasEncontradas = matriculaRepository.findAll();
        } else {
            matriculasEncontradas = matriculaRepository.findByAlunoBairro(bairro);
        }
        return matriculasEncontradas
                .stream()
                .map(matriculaMapper::toForm)
                .collect(Collectors.toList());

    }

    @Override
    public void delete(Long id) throws MatriculaNotFoundException {
        Matricula matriculaNoBanco = verifyIfExists(id);
        matriculaRepository.delete(matriculaNoBanco);
    }

    private Matricula verifyIfExists(Long id) throws MatriculaNotFoundException {
        return matriculaRepository.findById(id).orElseThrow(() -> new MatriculaNotFoundException(id));
    }

    private Aluno verifyIfAlunoExists(Long id) throws AlunoNotFoundException {
        return alunoRepositoy.findById(id).orElseThrow(() -> new AlunoNotFoundException(id));
    }
}
