package com.project.scn.DTO;

public class CursoDTO {

    private String nome;
    private Integer duracao;
    private Long codigoGrade;

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
}