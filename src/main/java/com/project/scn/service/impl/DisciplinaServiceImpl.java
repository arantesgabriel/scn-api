package com.project.scn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.scn.DTO.DisciplinaDTO;
import com.project.scn.domain.Aluno;
import com.project.scn.domain.Disciplina;
import com.project.scn.domain.RelacaoAlunoDisciplina;
import com.project.scn.domain.RelacaoAlunoDisciplinaPK;
import com.project.scn.repository.DisciplinaRepository;
import com.project.scn.service.AlunoService;
import com.project.scn.service.DisciplinaService;
import com.project.scn.service.RelacaoAlunoDisciplinaService;

@Service
public class DisciplinaServiceImpl implements DisciplinaService {

	@Autowired
	DisciplinaRepository disciplinaRepository;

	@Autowired
	AlunoService alunoService;

	@Autowired
	RelacaoAlunoDisciplinaService relacaoAlunoDisciplinaService;

	@Override
	public List<Disciplina> buscarDisciplinas() {
		return disciplinaRepository.findAll();
	}

	public Disciplina buscarDisciplina(Long codigoDisciplina) {
		return disciplinaRepository.findById(codigoDisciplina).orElseThrow(null);
	}

	public String adicionarDisciplina(DisciplinaDTO disciplinaDTO) {
		Aluno aluno = alunoService.buscarAluno(disciplinaDTO.getCodigoAluno());
		Disciplina disciplina = buscarDisciplina(disciplinaDTO.getCodigo());
		RelacaoAlunoDisciplinaPK pkRelacao = new RelacaoAlunoDisciplinaPK(aluno.getCodigo(), disciplina.getCodigo());
		RelacaoAlunoDisciplina novaRelacao = new RelacaoAlunoDisciplina();
		novaRelacao.setPkRelacao(pkRelacao);
		relacaoAlunoDisciplinaService.salvar(novaRelacao);
		return "Disciplina adicionada ao aluno";
	}
}