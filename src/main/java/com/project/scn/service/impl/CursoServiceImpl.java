package com.project.scn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.scn.domain.Aluno;
import com.project.scn.domain.Curso;
import com.project.scn.repository.CursoRepository;
import com.project.scn.service.AlunoService;
import com.project.scn.service.CursoService;

@Service
public class CursoServiceImpl implements CursoService {

	@Autowired
	CursoRepository cursoRepository;
	@Autowired
	AlunoService alunoService;

	@Override
	public List<Curso> listarCursos() {
		return cursoRepository.listarCursos();
	}

	@Override
	public String cadastrarCurso(Curso curso) throws NoSuchFieldException {
		validarCamposCurso(curso);
		if (cursoRepository.existsByNome(curso.getNome().toUpperCase())) {
			return "Curso já existe";
		} else {
			curso.setNome(curso.getNome().toUpperCase());
			cursoRepository.save(curso);
			return "Novo Curso cadastrado com sucesso";
		}
	}

	@Override
	public void validarCamposCurso(Curso curso) throws NoSuchFieldException {
		if (curso.getNome() == null || curso.getNome().trim().isEmpty()) {
			throw new NoSuchFieldException("Preencha o campo 'nome' corretamente.");
		}
		if (curso.getDuracao() == null) {
			throw new NoSuchFieldException("Preencha o campo 'duração' corretamente.");
		}
	}

	@Override
	public String adicionarAluno(Curso curso, Long codigo) throws NoSuchFieldException {
		if (cursoRepository.existsById(curso.getCodigo())) {
			Aluno aluno = alunoService.buscarAlunoCodigo(codigo).orElse(null);
			if (aluno != null) {
				curso.setAluno(aluno);
				cursoRepository.save(curso);
				return "Curso adicionado com sucesso";
			} else {
				throw new NoSuchFieldException("Aluno não encontrado");
			}
		} else {
			throw new NoSuchFieldException("Curso não encontrado");
		}
	}

}