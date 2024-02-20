package com.project.scn.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.scn.domain.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {

    @Query("SELECT cs FROM Curso cs WHERE :codigo = cs.codigo")
    Optional<Curso> buscarCursoPorCodigo(Long codigo);

}
