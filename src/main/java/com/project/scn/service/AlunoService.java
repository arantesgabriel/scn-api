package com.project.scn.service;

import java.util.List;

import com.project.scn.DTO.AlunoDTO;
import com.project.scn.domain.Aluno;

public interface AlunoService {

	List<Aluno> buscarAlunos() throws Exception;
			
	Aluno buscarAluno(Long codigoAluno);
	
	String cadastrarAluno(Aluno aluno) throws Exception;
		
	String efetuarLogin(AlunoDTO alunoDTO) throws Exception;
	
}