package com.project.scn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.scn.DTO.CursoDTO;
import com.project.scn.service.CursoService;

@RestController
@CrossOrigin("*")
public class CursoController {
	
	@Autowired
	CursoService cursoService;
	
	@PostMapping("cadastroCurso")
	public ResponseEntity<String> CadastrarCurso(@RequestBody CursoDTO cursoDTO) {
		try {
			cursoService.CadastrarCurso(cursoDTO);			
		} catch (NullPointerException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("É preciso informar todos os campos");
		}
		return ResponseEntity.ok("Curso cadastrado com sucesso");
	}
	
}
