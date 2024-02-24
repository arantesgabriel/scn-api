package com.project.scn.DTO;

public class DisciplinaDTO {
    private Long codigo;
    private String nome;
    private Long codigoGrade;

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

    public Long getCodigoGrade() {
        return codigoGrade;
    }

    public void setCodigoGrade(Long codigoGrade) {
        this.codigoGrade = codigoGrade;
    }
}