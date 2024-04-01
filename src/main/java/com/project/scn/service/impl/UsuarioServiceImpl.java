package com.project.scn.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.scn.DTO.AlunoStatusRequestDTO;
import com.project.scn.domain.Cra;
import com.project.scn.domain.Usuario;
import com.project.scn.enums.Grupo;
import com.project.scn.repository.SemestreRepository;
import com.project.scn.repository.UsuarioRepository;
import com.project.scn.service.CraService;
import com.project.scn.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;

	@Autowired
	SemestreRepository semestreRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	CraService craService;

	public String cadastrarUsuario(Usuario usuario) throws Exception {
		validarCamposUsuario(usuario);
		String senhaCriptografada = criptografarSenha(usuario.getSenha());

		if (usuario.getGrupo() == Grupo.ALUNO) {
			Long semestre = semestreRepository.buscarUltimoSemestre().getCodigo();
			Cra cra = craService.gerarCra();
			Usuario novoUsuario = new Usuario(usuario.getNome(), usuario.getLogin(), senhaCriptografada, semestre, usuario.getCodigoCurso(), cra, LocalDateTime.now(), true, usuario.getGrupo());
			usuarioRepository.save(novoUsuario);

		} else {
			Usuario novoUsuario = new Usuario(usuario.getNome(), usuario.getLogin(), senhaCriptografada, null, null, null, LocalDateTime.now(), true, usuario.getGrupo());
			usuarioRepository.save(novoUsuario);

		}
		return ("Usuario cadastrado com sucesso!");
	}

	public List<Usuario> listarUsuarios() {
		return usuarioRepository.findAll();
	}

	public Usuario buscarUsuarioCodigo(Long codigoUsuario) {
		return usuarioRepository.findById(codigoUsuario).orElseThrow(null);
	}
	
	public Usuario buscarUsuarioLogin(String login) {
		return usuarioRepository.findUsuarioByLogin(login);
	} 

	public String alterarStatusUsuario(AlunoStatusRequestDTO usuario) {
		Usuario usuarioAlterado = buscarUsuarioCodigo(usuario.getCodigo());
		usuarioAlterado.setIndicadorAtivo(usuario.isNovoStatus());
		usuarioRepository.save(usuarioAlterado);
		return "Status alterado com sucesso!";
	}
	
	public String criptografarSenha(String senha) {
		return passwordEncoder.encode(senha);
	}
	
	public void validarCamposUsuario(Usuario usuario) throws IllegalArgumentException {
		if (usuario.getNome() == null || usuario.getNome().isEmpty()) {
			throw new IllegalArgumentException("Preencha o campo 'nome' corretamente.");
		}
		if (usuario.getLogin() == null || usuario.getLogin().isEmpty()) {
			throw new IllegalArgumentException("Preencha o campo 'login' corretamente.");
		}
		if (usuario.getSenha() == null || usuario.getSenha().isEmpty()) {
			throw new IllegalArgumentException("Preencha o campo 'senha' corretamente.");
		}
		if (usuario.getCodigoCurso() == null && usuario.getGrupo() == Grupo.ALUNO) {
			throw new IllegalArgumentException("Preencha o campo 'curso' corretamente.");
		}
	}
	
}