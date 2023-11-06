package com.project.scn.controller;

import com.project.scn.DTO.AlunoDTO;
import com.project.scn.domain.Aluno;
import com.project.scn.service.AlunoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AlunoController {

    @Autowired
    AlunoService alunoService;

    @GetMapping("listarAlunos")
    public List buscarAlunos() throws Exception {
        return alunoService.listarAlunos();
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
    public void efetuarCadastro(@RequestBody Aluno aluno) throws Exception {
        alunoService.cadastrarAluno(aluno);
    }

}
