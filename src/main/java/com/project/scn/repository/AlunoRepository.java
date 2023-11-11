package com.project.scn.repository;

import com.project.scn.domain.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    boolean existsByUsuario(String usuario) throws Exception;

    Aluno findAlunoByUsuario(String usuario) throws Exception;


}