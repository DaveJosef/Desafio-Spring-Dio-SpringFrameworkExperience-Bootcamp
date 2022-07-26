package me.dio.academia.digital.mapper;

import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaForm;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AvaliacaoMapper {

    AvaliacaoMapper INSTANCE = Mappers.getMapper(AvaliacaoMapper.class);

    @Mapping(source = "alunoId", target = "aluno.id")
    AvaliacaoFisica toModel(AvaliacaoFisicaForm form);

    @Mapping(source = "aluno.id", target = "alunoId")
    AvaliacaoFisicaForm toForm(AvaliacaoFisica avaliacaoFisica);
}
