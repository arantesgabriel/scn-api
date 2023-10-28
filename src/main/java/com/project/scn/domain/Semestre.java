package com.project.scn.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Semestre {

    @Id
    private Long codigo;
    private String nome;
    @ManyToOne
    private Disciplina disciplina;
    private Float mediaTotal;
    private Boolean statusAprovacao;

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

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
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
}
