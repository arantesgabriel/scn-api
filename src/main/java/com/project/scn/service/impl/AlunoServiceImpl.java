package com.project.scn.service.impl;

import com.project.scn.DTO.AlunoDTO;
import com.project.scn.domain.Aluno;
import com.project.scn.repository.AlunoRepository;
import com.project.scn.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoServiceImpl implements AlunoService {

    @Autowired
    AlunoRepository alunoRepository;

    @Override
    public String efetuarLogin(AlunoDTO alunoDTO) throws Exception {
        String usuario = alunoDTO.getUsuario();
        String senha = alunoDTO.getSenha();

        boolean credenciaisValidas = alunoRepository.existsByUsuarioAndSenha(usuario, senha);

        if (credenciaisValidas) {
            return "Login efetuado com sucesso!";
        } else {
            throw new Exception("Credenciais inválidas.");
        }
    }

    public List<Aluno> listarAlunos() {
        List<Aluno> listaAlunos = alunoRepository.findAll();
        return listaAlunos;
    }

    public void cadastrarAluno(Aluno aluno) {
        alunoRepository.save(aluno);
    }
}
