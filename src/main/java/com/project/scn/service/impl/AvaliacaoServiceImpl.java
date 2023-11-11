package com.project.scn.service.impl;

import com.project.scn.domain.Avaliacao;
import com.project.scn.domain.Trabalho;
import com.project.scn.repository.AvaliacaoRepository;
import com.project.scn.repository.TrabalhoRepository;
import com.project.scn.service.AvaliacaoService;
import com.project.scn.service.TrabalhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvaliacaoServiceImpl implements AvaliacaoService {

    @Autowired
    AvaliacaoRepository avaliacaoRepository;

    public String cadastrarAvaliacao(Avaliacao avaliacao) throws Exception {

        if (avaliacao.getNome().isEmpty()) {
            throw new Exception("Preencha corretamente o campo 'nome'.");
        }
        if (avaliacao.getNotaTotal() == null) {
            throw new Exception("Preencha corretamente o campo 'nota total'.");
        }
        if (avaliacao.getNotaFinal() == null) {
            throw new Exception("Preencha corretamente o campo 'nota final'.");
        }
        if (avaliacao.getData() == null) {
            throw new Exception("Preencha corretamente o campo 'data'.");
        } else {
            avaliacaoRepository.save(avaliacao);
            return ("Trabalho cadastrado com sucesso!");
        }
    }

    public List<Avaliacao> listarAvaliacoes() {
        List<Avaliacao> listaAvaliacoes = avaliacaoRepository.findAll();
        return listaAvaliacoes;
    }

}
