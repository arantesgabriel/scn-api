package com.project.scn.service;

import com.project.scn.domain.Avaliacao;
import com.project.scn.domain.Trabalho;

import java.util.List;

public interface AvaliacaoService {

    String cadastrarAvaliacao(Avaliacao avaliacao) throws Exception;

    List<Avaliacao> listarAvaliacoes();

}
