package com.project.scn.service;

import com.project.scn.DTO.AlunoDTO;
import com.project.scn.domain.Aluno;

import java.util.List;

public interface AlunoService {

    String efetuarLogin(AlunoDTO alunoDTO) throws Exception;

    List<Aluno> listarAlunos() throws Exception;
    void cadastrarAluno(Aluno aluno) throws Exception;

}
