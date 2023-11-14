package com.project.scn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.scn.domain.Curso;
import com.project.scn.service.CursoService;

@RestController
@CrossOrigin("*")
public class CursoController {

	@Autowired
	CursoService cursoService;

	@GetMapping("listarCursos")
	public ResponseEntity<List<Curso>> listarCursos() {
		return ResponseEntity.ok(cursoService.listarCursos());
	}

	@PostMapping("cadastroCurso")
	public ResponseEntity<String> CadastrarCurso(@RequestBody Curso curso) {
		try {
			return ResponseEntity.ok(cursoService.cadastrarCurso(curso));
		} catch (NoSuchFieldException e) {
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(e.getMessage());
		}
	}

	@PostMapping("adicionarAluno/{codigo}")
	public ResponseEntity<String> adicionarCurso(@RequestBody Curso curso, @RequestParam Long codigo) {
		try {
			return ResponseEntity.ok(cursoService.adicionarAluno(curso, codigo));
		} catch (NoSuchFieldException e) {
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(e.getMessage());
		}
	}

}