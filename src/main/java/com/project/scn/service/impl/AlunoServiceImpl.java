package com.project.scn.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

import com.project.scn.DTO.AlunoStatusRequestDTO;
import com.project.scn.domain.Cra;
import com.project.scn.repository.CraRepository;
import com.project.scn.repository.SemestreRepository;
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
    SemestreRepository semestreRepository;

    @Autowired
    CraRepository craRepository;

    public List<Aluno> listarAlunos() throws NoSuchElementException {
        if (alunoRepository.findAll().isEmpty()) {
            throw new NoSuchElementException("Não existe nenhum aluno cadastrado.");
        } else return alunoRepository.findAll();

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
        }
        if (aluno.getCodigoSemestre() == null) {
            throw new Exception("Preencha o campo 'códigoSemestre' corretamente.");
        }
        if (aluno.getCodigoCurso() == null) {
            throw new Exception("Preencha o campo 'códigoCurso' corretamente.");
        } else {
            Aluno novoAluno = new Aluno();
            novoAluno.setNome(aluno.getNome());
            novoAluno.setUsuario(aluno.getUsuario());
            novoAluno.setSenha(criptografarSenha(aluno.getSenha()));
            novoAluno.setCodigoSemestre(semestreRepository.buscarUltimoSemestre().getCodigo());
            novoAluno.setCodigoCurso(aluno.getCodigoCurso());
            novoAluno.setCra(gerarCra());
            novoAluno.setDataCadastro(LocalDateTime.now());
            novoAluno.setIndicadorAtivo(true);
            alunoRepository.save(novoAluno);
            return ("Aluno cadastrado com sucesso!");
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