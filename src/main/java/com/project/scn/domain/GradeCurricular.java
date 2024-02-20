package com.project.scn.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

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
    @OneToMany(mappedBy = "gradeCurricular", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Disciplina> disciplinas = new ArrayList<>();
    @Column(name = "indatv")
    private Integer indicadorAtivo;

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

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public Integer getIndicadorAtivo() {
        return indicadorAtivo;
    }

    public void setIndicadorAtivo(Integer indicadorAtivo) {
        this.indicadorAtivo = indicadorAtivo;
    }
}