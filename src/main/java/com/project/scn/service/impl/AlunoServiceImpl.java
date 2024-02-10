package com.project.scn.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import com.project.scn.DTO.AlunoStatusRequestDTO;
import com.project.scn.domain.Cra;
import com.project.scn.repository.CraRepository;
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

    @Autowired
    CraRepository craRepository;

    public List<Aluno> listarAlunos() {
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
            aluno.setSenha(criptografarSenha(senha));
            aluno.setCra(gerarCra());
            aluno.setDataCadastro(LocalDateTime.now());
            aluno.setIndicadorAtivo(true);
            alunoRepository.save(aluno);
            return ("Usuário cadastrado com sucesso!");
        }
    }

    public String criptografarSenha(String senha) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(senha);
    }

    public Cra gerarCra() {
        Cra cra = new Cra();
        cra.setMediaCurso(0.0);
        cra.setMediaSemestre(0.0);
        craRepository.save(cra);
        return cra;
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

    public String alterarStatusAluno(AlunoStatusRequestDTO aluno) {
        Aluno alunoAlterado = buscarAluno(aluno.getCodigo());
        alunoAlterado.setIndicadorAtivo(aluno.isNovoStatus());
        alunoRepository.save(alunoAlterado);
        return "Status alterado com sucesso!";
    }

}