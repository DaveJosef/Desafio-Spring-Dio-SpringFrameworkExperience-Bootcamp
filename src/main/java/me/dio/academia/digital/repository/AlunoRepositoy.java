package me.dio.academia.digital.repository;

import me.dio.academia.digital.entity.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AlunoRepositoy extends JpaRepository<Aluno, Long> {

    /**
     * @param dataDeNascimento - data de nascimento dos alunos.
     * @return lista de todos os alunos que nasceram na data especificada como parâmetro.
     * */
    List<Aluno> findByDataDeNascimento(LocalDate dataDeNascimento);

}
