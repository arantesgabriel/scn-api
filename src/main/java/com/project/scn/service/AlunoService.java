package com.project.scn.service;

import com.project.scn.DTO.AlunoDTO;
import com.project.scn.domain.Aluno;

import java.util.List;
import java.util.Optional;

public interface AlunoService {

    String efetuarLogin(AlunoDTO alunoDTO) throws Exception;

    List<Aluno> listarAlunos() throws Exception;

    String cadastrarAluno(Aluno aluno) throws Exception;

    String deletarAluno(Long codigo) throws Exception;

}
