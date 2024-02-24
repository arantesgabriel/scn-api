package com.project.scn.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.project.scn.domain.Curso;
import com.project.scn.service.CursoService;

@RestController
@CrossOrigin("*")
public class CursoController {

    @Autowired
    CursoService cursoService;

    @GetMapping("listarCursos")
    public List<Curso> listarCursos() throws Exception {
        return cursoService.listarCursos();
    }

    @GetMapping("buscarCursoPorCodigo/{codigo}")
    public ResponseEntity<?> buscarCursoPorCodigo(@PathVariable Long codigo) {
        Optional<Curso> curso = cursoService.buscarCursoPorCodigo(codigo);
        if (curso.isEmpty()) {
            return ResponseEntity.ok("Nenhum curso encontrado");
        } else {
            return ResponseEntity.ok(curso);
        }
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