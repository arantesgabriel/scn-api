package com.project.scn.controller;

import java.util.List;

import com.project.scn.DTO.AlunoStatusRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.project.scn.DTO.AlunoDTO;
import com.project.scn.domain.Aluno;
import com.project.scn.service.AlunoService;

@RestController
public class AlunoController {

    @Autowired
    AlunoService alunoService;

    @GetMapping("listarAlunos")
    public List<Aluno> listarAlunos() throws Exception {
        return alunoService.listarAlunos();
    }

    @PostMapping("efetuarLogin")
    public ResponseEntity<?> efetuarLogin(@RequestBody AlunoDTO alunoDTO) {
        try {
            return ResponseEntity.ok(alunoService.efetuarLogin(alunoDTO));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }

    @PostMapping("cadastrarAluno")
    public ResponseEntity<?> cadastrarAluno(@RequestBody Aluno aluno) {
        try {
            return ResponseEntity.ok(alunoService.cadastrarAluno(aluno));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(e.getMessage());
        }
    }

    @PatchMapping("alterarStatusAluno")
    public ResponseEntity<String> alterarStatusAluno(@RequestBody AlunoStatusRequestDTO aluno) {
        try {
            alunoService.alterarStatusAluno(aluno);
            return ResponseEntity.ok("Status do aluno alterado com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao alterar o status do aluno: " + e.getMessage());
        }
    }

}