package com.project.scn.service;

import java.util.List;

import com.project.scn.domain.Avaliacao;

public interface AvaliacaoService {

	List<Avaliacao> listarAvaliacoes();

	String cadastrarAvaliacao(Avaliacao avaliacao) throws NoSuchFieldException;

	void validarCamposAvaliacao(Avaliacao avaliacao) throws NoSuchFieldException;

}