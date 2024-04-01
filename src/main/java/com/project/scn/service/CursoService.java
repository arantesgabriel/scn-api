package com.project.scn.service;

import java.util.List;

import com.project.scn.domain.Curso;

public interface CursoService {

    List<Curso> listarCursos() throws Exception;

    String cadastrarCurso(Curso curso) throws Exception;

}