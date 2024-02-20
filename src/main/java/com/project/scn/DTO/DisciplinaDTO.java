package com.project.scn.DTO;

public class DisciplinaDTO {
    private Long codigo;
    private Long codigoAluno;
    private String nome;

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public Long getCodigoAluno() {
        return codigoAluno;
    }

    public void setCodigoAluno(Long codigoAluno) {
        this.codigoAluno = codigoAluno;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}