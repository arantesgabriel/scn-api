package com.project.scn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.scn.domain.Avaliacao;
import com.project.scn.repository.AvaliacaoRepository;
import com.project.scn.service.AvaliacaoService;

@Service
public class AvaliacaoServiceImpl implements AvaliacaoService {

	@Autowired
	AvaliacaoRepository avaliacaoRepository;

	@Override
	public List<Avaliacao> listarAvaliacoes() {
		return avaliacaoRepository.findAll();
	}

	@Override
	public String cadastrarAvaliacao(Avaliacao avaliacao) throws NoSuchFieldException {
		validarCamposAvaliacao(avaliacao);
		avaliacaoRepository.save(avaliacao);
		return ("Trabalho cadastrado com sucesso!");

	}

	@Override
	public void validarCamposAvaliacao(Avaliacao avaliacao) throws NoSuchFieldException {
		if (avaliacao.getNome() == null || avaliacao.getNome().isEmpty()) {
			throw new NoSuchFieldException("Preencha corretamente o campo 'nome'.");
		}
		if (avaliacao.getNotaTotal() == null) {
			throw new NoSuchFieldException("Preencha corretamente o campo 'nota total'.");
		}
		if (avaliacao.getData() == null) {
			throw new NoSuchFieldException("Preencha corretamente o campo 'data'.");
		}
	}

}