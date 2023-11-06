package com.project.scn.service;

import java.util.Optional;

import com.project.scn.DTO.CursoDTO;
import com.project.scn.domain.Curso;

public interface CursoService {

	String CadastrarCurso(CursoDTO cursoDTO);

	Optional<Curso> BuscarCurso(Long codigo);

}
