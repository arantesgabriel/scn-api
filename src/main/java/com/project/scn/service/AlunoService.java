package com.project.scn.service;

import java.nio.file.AccessDeniedException;
import java.util.List;
import java.util.Optional;

import com.project.scn.DTO.AlunoDTO;
import com.project.scn.domain.Aluno;

public interface AlunoService {

	List<Aluno> listarAlunos();

	String cadastrarAluno(Aluno aluno) throws NoSuchFieldException;

	String efetuarLogin(AlunoDTO alunoDTO) throws AccessDeniedException, NoSuchFieldException;

	String deletarAluno(Long codigo) throws NoSuchFieldException;

	void validarCamposAluno(Aluno aluno) throws NoSuchFieldException;

	Optional<Aluno> buscarAlunoCodigo(Long codigo);

}