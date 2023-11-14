package com.project.scn.service;

import java.util.List;

import com.project.scn.domain.Curso;
	
public interface CursoService {

	List<Curso> listarCursos();
	
	String cadastrarCurso(Curso curso) throws NoSuchFieldException;
	
	void validarCamposCurso(Curso curso) throws NoSuchFieldException;
	
	String adicionarAluno(Curso curso, Long codigo) throws NoSuchFieldException;
	
}