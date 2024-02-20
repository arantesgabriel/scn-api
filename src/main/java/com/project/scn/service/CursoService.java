package com.project.scn.service;

import java.util.List;
import java.util.Optional;

import com.project.scn.DTO.CursoDTO;
import com.project.scn.domain.Curso;

public interface CursoService {

    List<Curso> listarCursos() throws Exception;

    String cadastrarCurso(CursoDTO cursoDTO);

    String associarGradeCurricular(Long codigoCurso, Long codigoGrade) throws Exception;

    Optional<Curso> buscarCursoPorCodigo(Long codigo);

}