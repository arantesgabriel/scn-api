package com.project.scn.service;

import java.util.List;
import java.util.NoSuchElementException;

import com.project.scn.DTO.AlunoDTO;
import com.project.scn.DTO.AlunoStatusRequestDTO;
import com.project.scn.domain.Aluno;

public interface AlunoService {

    List<Aluno> listarAlunos() throws NoSuchElementException;

    Aluno buscarAluno(Long codigoAluno);

    String cadastrarAluno(Aluno aluno) throws Exception;

    String efetuarLogin(AlunoDTO alunoDTO) throws Exception;

    String alterarStatusAluno(AlunoStatusRequestDTO aluno) throws Exception;
}