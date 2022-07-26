package me.dio.academia.digital.service.impl;

import lombok.AllArgsConstructor;
import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.Matricula;
import me.dio.academia.digital.entity.form.AlunoForm;
import me.dio.academia.digital.entity.form.AlunoUpdateForm;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaForm;
import me.dio.academia.digital.entity.form.MatriculaForm;
import me.dio.academia.digital.exception.AlunoNotFoundException;
import me.dio.academia.digital.exception.CPFAlreadyExistsException;
import me.dio.academia.digital.infra.utils.JavaTimeUtils;
import me.dio.academia.digital.mapper.AlunoMapper;
import me.dio.academia.digital.mapper.AvaliacaoMapper;
import me.dio.academia.digital.mapper.MatriculaMapper;
import me.dio.academia.digital.repository.AlunoRepositoy;
import me.dio.academia.digital.repository.MatriculaRepository;
import me.dio.academia.digital.service.IAlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AlunoServiceImpl implements IAlunoService {

    private final AlunoRepositoy repositoy;
    private final MatriculaRepository matriculaRepository;
    private final AlunoMapper alunoMapper = AlunoMapper.INSTANCE;
    private final MatriculaMapper matriculaMapper = MatriculaMapper.INSTANCE;
    private final AvaliacaoMapper avaliacaoMapper = AvaliacaoMapper.INSTANCE;

    @Override
    public AlunoForm create(AlunoForm form) throws CPFAlreadyExistsException {
        verifyIfCPFIsAlreadyRegistered(form.getCpf());
        Aluno aluno = alunoMapper.toModel(form);
        Aluno alunoSalvo = repositoy.save(aluno);
        return alunoMapper.toForm(alunoSalvo);
    }

    @Override
    public AlunoForm get(Long id) throws AlunoNotFoundException {
        Aluno alunoNoBanco = verifyIfExists(id);
        return alunoMapper.toForm(alunoNoBanco);
    }

    @Override
    public List<AlunoForm> getAll(String dataDeNascimento) {

        List<Aluno> listaDeAlunos;
        if (dataDeNascimento == null) {
            listaDeAlunos = repositoy.findAll();
        } else {
            LocalDate localDate = LocalDate.parse(dataDeNascimento, JavaTimeUtils.LOCAL_DATE_FORMATTER);
            listaDeAlunos = repositoy.findByDataDeNascimento(localDate);
        }
        return listaDeAlunos
                .stream()
                .map(alunoMapper::toForm)
                .collect(Collectors.toList());

    }

    @Override
    public AlunoForm update(Long id, AlunoUpdateForm formUpdate) throws AlunoNotFoundException {
        Aluno alunoParaAtualizar = verifyIfExists(id);
        if (formUpdate.getNome() != null)
            alunoParaAtualizar.setNome(formUpdate.getNome());
        if (formUpdate.getBairro() != null)
            alunoParaAtualizar.setBairro(formUpdate.getBairro());
        if (formUpdate.getDataDeNascimento() != null)
            alunoParaAtualizar.setDataDeNascimento(formUpdate.getDataDeNascimento());

        Aluno alunoAtualizado = repositoy.save(alunoParaAtualizar);
        return alunoMapper.toForm(alunoAtualizado);
    }

    @Override
    public void delete(Long id) throws AlunoNotFoundException {
        verifyIfExists(id);
        List<Matricula> matriculasDoAluno = matriculaRepository.findByAlunoId(id);
        matriculaRepository.deleteAll(matriculasDoAluno);
        Optional<Aluno> alunoPerserverante = repositoy.findById(id);
        if (alunoPerserverante.isPresent()) {
            repositoy.delete(alunoPerserverante.get());
        }
    }

    @Override
    public List<AvaliacaoFisicaForm> getAllAvaliacaoFisicaId(Long id) throws Exception {
        return verifyIfExists(id).getAvaliacoes()
                .stream()
                .map(avaliacaoMapper::toForm)
                .collect(Collectors.toList());

    }

    @Override
    public List<MatriculaForm> getMatriculaId(Long id) throws AlunoNotFoundException {
        verifyIfExists(id);
        List<Matricula> matriculasDoAluno = matriculaRepository.findByAlunoId(id);
        return matriculasDoAluno
                .stream()
                .map(matriculaMapper::toForm)
                .collect(Collectors.toList());
    }

    private Aluno verifyIfExists(Long id) throws AlunoNotFoundException {
        return repositoy.findById(id).orElseThrow(() -> new AlunoNotFoundException(id));
    }

    private void verifyIfCPFIsAlreadyRegistered(String cpf) throws CPFAlreadyExistsException {
        Optional<Aluno> alunoOpcional = repositoy.findByCpf(cpf);
        if (alunoOpcional.isPresent()) {
            throw new CPFAlreadyExistsException(cpf);
        }
    }
}
