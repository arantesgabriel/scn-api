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
    @Column(name = "codgrd")
    private Long codigoGrade;
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

    public Long getCodigoGrade() {
        return codigoGrade;
    }

    public void setCodigoGrade(Long codigoGrade) {
        this.codigoGrade = codigoGrade;
    }

    public Boolean getIndicadorAtivo() {
        return indicadorAtivo;
    }

    public void setIndicadorAtivo(Boolean indicadorAtivo) {
        this.indicadorAtivo = indicadorAtivo;
    }
}
