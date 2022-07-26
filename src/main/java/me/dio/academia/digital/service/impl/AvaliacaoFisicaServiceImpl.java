package me.dio.academia.digital.service.impl;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaForm;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaUpdateForm;
import me.dio.academia.digital.repository.AlunoRepositoy;
import me.dio.academia.digital.repository.AvaliacaoFisicaRepository;
import me.dio.academia.digital.service.IAvaliacaoFisicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AvaliacaoFisicaServiceImpl implements IAvaliacaoFisicaService {

    @Autowired
    private AvaliacaoFisicaRepository avaliacaoFisicaRepository;
    @Autowired
    private AlunoRepositoy alunoRepositoy;

    @Override
    public AvaliacaoFisica create(AvaliacaoFisicaForm form) {
        AvaliacaoFisica avaliacaoFisica = new AvaliacaoFisica();
        Aluno aluno = alunoRepositoy.findById(form.getAlunoId()).get();

        avaliacaoFisica.setAluno(aluno);
        avaliacaoFisica.setPeso(form.getPeso());
        avaliacaoFisica.setAltura(form.getAltura());

        return avaliacaoFisicaRepository.save(avaliacaoFisica);
    }

    @Override
    public AvaliacaoFisica get(Long id) {
        Optional<AvaliacaoFisica> avaliacaoNoBD = avaliacaoFisicaRepository.findById(id);
        if (avaliacaoNoBD.isPresent()) {

            return avaliacaoNoBD.get();
        }
        return null;
    }

    @Override
    public List<AvaliacaoFisica> getAll() {

        return avaliacaoFisicaRepository.findAll();
    }

    @Override
    public AvaliacaoFisica update(Long id, AvaliacaoFisicaUpdateForm formUpdate) {
        Optional<AvaliacaoFisica> avaliacaoNoBD = avaliacaoFisicaRepository.findById(id);
        if (avaliacaoNoBD.isPresent()) {
            AvaliacaoFisica avaliacao = avaliacaoNoBD.get();
            if (formUpdate.getAltura() != 0)
                avaliacao.setAltura(formUpdate.getAltura());
            if (formUpdate.getPeso() != 0)
                avaliacao.setPeso(formUpdate.getPeso());

            return avaliacaoFisicaRepository.save(avaliacao);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        Optional<AvaliacaoFisica> avaliacaoNoBanco = avaliacaoFisicaRepository.findById(id);
        if (avaliacaoNoBanco.isPresent()) {
            avaliacaoFisicaRepository.deleteById(id);
        }
    }
}
