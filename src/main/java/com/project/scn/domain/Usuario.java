package com.project.scn.domain;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.project.scn.enums.Grupo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tusuario")
public class Usuario implements UserDetails {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codusr")
	private Long codigo;
	@Column(name = "nomeusr")
	private String nome;
	@Column(name = "loginusr")
	private String login;
	@Column(name = "senhausr")
	private String senha;
	@Column(name = "codsm")
	private Long codigoSemestre;
	@Column(name = "codcs")
	private Long codigoCurso;
	@OneToOne
	@JoinColumn(name = "codcra", referencedColumnName = "codcra")
	private Cra cra;
	@Column(name = "datcad")
	private LocalDateTime dataCadastro;
	@Column(name = "indatv")
	private Boolean indicadorAtivo;
	@Column(name = "grpusr")
	@Enumerated(EnumType.STRING)
	private Grupo grupo;

	public Usuario() {
		super();
	}

	public Usuario(String nome, String login, String senha, Long codigoSemestre, Long codigoCurso, Cra cra, LocalDateTime dataCadastro, Boolean indicadorAtivo, Grupo grupo) {
		super();
		this.nome = nome;
		this.login = login;
		this.senha = senha;
		this.codigoSemestre = codigoSemestre;
		this.codigoCurso = codigoCurso;
		this.cra = cra;
		this.dataCadastro = dataCadastro;
		this.indicadorAtivo = indicadorAtivo;
		this.grupo = grupo;
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

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Long getCodigoSemestre() {
		return codigoSemestre;
	}

	public void setCodigoSemestre(Long codigoSemestre) {
		this.codigoSemestre = codigoSemestre;
	}

	public Long getCodigoCurso() {
		return codigoCurso;
	}

	public void setCodigoCurso(Long codigoCurso) {
		this.codigoCurso = codigoCurso;
	}

	public Cra getCra() {
		return cra;
	}

	public void setCra(Cra cra) {
		this.cra = cra;
	}

	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDateTime dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Boolean getIndicadorAtivo() {
		return indicadorAtivo;
	}

	public void setIndicadorAtivo(Boolean indicadorAtivo) {
		this.indicadorAtivo = indicadorAtivo;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		if (grupo == Grupo.ADMIN) {
			return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), 
					new SimpleGrantedAuthority("ROLE_FUNCIONARIO"),
					new SimpleGrantedAuthority("ROLE_ALUNO"));
		} else if (grupo == Grupo.FUNCIONARIO) {
			return List.of(new SimpleGrantedAuthority("ROLE_FUNCIONARIO"));
		} else {
			return List.of(new SimpleGrantedAuthority("ROLE_ALUNO"));
		}
	}

	@Override
	public String getPassword() {
		return this.senha;
	}

	@Override
	public String getUsername() {
		return this.login;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return indicadorAtivo;
	}

}