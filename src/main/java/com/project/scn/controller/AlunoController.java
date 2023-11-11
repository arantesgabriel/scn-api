package com.project.scn.controller;

import com.project.scn.DTO.AlunoDTO;
import com.project.scn.domain.Aluno;
import com.project.scn.service.AlunoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AlunoController {

    @Autowired
    AlunoService alunoService;

    @GetMapping("listarAlunos")
    public List<Aluno> buscarAlunos() throws Exception {
        return alunoService.listarAlunos();
    }

    @DeleteMapping("/deletarAluno/{codigo}")
    public ResponseEntity deletarAluno(@PathVariable Long codigo) {
        try {
            return ResponseEntity.ok(alunoService.deletarAluno(codigo));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping("efetuarLogin")
    public ResponseEntity efetuarLogin(@RequestBody AlunoDTO alunoDTO) {
        try {
            return ResponseEntity.ok(alunoService.efetuarLogin(alunoDTO));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }

    @PostMapping("cadastroAluno")
    public ResponseEntity efetuarCadastro(@RequestBody Aluno aluno) {
        try {
            return ResponseEntity.ok(alunoService.cadastrarAluno(aluno));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(e.getMessage());
        }
    }

}
