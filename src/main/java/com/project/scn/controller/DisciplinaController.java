package com.project.scn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("cadastrarDisciplina")
    public ResponseEntity<?> cadastrarDisciplina(@RequestBody DisciplinaDTO disciplinaDTO) {
        try {
            return ResponseEntity.ok(disciplinaService.cadastrarDisciplina(disciplinaDTO));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(e.getMessage());
        }
    }

    @PostMapping("adicionarDisciplina")
    public ResponseEntity<?> adicionarDisciplina(@RequestBody DisciplinaDTO disciplinaDTO) {
        return ResponseEntity.ok(disciplinaService.adicionarDisciplina(disciplinaDTO));
    }

}