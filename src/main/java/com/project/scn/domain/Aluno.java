package com.project.scn.domain;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

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
    @OneToOne
    @JoinColumn(name = "codcra", referencedColumnName = "codcra")
    private Cra cra;
    @Column(name = "datcad")
    private Date dataCadastro;

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

    public Cra getCra() {
        return cra;
    }

    public void setCra(Cra cra) {
        this.cra = cra;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}