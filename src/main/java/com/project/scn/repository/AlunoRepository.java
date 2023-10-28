package com.project.scn.repository;

import com.project.scn.domain.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    boolean existsByUsuarioAndSenha(String usuario, String senha) throws Exception;

}
