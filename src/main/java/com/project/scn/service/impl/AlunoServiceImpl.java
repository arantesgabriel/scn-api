package com.project.scn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.scn.DTO.AlunoDTO;
import com.project.scn.domain.Aluno;
import com.project.scn.repository.AlunoRepository;
import com.project.scn.service.AlunoService;

@Service
public class AlunoServiceImpl implements AlunoService {

	@Autowired
	AlunoRepository alunoRepository;

	public List<Aluno> buscarAlunos() {
		return alunoRepository.findAll();
	}

	public Aluno buscarAluno(Long codigoAluno) {
		return alunoRepository.findById(codigoAluno).orElseThrow(null);
	}

	public String cadastrarAluno(Aluno aluno) throws Exception {
		if (aluno.getNome() == null || aluno.getNome().isEmpty()) {
			throw new Exception("Preencha o campo 'nome' corretamente.");
		}
		if (aluno.getUsuario() == null || aluno.getUsuario().isEmpty()) {
			throw new Exception("Preencha o campo 'usuário' corretamente.");
		}
		if (aluno.getSenha() == null || aluno.getSenha().isEmpty()) {
			throw new Exception("Preencha o campo 'senha' corretamente.");
		} else {
			String senha = aluno.getSenha();
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			String senhaCriptografada = passwordEncoder.encode(senha);
			aluno.setSenha(senhaCriptografada);
			alunoRepository.save(aluno);
			return ("Usuário cadastrado com sucesso!");
		}
	}

	@Override
	public String efetuarLogin(AlunoDTO alunoDTO) throws Exception {
		String usuario = alunoDTO.getUsuario();
		String senha = alunoDTO.getSenha();

		Aluno aluno = alunoRepository.findAlunoByUsuario(usuario);

		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

		boolean usuarioValido = alunoRepository.existsByUsuario(usuario);

		if (usuarioValido && passwordEncoder.matches(senha, aluno.getSenha())) {
			return "Login efetuado com sucesso!";
		} else {
			throw new Exception("Credenciais inválidas.");
		}
	}

}