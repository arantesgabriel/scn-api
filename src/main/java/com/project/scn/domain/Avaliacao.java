package com.project.scn.domain;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tavaliacao")
public class Avaliacao implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codavl")
    private Long codigo;
    @Column(name = "nomeavl")
    private String nome;
    @Column(name = "notatotavl")
    private Float notaTotal;
    @Column(name = "notafinavl")
    private Float notaFinal;
    @Column(name = "datavl")
    @JsonFormat(pattern = "dd/MM/yyyy", timezone = "GMT")
    private Date data;

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

    public Float getNotaTotal() {
        return notaTotal;
    }

    public void setNotaTotal(Float notaTotal) {
        this.notaTotal = notaTotal;
    }

    public Float getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(Float notaFinal) {
        this.notaFinal = notaFinal;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }


}
