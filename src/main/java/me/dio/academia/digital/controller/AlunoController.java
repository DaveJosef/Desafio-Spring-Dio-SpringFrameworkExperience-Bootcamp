package me.dio.academia.digital.controller;

import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.Matricula;
import me.dio.academia.digital.entity.form.AlunoForm;
import me.dio.academia.digital.entity.form.AlunoUpdateForm;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaForm;
import me.dio.academia.digital.entity.form.MatriculaForm;
import me.dio.academia.digital.exception.AlunoNotFoundException;
import me.dio.academia.digital.exception.CPFAlreadyExistsException;
import me.dio.academia.digital.service.impl.AlunoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoServiceImpl service;

    @PostMapping
    public AlunoForm create(@Valid @RequestBody AlunoForm form) throws CPFAlreadyExistsException {
        return service.create(form);
    }

    @GetMapping("/{id}")
    public AlunoForm get(@PathVariable Long id) throws AlunoNotFoundException {
        return service.get(id);
    }

    @PatchMapping("/{id}")
    public AlunoForm update(@PathVariable Long id, @Valid @RequestBody AlunoUpdateForm formUpdate) throws AlunoNotFoundException {
        return service.update(id, formUpdate);
    }

    @GetMapping("/matriculas/{id}")
    public List<MatriculaForm> getMatriculaId(@PathVariable Long id) throws Exception {
        return service.getMatriculaId(id);
    }

    @GetMapping("/avaliacoes/{id}")
    public List<AvaliacaoFisicaForm> getAllAvaliacaoFisicaId(@PathVariable Long id) throws Exception {
        return service.getAllAvaliacaoFisicaId(id);
    }

    @GetMapping
    public List<AlunoForm> getAll(@RequestParam(value = "dataDeNascimento", required = false) String dataDeNascimento) {
        return service.getAll(dataDeNascimento);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) throws AlunoNotFoundException {
        service.delete(id);
    }
}
