package com.project.scn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.scn.domain.Cra;
import com.project.scn.repository.CraRepository;
import com.project.scn.service.CraService;

@Service
public class CraServiceImpl implements CraService {
	
	@Autowired
	CraRepository craRepository;
	
	public Cra gerarCra() {
		Cra cra = new Cra();
		cra.setMediaCurso(0.0);
		cra.setMediaSemestre(0.0);
		craRepository.save(cra);
		return cra;
	}

}
