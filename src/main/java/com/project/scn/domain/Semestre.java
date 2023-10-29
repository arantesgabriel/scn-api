package com.project.scn.domain;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tsemestre")
public class Semestre implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codsm")
	private Long codigo;
	@Column(name = "nomedsm")
	private String nome;
	@Column(name = "mediasm")
	private Float mediaTotal;
	@Column(name = "statusaprvsm")
	private Boolean statusAprovacao;
	@ManyToOne
	@JoinColumn(name = "coddcp", referencedColumnName = "coddcp")
	private Disciplina disciplina;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Float getMediaTotal() {
		return mediaTotal;
	}

	public void setMediaTotal(Float mediaTotal) {
		this.mediaTotal = mediaTotal;
	}

	public Boolean getStatusAprovacao() {
		return statusAprovacao;
	}

	public void setStatusAprovacao(Boolean statusAprovacao) {
		this.statusAprovacao = statusAprovacao;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

}
