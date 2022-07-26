package me.dio.academia.digital.mapper;

import me.dio.academia.digital.entity.Matricula;
import me.dio.academia.digital.entity.form.MatriculaForm;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MatriculaMapper {

    MatriculaMapper INSTANCE = Mappers.getMapper(MatriculaMapper.class);

    @Mapping(source = "alunoId", target = "aluno.id")
    Matricula toModel(MatriculaForm form);

    @Mapping(source = "aluno.id", target = "alunoId")
    MatriculaForm toForm(Matricula matricula);
}
