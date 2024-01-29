package com.project.scn.domain;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "tcra")
public class Cra implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codcra")
    private Long codigo;
    @Column(name = "medsm")
    private Double mediaSemestre;
    @Column(name = "medcs")
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
