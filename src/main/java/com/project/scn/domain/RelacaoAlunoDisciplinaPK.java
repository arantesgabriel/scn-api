package com.project.scn.domain;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class RelacaoAlunoDisciplinaPK implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "codaln")
	private Long aluno;
	@Column(name = "coddcp")
	private Long disciplina;

	public RelacaoAlunoDisciplinaPK() {
		super();
	}

	public RelacaoAlunoDisciplinaPK(Long aluno, Long disciplina) {
		super();
		this.aluno = aluno;
		this.disciplina = disciplina;
	}

	public Long getAluno() {
		return aluno;
	}

	public void setAluno(Long aluno) {
		this.aluno = aluno;
	}

	public Long getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Long disciplina) {
		this.disciplina = disciplina;
	}

}