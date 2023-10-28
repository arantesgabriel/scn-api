package com.project.scn.domain;

import com.project.scn.DTO.AlunoDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Aluno {

    @Id
    private Long codigo;
    private String nome;
    private String usuario;
    private String senha;
    @OneToOne
    private Curso curso;
    @OneToOne
    private Semestre semestre;

    public Aluno(AlunoDTO alunoDTO) {
        this.codigo = alunoDTO.getCodigo();
        this.usuario = alunoDTO.getUsuario();
        this.senha = alunoDTO.getSenha();
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

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Semestre getSemestre() {
        return semestre;
    }

    public void setSemestre(Semestre semestre) {
        this.semestre = semestre;
    }
}
