package com.project.scn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.scn.domain.Semestre;
import com.project.scn.service.SemestreService;

import jakarta.annotation.PostConstruct;

@RestController
@CrossOrigin
@RequestMapping("semestre")
public class SemestreController {

    @Autowired
    SemestreService semestreService;

    @PostConstruct
    public void gerarSemestre() {
        semestreService.gerarNovoSemestreAutomatico();
    }

    @PostMapping("salvarSemestre")
    public ResponseEntity<?> salvarSemestre(@RequestBody Semestre semestre) {
        try {
            return ResponseEntity.ok(semestreService.salvarSemestre(semestre));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(e.getMessage());
        }
    }

    @GetMapping("ultimoSemestre")
    public Semestre ultimoSemestre() {
        return semestreService.exibirUltimoSemestre();
    }
}