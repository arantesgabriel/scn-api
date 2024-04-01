package com.project.scn.enums;

public enum Grupo {

	FUNCIONARIO("funcionario"), ALUNO("aluno"), ADMIN("admin");

	private String grupo;

	private Grupo(String grupo) {
		this.grupo = grupo;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

}