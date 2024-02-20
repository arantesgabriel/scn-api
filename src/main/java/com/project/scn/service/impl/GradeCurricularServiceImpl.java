package com.project.scn.service.impl;

import com.project.scn.domain.GradeCurricular;
import com.project.scn.repository.GradeCurricularRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GradeCurricularServiceImpl implements GradeCurricularService {

    @Autowired
    GradeCurricularRepository gradeCurricularRepository;

    public String cadastrarGrade(GradeCurricular grade) throws Exception {
        if (grade.getNumeroPeriodo() == null) {
            throw new Exception("Preencha o campo 'número do período' corretamente.");
        }
        GradeCurricular gradeCurricular = new GradeCurricular();
        gradeCurricular.setNumeroPeriodo(grade.getNumeroPeriodo());
        gradeCurricular.setDisciplinas(grade.getDisciplinas());
        return ("Grade cadastrada com sucesso");
    }
}
