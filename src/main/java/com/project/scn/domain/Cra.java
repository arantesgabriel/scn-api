package com.project.scn.domain;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tcra")
public class Cra implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codcra")
    private Long codigo;
    @Column(name = "mediasm")
    private Double mediaSemestre;
    @Column(name = "mediacs")
    private Double mediaCurso;

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public Double getMediaSemestre() {
        return mediaSemestre;
    }

    public void setMediaSemestre(Double mediaSemestre) {
        this.mediaSemestre = mediaSemestre;
    }

    public Double getMediaCurso() {
        return mediaCurso;
    }

    public void setMediaCurso(Double mediaCurso) {
        this.mediaCurso = mediaCurso;
    }
}
