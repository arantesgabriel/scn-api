package com.project.scn.controller;

import com.project.scn.DTO.AlunoDTO;
import com.project.scn.service.impl.AlunoServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlunoController {

    @Autowired
    AlunoServiceImpl alunoService;

    @PostMapping("efetuarLogin")
    public ResponseEntity<String> efetuarLogin(@RequestBody AlunoDTO alunoDTO) throws Exception {
        return ResponseEntity.ok(alunoService.validarLogin(alunoDTO));
    }

}
