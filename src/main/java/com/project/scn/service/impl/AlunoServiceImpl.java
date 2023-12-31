package com.project.scn.service.impl;

import com.project.scn.DTO.AlunoDTO;
import com.project.scn.domain.Aluno;
import com.project.scn.repository.AlunoRepository;
import com.project.scn.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoServiceImpl implements AlunoService {

    @Autowired
    AlunoRepository alunoRepository;

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

    public List<Aluno> listarAlunos() {
        List<Aluno> listaAlunos = alunoRepository.findAll();
        return listaAlunos;
    }

    public String deletarAluno(Long codigo) throws Exception {
        if (alunoRepository.findById(codigo).isEmpty() || alunoRepository.findById(codigo) == null) {
            throw new Exception("Não existe um aluno com o código informado.");
        } else {
            alunoRepository.deleteById(codigo);
            return "Aluno deletado.";
        }
    }

    public String cadastrarAluno(Aluno aluno) throws Exception {

        if (aluno.getNome().isEmpty() || aluno.getNome() == null) {
            throw new Exception("Preencha o campo 'nome' corretamente.");
        }
        if (aluno.getUsuario().isEmpty() || aluno.getUsuario() == null) {
            throw new Exception("Preencha o campo 'usuário' corretamente.");
        }
        if (aluno.getSenha().isEmpty() || aluno.getSenha() == null) {
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
}
