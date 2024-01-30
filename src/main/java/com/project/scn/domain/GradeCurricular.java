package com.project.scn.domain;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tgrade")
public class GradeCurricular implements Serializable {
	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codgrd")
    private Long codigo;
    @Column(name = "numpr")
    private Integer numeroPeriodo;
    @ManyToOne
    @JoinColumn(name = "coddcp", referencedColumnName = "coddcp")
    private Disciplina disciplina;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Integer getNumeroPeriodo() {
		return numeroPeriodo;
	}

	public void setNumeroPeriodo(Integer numeroPeriodo) {
		this.numeroPeriodo = numeroPeriodo;
	}

    public Disciplina getDisciplina() {
        return disciplina;
    }

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
}