package me.dio.academia.digital.controller;

import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaForm;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaUpdateForm;
import me.dio.academia.digital.exception.AlunoNotFoundException;
import me.dio.academia.digital.exception.AvaliacaoNotFoundException;
import me.dio.academia.digital.service.impl.AvaliacaoFisicaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoFisicaController {

    @Autowired
    private AvaliacaoFisicaServiceImpl service;

    @PostMapping
    public AvaliacaoFisicaForm create(@RequestBody AvaliacaoFisicaForm form) throws AlunoNotFoundException {
        return service.create(form);
    }

    @GetMapping("/{id}")
    public AvaliacaoFisicaForm get(@PathVariable Long id) throws AvaliacaoNotFoundException {
        return service.get(id);
    }

    @GetMapping
    public List<AvaliacaoFisicaForm> getAll() {
        return service.getAll();
    }

    @PatchMapping("/{id}")
    public AvaliacaoFisicaForm update(@PathVariable Long id, @Valid @RequestBody AvaliacaoFisicaUpdateForm updateForm) throws AvaliacaoNotFoundException {
        return service.update(id, updateForm);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) throws AvaliacaoNotFoundException {
        service.delete(id);
    }
}
