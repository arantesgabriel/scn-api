package com.project.scn.service;

import java.util.List;

import com.project.scn.domain.Trabalho;

public interface TrabalhoService {

	String cadastrarTrabalho(Trabalho trabalho) throws Exception;

	List<Trabalho> listarTrabalhos();

}
