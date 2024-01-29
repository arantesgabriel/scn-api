package com.project.scn.domain;

import java.io.Serializable;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "trelacaoalndcp")
public class RelacaoAlunoDisciplina implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	RelacaoAlunoDisciplinaPK pkRelacao;

	public RelacaoAlunoDisciplinaPK getPkRelacao() {
		return pkRelacao;
	}

	public void setPkRelacao(RelacaoAlunoDisciplinaPK pkRelacao) {
		this.pkRelacao = pkRelacao;
	}

}