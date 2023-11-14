package com.project.scn.controller;

import java.nio.file.AccessDeniedException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.scn.DTO.AlunoDTO;
import com.project.scn.domain.Aluno;
import com.project.scn.service.AlunoService;

@RestController
@CrossOrigin("*")
public class AlunoController {

	@Autowired
	AlunoService alunoService;

	@GetMapping("listarAlunos")
	public List<Aluno> listarAlunos() {
		return alunoService.listarAlunos();
	}

	@PostMapping("cadastrarAluno")
	public ResponseEntity<String> cadastrarAluno(@RequestBody Aluno aluno) {
		try {
			return ResponseEntity.ok(alunoService.cadastrarAluno(aluno));
		} catch (NoSuchFieldException e) {
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(e.getMessage());
		}
	}

	@PostMapping("efetuarLogin")
	public ResponseEntity<String> efetuarLogin(@RequestBody AlunoDTO alunoDTO) {
		try {
			return ResponseEntity.ok(alunoService.efetuarLogin(alunoDTO));
		} catch (NoSuchFieldException | AccessDeniedException e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
		}
	}

	@DeleteMapping("/deletarAluno/{codigo}")
	public ResponseEntity<String> deletarAluno(@PathVariable Long codigo) {
		try {
			return ResponseEntity.ok(alunoService.deletarAluno(codigo));
		} catch (NoSuchFieldException e) {
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(e.getMessage());
		}
	}

}