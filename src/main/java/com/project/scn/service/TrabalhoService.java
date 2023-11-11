package com.project.scn.service;

import com.project.scn.DTO.AlunoDTO;
import com.project.scn.domain.Aluno;
import com.project.scn.domain.Trabalho;

import java.util.List;

public interface TrabalhoService {

    String cadastrarTrabalho(Trabalho trabalho) throws Exception;

    List<Trabalho> listarTrabalhos();

}
