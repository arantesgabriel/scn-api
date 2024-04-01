package com.project.scn.service.impl;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.scn.domain.Semestre;
import com.project.scn.repository.SemestreRepository;
import com.project.scn.service.SemestreService;

@Service
public class SemestreServiceImpl implements SemestreService {

    @Autowired
    SemestreRepository semestreRepository;

    public String salvarSemestre(Semestre semestre) throws Exception {
        if (semestre.getDataInicio() == null) {
            throw new Exception("Preencha corretamente o campo 'dataInicio'.");
        }
        if (semestre.getDataFim() == null) {
            throw new Exception("Preencha corretamente o campo 'dataFim'.");
        } else {
            semestre.setIdentificacao(formatarData(semestre.getDataInicio()));
            semestre.setIndicadorAtivo(true);
            semestreRepository.save(semestre);
            return ("Semestre salvo com sucesso!");
        }
    }

    public String formatarData(LocalDate dataInicio) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy");
        if (dataInicio.getMonthValue() >= 1 && dataInicio.getMonthValue() <= 6) {
            String dataInicioFormatada = dataInicio.format(formatter);
            String identificacaoSemestre = dataInicioFormatada.concat("/1");
            return identificacaoSemestre;
        } else {
            String dataInicioFormatada = dataInicio.format(formatter);
            String identificacaoSemestre = dataInicioFormatada.concat("/2");
            return identificacaoSemestre;
        }
    }

    public Semestre criarSemestre(Semestre novoSemestre) {
        LocalDate dataAtual = LocalDate.now();
        novoSemestre.setDataInicio(dataAtual);
        novoSemestre.setDataFim(dataAtual.plusMonths(6));
        novoSemestre.setIdentificacao(formatarData(novoSemestre.getDataInicio()));
        novoSemestre.setIndicadorAtivo(true);
        semestreRepository.save(novoSemestre);
        return novoSemestre;
    }

    public Semestre exibirUltimoSemestre() {
        return semestreRepository.buscarUltimoSemestre();
    }

    public void gerarNovoSemestreAutomatico() {
        Semestre ultimoSemestre = semestreRepository.buscarUltimoSemestre();
        if (ultimoSemestre == null) {
            Semestre novoSemestre = new Semestre();
            criarSemestre(novoSemestre);
            return;
        }

        Period periodo = Period.between(ultimoSemestre.getDataFim(), LocalDate.now());
        if (periodo.getMonths() == 7) {
            Semestre novoSemestre = new Semestre();
            criarSemestre(novoSemestre);
            ultimoSemestre.setIndicadorAtivo(false);
            semestreRepository.save(ultimoSemestre);
        }

    }

}