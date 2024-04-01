package com.project.scn.service;

import com.project.scn.domain.Semestre;

public interface SemestreService {
	
	void gerarNovoSemestreAutomatico();

	String salvarSemestre(Semestre semestre) throws Exception;

    Semestre exibirUltimoSemestre();

}