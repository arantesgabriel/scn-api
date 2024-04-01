package com.project.scn.service;

import com.project.scn.domain.Semestre;

public interface SemestreService {
    String salvarSemestre(Semestre semestre) throws Exception;

    void gerarNovoSemestreAutomatico();

    Semestre exibirUltimoSemestre();

}
