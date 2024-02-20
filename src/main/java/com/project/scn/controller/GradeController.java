package com.project.scn.controller;

import com.project.scn.domain.GradeCurricular;
import com.project.scn.service.impl.GradeCurricularService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GradeController {

    @Autowired
    GradeCurricularService gradeCurricularService;

    @PostMapping("cadastrarGrade")
    public ResponseEntity<?> cadastrarGrade(@RequestBody GradeCurricular grade) {
        try {
            return ResponseEntity.ok(gradeCurricularService.cadastrarGrade(grade));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(e.getMessage());
        }
    }

}
