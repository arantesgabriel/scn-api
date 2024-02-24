package com.project.scn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.scn.DTO.DisciplinaDTO;
import com.project.scn.domain.Disciplina;
import com.project.scn.repository.DisciplinaRepository;
import com.project.scn.service.AlunoService;
import com.project.scn.service.DisciplinaService;

@Service
public class DisciplinaServiceImpl implements DisciplinaService {

    @Autowired
    DisciplinaRepository disciplinaRepository;

    @Autowired
    AlunoService alunoService;

    @Autowired

    @Override
    public List<Disciplina> listarDisciplinas() {
        return disciplinaRepository.findAll();
    }

    public Disciplina buscarDisciplinaPorCodigo(Long codigoDisciplina) {
        return disciplinaRepository.findById(codigoDisciplina).orElseThrow(null);
    }

    public Disciplina buscarDisciplinaPorNome(String nomeDisciplina) {
        List<Disciplina> listaDisciplinas = listarDisciplinas();
        for (Disciplina disciplina : listaDisciplinas) {
            if (disciplina.getNome().equals(nomeDisciplina)) {
                return disciplina;
            }
        }
        return null;

    }

    public String cadastrarDisciplina(DisciplinaDTO disciplinaDTO) throws Exception {
        if (disciplinaDTO.getNome() == null || disciplinaDTO.getNome().isEmpty()) {
            throw new Exception("Preencha corretamente o campo 'nome'.");
        }
        if (buscarDisciplinaPorNome(disciplinaDTO.getNome().toUpperCase()) != null) {
            return ("A disciplina já existe.");
        } else {
            Disciplina novaDisciplina = new Disciplina();
            novaDisciplina.setNome(disciplinaDTO.getNome().toUpperCase());
            novaDisciplina.setCodigoGrade(disciplinaDTO.getCodigoGrade());
            novaDisciplina.setIndicadorAtivo(true);
            disciplinaRepository.save(novaDisciplina);
            return ("Disciplina cadastrada com sucesso!");
        }

    }

}