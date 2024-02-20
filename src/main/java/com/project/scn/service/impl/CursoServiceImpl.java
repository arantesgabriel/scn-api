package com.project.scn.service.impl;

import java.util.List;
import java.util.Optional;

import com.project.scn.DTO.GradeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.scn.DTO.CursoDTO;
import com.project.scn.domain.Curso;
import com.project.scn.mapper.CursoMapper;
import com.project.scn.repository.CursoRepository;
import com.project.scn.service.CursoService;

@Service
public class CursoServiceImpl implements CursoService {

    @Autowired
    CursoMapper cursoMapper;
    @Autowired
    CursoRepository cursoRepository;

    public List<Curso> listarCursos() {
        return cursoRepository.findAll();
    }

    @Override
    public String cadastrarCurso(CursoDTO cursoDTO) {
        Curso curso = new Curso();
        curso.setIndicadorAtivo(true);
        cursoDTO.setNome(cursoDTO.getNome().toUpperCase());
        cursoMapper.DTOParaCurso(cursoDTO, curso);
        cursoRepository.save(curso);
        return "Curso cadastrado com sucesso!";
    }

    public String associarGradeCurricular(Long codigoCurso, Long codigoGrade) throws Exception {
        if (buscarCursoPorCodigo(codigoCurso) != null) {
        Curso cursoAtualizado = new Curso();
        }
        return;
    }

    @Override
    public Optional<Curso> buscarCursoPorCodigo(Long codigo) {
        return cursoRepository.buscarCursoPorCodigo(codigo);
    }
}