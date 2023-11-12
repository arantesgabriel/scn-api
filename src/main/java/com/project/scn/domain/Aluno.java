package com.project.scn.domain;

import java.io.Serializable;

import jakarta.persistence.*;

@Entity
@Table(name = "taluno")
public class Aluno implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codaln")
    private Long codigo;
    @Column(name = "nomealn")
    private String nome;
    @Column(name = "usraln")
    private String usuario;
    @Column(name = "senhaaln")
    private String senha;
    @ManyToOne
    @JoinColumn(name = "codsm", referencedColumnName = "codsm")
    private Semestre semestre;
    @ManyToOne
    @JoinColumn(name = "coddcp", referencedColumnName = "coddcp")
    private Disciplina disciplina;

    public Aluno(Aluno aluno) {
    }

    public Aluno() {

    }

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

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Semestre getSemestre() {
        return semestre;
    }

    public void setSemestre(Semestre semestre) {
        this.semestre = semestre;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }
}