package com.project.scn.service;

import java.util.List;

import com.project.scn.DTO.DisciplinaDTO;
import com.project.scn.domain.Disciplina;

public interface DisciplinaService {

    List<Disciplina> listarDisciplinas();

    public Disciplina buscarDisciplinaPorNome(String nomeDisciplina);

    public Disciplina buscarDisciplinaPorCodigo(Long codigoDisciplina);

    String cadastrarDisciplina(DisciplinaDTO disciplinaDTO) throws Exception;

}
