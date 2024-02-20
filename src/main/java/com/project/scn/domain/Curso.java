package com.project.scn.domain;

import java.io.Serializable;

import com.project.scn.DTO.GradeDTO;
import jakarta.persistence.*;

@Entity
@Table(name = "tcurso")
public class Curso implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codcs")
    private Long codigo;
    @Column(name = "nomecs")
    private String nome;
    @Column(name = "drccs")
    private Integer duracao;
    @ManyToOne
    @JoinColumn(name = "codaln", referencedColumnName = "codaln")
    private Aluno aluno;
    @OneToOne
    @JoinColumn(name = "codgrd", referencedColumnName = "codgrd")
    private GradeCurricular gradeCurricular;
    @Column(name = "indatv")
    private Boolean indicadorAtivo;

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

    public Integer getDuracao() {
        return duracao;
    }

    public void setDuracao(Integer duracao) {
        this.duracao = duracao;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }


    public Boolean getIndicadorAtivo() {
        return indicadorAtivo;
    }

    public void setIndicadorAtivo(Boolean indicadorAtivo) {
        this.indicadorAtivo = indicadorAtivo;
    }
}
