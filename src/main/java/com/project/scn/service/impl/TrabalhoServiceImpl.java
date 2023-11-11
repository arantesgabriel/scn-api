package com.project.scn.service.impl;

import com.project.scn.DTO.AlunoDTO;
import com.project.scn.domain.Aluno;
import com.project.scn.domain.Trabalho;
import com.project.scn.repository.AlunoRepository;
import com.project.scn.repository.TrabalhoRepository;
import com.project.scn.service.AlunoService;
import com.project.scn.service.TrabalhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class TrabalhoServiceImpl implements TrabalhoService {

    @Autowired
    TrabalhoRepository trabalhoRepository;

    public String cadastrarTrabalho(Trabalho trabalho) throws Exception {

        if (trabalho.getNome().isEmpty()) {
            throw new Exception("Preencha corretamente o campo 'nome'");
        }
        if (trabalho.getNotaTotal() == null) {
            throw new Exception("Preencha corretamente o campo 'nota total'.");
        }
        if (trabalho.getNotaFinal() == null) {
            throw new Exception("Preencha corretamente o campo 'nota total'.");
        }
        if (trabalho.getDataEntrega() == null) {
            throw new Exception("Preencha corretamente o campo 'nota total'.");
        } else {
            trabalhoRepository.save(trabalho);
            return ("Trabalho cadastrado com sucesso!");
        }
    }

    public List<Trabalho> listarTrabalhos() {
        List<Trabalho> listaTrabalhos = trabalhoRepository.findAll();
        return listaTrabalhos;
    }

}
