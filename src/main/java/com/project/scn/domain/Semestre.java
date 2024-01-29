package com.project.scn.domain;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tsemestre")
public class Semestre implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codsm")
	private Long codigo;
	@Column(name = "numpr")
	private Integer numeroPeriodo;
	@Column(name = "mediasm")
	private Float mediaFinal;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Integer setNumeroPeriodo() {
		return numeroPeriodo;
	}

	public void setNumeroPeriodo(Integer numeroPeriodo) {
		this.numeroPeriodo = numeroPeriodo;
	}

	public Float getMediaTotal() {
		return mediaFinal;
	}

	public void setMediaTotal(Float mediaFinal) {
		this.mediaFinal = mediaFinal;
	}

}