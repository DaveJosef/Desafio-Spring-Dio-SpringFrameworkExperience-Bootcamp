package me.dio.academia.digital.controller;

import me.dio.academia.digital.entity.Matricula;
import me.dio.academia.digital.entity.form.MatriculaForm;
import me.dio.academia.digital.exception.AlunoAlreadyHasMatriculaException;
import me.dio.academia.digital.exception.AlunoNotFoundException;
import me.dio.academia.digital.exception.MatriculaNotFoundException;
import me.dio.academia.digital.service.impl.MatriculaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/matriculas")
public class MatriculaController {

    @Autowired
    private MatriculaServiceImpl service;

    @PostMapping
    public MatriculaForm create(@Valid @RequestBody MatriculaForm form) throws AlunoNotFoundException, AlunoAlreadyHasMatriculaException {
        return service.create(form);
    }

    @GetMapping("/{id}")
    public MatriculaForm get(@PathVariable Long id) throws MatriculaNotFoundException {
        return service.get(id);
    }

    @GetMapping
    public List<MatriculaForm> getAll(@RequestParam(value = "bairro", required = false) String bairro) {
        return service.getAll(bairro);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) throws MatriculaNotFoundException {
        service.delete(id);
    }
}
