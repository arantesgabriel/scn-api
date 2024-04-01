package com.project.scn.service;

import java.util.List;

import com.project.scn.DTO.AlunoStatusRequestDTO;
import com.project.scn.domain.Usuario;

public interface UsuarioService {

	String cadastrarUsuario(Usuario usuario) throws Exception;

	List<Usuario> listarUsuarios();

	Usuario buscarUsuarioCodigo(Long codigoUsuario);
	
	public Usuario buscarUsuarioLogin(String login);

	String alterarStatusUsuario(AlunoStatusRequestDTO aluno) throws Exception;

}