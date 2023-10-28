package com.project.scn.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Avaliacao {

    @Id
    private Long codigo;
    private String nome;
    private Float nota;

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

    public Float getNota() {
        return nota;
    }

    public void setNota(Float nota) {
        this.nota = nota;
    }
}
