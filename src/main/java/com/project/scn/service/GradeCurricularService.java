package com.project.scn.service;

import com.project.scn.domain.GradeCurricular;

import java.util.List;

public interface GradeCurricularService {
    public List<GradeCurricular> listarGrades();

    public String cadastrarGrade(GradeCurricular gradeCurricular) throws Exception;

}
