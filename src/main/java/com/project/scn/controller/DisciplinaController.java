package com.project.scn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.scn.DTO.DisciplinaDTO;
import com.project.scn.domain.Disciplina;
import com.project.scn.service.DisciplinaService;

@RestController
@CrossOrigin("*")
@RequestMapping("disciplina")
public class DisciplinaController {

    @Autowired
    DisciplinaService disciplinaService;

    @GetMapping("listarDisciplinas")
    public List<Disciplina> listarDisciplinas() {
        return disciplinaService.listarDisciplinas();
    }

    @GetMapping("buscarDisciplinaPorNome/{nomeDisciplina}")
    public Disciplina buscarDisciplinaPorNome(@PathVariable String nomeDisciplina) throws Exception {
        return disciplinaService.buscarDisciplinaPorNome(nomeDisciplina);
    }

    @GetMapping("buscarDisciplinaPorCodigo/{codigoDisciplina}")
    public ResponseEntity<?> buscarDisciplinaPorCodigo(@PathVariable Long codigoDisciplina) {
        try {
            return ResponseEntity.ok(disciplinaService.buscarDisciplinaPorCodigo(codigoDisciplina));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(e.getMessage());
        }
    }

    @PostMapping("cadastrarDisciplina")
    public ResponseEntity<?> cadastrarDisciplina(@RequestBody DisciplinaDTO disciplinaDTO) {
        try {
            return ResponseEntity.ok(disciplinaService.cadastrarDisciplina(disciplinaDTO));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(e.getMessage());
        }
    }

}