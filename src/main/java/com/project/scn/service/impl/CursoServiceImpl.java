package com.project.scn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.scn.DTO.CursoDTO;
import com.project.scn.domain.Curso;
import com.project.scn.domain.Semestre;
import com.project.scn.mapper.CursoMapper;
import com.project.scn.repository.CursoRepository;
import com.project.scn.service.CursoService;

@Service
public class CursoServiceImpl implements CursoService {
	
	@Autowired
	CursoMapper cursoMapper;
	@Autowired
	CursoRepository cursoRepository;

	@Override
	public void CadastrarCurso(CursoDTO cursoDTO) throws NullPointerException {
		if(cursoDTO != null) {
			Curso curso = new Curso();
			cursoDTO.setNome(cursoDTO.getNome().toUpperCase());
			cursoMapper.DTOParaCurso(cursoDTO, curso);
			cursoRepository.save(curso);
		} else {
			throw new NullPointerException();
		}
	}
	
}