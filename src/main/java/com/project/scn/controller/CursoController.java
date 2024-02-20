package com.project.scn.controller;

import java.util.List;
import java.util.Optional;

import com.project.scn.DTO.GradeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.project.scn.DTO.CursoDTO;
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
    public ResponseEntity<String> cadastrarCurso(@RequestBody CursoDTO cursoDTO) {
        if (cursoDTO.getNome().trim() == null || cursoDTO.getDuracao() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("É preciso informar todos os campos.");
        }
        return ResponseEntity.ok(cursoService.cadastrarCurso(cursoDTO));
    }

    @PutMapping("associarGrade")
    public ResponseEntity<String> associarGradeCurricular(@RequestBody Long codigoCurso, Long codigoGrade) {
        try {
            return ResponseEntity.ok(cursoService.associarGradeCurricular(codigoCurso, codigoGrade));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

}