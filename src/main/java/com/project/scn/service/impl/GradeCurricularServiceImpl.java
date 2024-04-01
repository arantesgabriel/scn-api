package com.project.scn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.scn.domain.GradeCurricular;
import com.project.scn.repository.GradeCurricularRepository;
import com.project.scn.service.GradeCurricularService;

@Service
public class GradeCurricularServiceImpl implements GradeCurricularService {

    @Autowired
    GradeCurricularRepository gradeCurricularRepository;

    public List<GradeCurricular> listarGrades() {
        return gradeCurricularRepository.findAll();
    }

    public String cadastrarGrade(GradeCurricular grade) throws Exception {
        if (grade.getCodigoSemestre() == null) {
            throw new Exception("Preencha corretamente o campo 'codigoSemestre'");
        } else {
            GradeCurricular novaGrade = new GradeCurricular();
            novaGrade.setCodigoSemestre(grade.getCodigoSemestre());
            novaGrade.setIndicadorAtivo(true);
            gradeCurricularRepository.save(novaGrade);
        }
        return ("Grade cadastrada com sucesso!");
    }
}
