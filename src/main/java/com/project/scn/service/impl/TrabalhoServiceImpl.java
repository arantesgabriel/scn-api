package com.project.scn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.scn.domain.Trabalho;
import com.project.scn.repository.TrabalhoRepository;
import com.project.scn.service.TrabalhoService;

@Service
public class TrabalhoServiceImpl implements TrabalhoService {

	@Autowired
	TrabalhoRepository trabalhoRepository;

	@Override
	public List<Trabalho> listarTrabalhos() {
		return trabalhoRepository.findAll();
	}

	@Override
	public String cadastrarTrabalho(Trabalho trabalho) throws NoSuchFieldException {
		validarCamposTrabalho(trabalho);
		trabalhoRepository.save(trabalho);
		return ("Trabalho cadastrado com sucesso!");
	}

	@Override
	public void validarCamposTrabalho(Trabalho trabalho) throws NoSuchFieldException {
		if (trabalho.getNome() == null || trabalho.getNome().trim().isEmpty()) {
			throw new NoSuchFieldException("Preencha corretamente o campo 'nome'");
		}
		if (trabalho.getNotaTotal() == null) {
			throw new NoSuchFieldException("Preencha corretamente o campo 'nota total'.");
		}
		if (trabalho.getDataEntrega() == null) {
			throw new NoSuchFieldException("Preencha corretamente o campo 'nota total'.");
		}
	}

}