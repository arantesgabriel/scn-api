package com.project.scn.service;

import java.util.List;

import com.project.scn.DTO.DisciplinaDTO;
import com.project.scn.domain.Disciplina;

public interface DisciplinaService {

    List<Disciplina> listarDisciplinas();

    String cadastrarDisciplina(DisciplinaDTO disciplinaDTO) throws Exception;

    String adicionarDisciplina(DisciplinaDTO disciplinaDTO);

}
