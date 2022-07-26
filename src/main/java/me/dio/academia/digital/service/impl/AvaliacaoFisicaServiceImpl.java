package me.dio.academia.digital.service.impl;

import lombok.AllArgsConstructor;
import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaForm;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaUpdateForm;
import me.dio.academia.digital.exception.AlunoNotFoundException;
import me.dio.academia.digital.exception.AvaliacaoNotFoundException;
import me.dio.academia.digital.mapper.AvaliacaoMapper;
import me.dio.academia.digital.repository.AlunoRepositoy;
import me.dio.academia.digital.repository.AvaliacaoFisicaRepository;
import me.dio.academia.digital.service.IAvaliacaoFisicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AvaliacaoFisicaServiceImpl implements IAvaliacaoFisicaService {

    private final AvaliacaoFisicaRepository avaliacaoFisicaRepository;
    private final AlunoRepositoy alunoRepositoy;
    private final AvaliacaoMapper avaliacaoMapper = AvaliacaoMapper.INSTANCE;

    @Override
    public AvaliacaoFisicaForm create(AvaliacaoFisicaForm form) throws AlunoNotFoundException {
        AvaliacaoFisica avaliacaoFisica = avaliacaoMapper.toModel(form);

        Aluno alunoNoBanco = verifyIfAlunoExists(form.getAlunoId());
        avaliacaoFisica.setAluno(alunoNoBanco);

        AvaliacaoFisica avaliacaoSalva = avaliacaoFisicaRepository.save(avaliacaoFisica);
        return avaliacaoMapper.toForm(avaliacaoSalva);
    }

    @Override
    public AvaliacaoFisicaForm get(Long id) throws AvaliacaoNotFoundException {
        AvaliacaoFisica avaliacaoNoBanco = verifyIfExists(id);
        return avaliacaoMapper.toForm(avaliacaoNoBanco);
    }

    @Override
    public List<AvaliacaoFisicaForm> getAll() {

        return avaliacaoFisicaRepository.findAll()
                .stream()
                .map(avaliacaoMapper::toForm)
                .collect(Collectors.toList());
    }

    @Override
    public AvaliacaoFisicaForm update(Long id, AvaliacaoFisicaUpdateForm formUpdate) throws AvaliacaoNotFoundException {

        AvaliacaoFisica avaliacaoParaAtualizar = verifyIfExists(id);
            if (formUpdate.getAltura() != 0)
                avaliacaoParaAtualizar.setAltura(formUpdate.getAltura());
            if (formUpdate.getPeso() != 0)
                avaliacaoParaAtualizar.setPeso(formUpdate.getPeso());

        AvaliacaoFisica avaliacaoSalva = avaliacaoFisicaRepository.save(avaliacaoParaAtualizar);
        return avaliacaoMapper.toForm(avaliacaoSalva);
    }

    @Override
    public void delete(Long id) throws AvaliacaoNotFoundException {
        AvaliacaoFisica avaliacaoNoBanco = verifyIfExists(id);
        avaliacaoFisicaRepository.delete(avaliacaoNoBanco);
    }

    private AvaliacaoFisica verifyIfExists(Long id) throws AvaliacaoNotFoundException {
        return avaliacaoFisicaRepository.findById(id).orElseThrow(() -> new AvaliacaoNotFoundException(id));
    }

    private Aluno verifyIfAlunoExists(Long id) throws AlunoNotFoundException {
        return alunoRepositoy.findById(id).orElseThrow(() -> new AlunoNotFoundException(id));
    }
}
