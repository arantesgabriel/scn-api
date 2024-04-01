package com.project.scn.service;

import java.util.List;

import com.project.scn.domain.Avaliacao;

public interface AvaliacaoService {

	String cadastrarAvaliacao(Avaliacao avaliacao) throws Exception;

	List<Avaliacao> listarAvaliacoes();

}
