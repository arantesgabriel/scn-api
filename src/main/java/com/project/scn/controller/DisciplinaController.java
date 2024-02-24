package com.project.scn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.project.scn.DTO.DisciplinaDTO;
import com.project.scn.domain.Disciplina;
import com.project.scn.service.DisciplinaService;

@RestController
@CrossOrigin("*")
public class DisciplinaController {

    @Autowired
    DisciplinaService disciplinaService;

    @GetMapping("listarDisciplinas")
    public List<Disciplina> listarDisciplinas() {
        return disciplinaService.listarDisciplinas();
    }

    @GetMapping("buscarDisciplinaPorNome/{nome}")
    public Disciplina buscarDisciplinaPorNome(@PathVariable String nomeDisciplina) {
        return disciplinaService.buscarDisciplinaPorNome(nomeDisciplina);
    }

    @GetMapping("buscarDisciplinaPorCodigo/{codigo}")
    public Disciplina buscarDisciplinaPorCodigo(@PathVariable Long codigoDisciplina) {
        return disciplinaService.buscarDisciplinaPorCodigo(codigoDisciplina);
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