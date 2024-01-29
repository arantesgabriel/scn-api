package com.project.scn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.scn.domain.RelacaoAlunoDisciplina;
import com.project.scn.repository.RelacaoAlunoDisciplinaRepository;
import com.project.scn.service.RelacaoAlunoDisciplinaService;

@Service
public class RelacaoAlunoDisciplinaServiceImpl implements RelacaoAlunoDisciplinaService {

	@Autowired
	RelacaoAlunoDisciplinaRepository relacaoAlunoDisciplinaRepository;

	public void salvar(RelacaoAlunoDisciplina relacaoAlunoDisciplina) {
		relacaoAlunoDisciplinaRepository.save(relacaoAlunoDisciplina);
	}
}
