package com.project.scn.controller;

import com.project.scn.domain.Semestre;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.project.scn.service.SemestreService;

@RestController
public class SemestreController {

    @Autowired
    SemestreService semestreService;

    @PostMapping("salvarSemestre")
    public ResponseEntity<?> salvarSemestre(@RequestBody Semestre semestre) {
        try {
            return ResponseEntity.ok(semestreService.salvarSemestre(semestre));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(e.getMessage());
        }
    }

    @PostConstruct
    public void gerarSemestre() {
        semestreService.gerarNovoSemestre();
    }

    @GetMapping("ultimoSemestre")
    public Semestre ultimoSemestre() {
        return semestreService.exibirUltimoSemestre();
    }
}