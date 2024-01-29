package com.project.scn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.scn.DTO.AlunoDTO;
import com.project.scn.domain.Aluno;
import com.project.scn.service.AlunoService;

@RestController
public class AlunoController {

	@Autowired
	AlunoService alunoService;

	@GetMapping("buscarAlunos")
	public List<Aluno> buscarAlunos() throws Exception {
		return alunoService.buscarAlunos();
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

}