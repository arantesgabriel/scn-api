package com.project.scn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.scn.domain.Curso;
import com.project.scn.repository.CursoRepository;
import com.project.scn.service.CursoService;

@Service
public class CursoServiceImpl implements CursoService {

	@Autowired
	CursoRepository cursoRepository;

	public List<Curso> listarCursos() {
		return cursoRepository.findAll();
	}

	public String cadastrarCurso(Curso curso) throws Exception {
		if (curso.getNome().isEmpty() || curso.getNome() == null) {
			throw new Exception("Preencha o campo 'nome' corretamente.");
		}
		if (curso.getCodigoGrade() == null) {
			throw new Exception("Preencha o campo 'codigoGrade' corretamente.");
		} else {
			Curso novoCurso = new Curso();
			novoCurso.setNome(curso.getNome().toUpperCase());
			novoCurso.setDuracao(curso.getDuracao());
			novoCurso.setCodigoGrade(curso.getCodigoGrade());
			novoCurso.setIndicadorAtivo(true);
			cursoRepository.save(novoCurso);
			return "Curso cadastrado com sucesso!";
		}
	}

}