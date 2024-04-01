package com.project.scn.controller;

import com.project.scn.domain.GradeCurricular;
import com.project.scn.service.GradeCurricularService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GradeController {

    @Autowired
    GradeCurricularService gradeCurricularService;

    @GetMapping("listarGrades")
    public List<GradeCurricular> listarGrades() {
        return gradeCurricularService.listarGrades();
    }

    @PostMapping("cadastrarGrade")
    public ResponseEntity<?> cadastrarGrade(@RequestBody GradeCurricular grade) {
        try {
            return ResponseEntity.ok(gradeCurricularService.cadastrarGrade(grade));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(e.getMessage());
        }
    }

}
