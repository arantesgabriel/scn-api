package com.project.scn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.scn.domain.Trabalho;
import com.project.scn.service.TrabalhoService;

@RestController
@CrossOrigin("*")
@RequestMapping("trabalho")
public class TrabalhoController {

	@Autowired
	TrabalhoService trabalhoService;
	
	@GetMapping("listarTrabalhos")
	public List<Trabalho> listarTrabalhos() {
		return trabalhoService.listarTrabalhos();
	}

	@PostMapping("cadastrarTrabalho")
	public ResponseEntity<?> cadastrarTrabalho(@RequestBody Trabalho trabalho) {
		try {
			return ResponseEntity.ok(trabalhoService.cadastrarTrabalho(trabalho));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(e.getMessage());
		}
	}

}