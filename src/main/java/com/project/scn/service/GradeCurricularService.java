package com.project.scn.service;

import java.util.List;

import com.project.scn.domain.GradeCurricular;

public interface GradeCurricularService {
	
    public List<GradeCurricular> listarGrades();

    public String cadastrarGrade(GradeCurricular gradeCurricular) throws Exception;

}