package com.project.scn.service.impl;

import java.nio.file.AccessDeniedException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.scn.DTO.AlunoDTO;
import com.project.scn.domain.Aluno;
import com.project.scn.repository.AlunoRepository;
import com.project.scn.service.AlunoService;
import com.project.scn.service.CursoService;

@Service
public class AlunoServiceImpl implements AlunoService {

	@Autowired
	AlunoRepository alunoRepository;
	@Autowired
	CursoService cursoService;

	@Override
	public List<Aluno> listarAlunos() {
		return alunoRepository.findAll();
	}

	@Override
	public String cadastrarAluno(Aluno aluno) throws NoSuchFieldException {
		validarCamposAluno(aluno);
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String senhaCriptografada = passwordEncoder.encode(aluno.getSenha());
		aluno.setSenha(senhaCriptografada);
		aluno.setNome(aluno.getNome().toUpperCase());
		alunoRepository.save(aluno);
		return ("Usuário cadastrado com sucesso!");
	}

	@Override
	public String efetuarLogin(AlunoDTO alunoDTO) throws AccessDeniedException, NoSuchFieldException {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

		if (alunoRepository.existsByUsuario(alunoDTO.getUsuario())) {
			Aluno aluno = alunoRepository.findAlunoByUsuario(alunoDTO.getUsuario());
			if (passwordEncoder.matches(alunoDTO.getSenha(), aluno.getSenha())) {
				return "Login efetuado com sucesso!";
			} else {
				throw new AccessDeniedException("Credenciais inválidas.");
			}
		} else {
			throw new NoSuchElementException("Usuário não existe");
		}
	}

	public String deletarAluno(Long codigo) throws NoSuchFieldException {
		if (alunoRepository.findById(codigo).isEmpty()) {
			throw new NoSuchFieldException("Não existe um aluno com o código informado.");
		} else {
			alunoRepository.deleteById(codigo);
			return "Aluno deletado.";
		}
	}

	@Override
	public void validarCamposAluno(Aluno aluno) throws NoSuchFieldException {
		if (aluno.getNome() == null || aluno.getNome().trim().isEmpty()) {
			throw new NoSuchFieldException("Preencha o campo 'nome' corretamente.");
		}
		if (aluno.getUsuario() == null || aluno.getUsuario().trim().isEmpty()) {
			throw new NoSuchFieldException("Preencha o campo 'usuário' corretamente.");
		}
		if (aluno.getSenha() == null || aluno.getSenha().trim().isEmpty()) {
			throw new NoSuchFieldException("Preencha o campo 'senha' corretamente.");
		}
	}

	@Override
	public Optional<Aluno> buscarAlunoCodigo(Long codigo) {
		return alunoRepository.findById(codigo);
	}

}