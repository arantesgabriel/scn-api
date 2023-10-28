package com.project.scn.service;

import com.project.scn.DTO.AlunoDTO;
import com.project.scn.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlunoService {

    AlunoRepository alunoRepository;

    public String validarLogin(AlunoDTO alunoDTO) throws Exception {

        String usuario = alunoDTO.getUsuario();
        String senha = alunoDTO.getSenha();

        boolean credenciaisValidas = alunoRepository.existsByUsuarioAndSenha(usuario, senha);

        if (credenciaisValidas) {
            return "Login efetuado com sucesso!";
        } else {
            throw new Exception("Credenciais inválidas.");
        }
    }

}
