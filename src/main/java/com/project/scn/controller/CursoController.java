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

import com.project.scn.domain.Curso;
import com.project.scn.service.CursoService;

@RestController
@CrossOrigin("*")
@RequestMapping("curso")
public class CursoController {

    @Autowired
    CursoService cursoService;

    @GetMapping("listarCursos")
    public List<Curso> listarCursos() throws Exception {
        return cursoService.listarCursos();
    }

    @PostMapping("cadastrarCurso")
    public ResponseEntity<?> cadastrarCurso(@RequestBody Curso curso) {
        try {
            return ResponseEntity.ok(cursoService.cadastrarCurso(curso));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(e.getMessage());
        }
    }

}