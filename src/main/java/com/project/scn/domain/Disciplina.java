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
@Table(name = "tdisciplina")
public class Disciplina implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "coddcp")
	private Long codigo;
	@Column(name = "nomedcp")
	private String nome;
	@Column(name = "qtdfaltadcp")
	private Integer qtdFalta;
	@Column(name = "professordcp")
	private String professor;
	@Column(name = "totnotadcp")
	private float notaTotal;
	@ManyToOne
	@JoinColumn(name = "codavl", referencedColumnName = "codavl")
	private Avaliacao avaliacao;
	@ManyToOne
	@JoinColumn(name = "codtrb", referencedColumnName = "codtrb")
	private Trabalho trabalho;

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

	public Integer getQtdFalta() {
		return qtdFalta;
	}

	public void setQtdFalta(Integer qtdFalta) {
		this.qtdFalta = qtdFalta;
	}

	public String getProfessor() {
		return professor;
	}

	public void setProfessor(String professor) {
		this.professor = professor;
	}

	public float getNotaTotal() {
		return notaTotal;
	}

	public void setNotaTotal(float notaTotal) {
		this.notaTotal = notaTotal;
	}

	public Avaliacao getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(Avaliacao avaliacao) {
		this.avaliacao = avaliacao;
	}

	public Trabalho getTrabalho() {
		return trabalho;
	}

	public void setTrabalho(Trabalho trabalho) {
		this.trabalho = trabalho;
	}

}