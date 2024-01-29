package com.project.scn.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.scn.DTO.CursoDTO;
import com.project.scn.domain.Curso;
import com.project.scn.service.CursoService;

@RestController
@CrossOrigin("*")
public class CursoController {

	@Autowired
	CursoService cursoService;

	@GetMapping("buscarCurso/{codigo}")
	public ResponseEntity<?> buscarCurso(@PathVariable Long codigo) {
		Optional<Curso> curso = cursoService.buscarCurso(codigo);
		if (curso.isEmpty()) {
			return ResponseEntity.ok("Nenhum curso encontrado");
		} else {
			return ResponseEntity.ok(curso);
		}
	}

//	@PostMapping("cadastroCurso")
//	public ResponseEntity<String> cadastrarCurso(@RequestBody CursoDTO cursoDTO) {
//		if (cursoDTO.getNome().trim() == null || cursoDTO.getDuracao() == null) {
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("É preciso informar todos os campos");
//		}
//		return ResponseEntity.ok(cursoService.cadastrarCurso(cursoDTO));
//	}

}