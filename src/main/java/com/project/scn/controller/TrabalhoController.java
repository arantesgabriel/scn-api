package com.project.scn.controller;

import com.project.scn.domain.Trabalho;
import com.project.scn.service.TrabalhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TrabalhoController {

    @Autowired
    TrabalhoService trabalhoService;

    @PostMapping("cadastrarTrabalho")
    public ResponseEntity cadastrarTrabalho(@RequestBody Trabalho trabalho) {
        try {
            return ResponseEntity.ok(   trabalhoService.cadastrarTrabalho(trabalho));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(e.getMessage());
        }
    }

    @GetMapping("listarTrabalhos")
    public List<Trabalho> listarTrabalhos() {
        return trabalhoService.listarTrabalhos();
    }

}
