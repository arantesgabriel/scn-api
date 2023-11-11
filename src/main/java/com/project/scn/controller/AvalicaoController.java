package com.project.scn.controller;

import com.project.scn.domain.Avaliacao;
import com.project.scn.domain.Trabalho;
import com.project.scn.service.AvaliacaoService;
import com.project.scn.service.TrabalhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AvalicaoController {

    @Autowired
    AvaliacaoService avaliacaoService;

    @PostMapping("cadastrarAvaliacao")
    public ResponseEntity cadastrarAvaliacao(@RequestBody Avaliacao avaliacao) {
        try {
            return ResponseEntity.ok(avaliacaoService.cadastrarAvaliacao(avaliacao));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(e.getMessage());
        }
    }

    @GetMapping("listarAvaliacoes")
    public List<Avaliacao> listarAvaliacoes() {
        return avaliacaoService.listarAvaliacoes();
    }

}
