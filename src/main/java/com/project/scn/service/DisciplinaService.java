package com.project.scn.service;

import java.util.List;
import java.util.Optional;

import com.project.scn.DTO.DisciplinaDTO;
import com.project.scn.domain.Disciplina;

public interface DisciplinaService {

    List<Disciplina> listarDisciplinas();

    public Disciplina buscarDisciplinaPorNome(String nomeDisciplina) throws Exception;

    public Disciplina buscarDisciplinaPorCodigo(Long codigoDisciplina) throws Exception;

    String cadastrarDisciplina(DisciplinaDTO disciplinaDTO) throws Exception;

}
