package com.project.scn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.scn.domain.RelacaoAlunoDisciplina;
import com.project.scn.domain.RelacaoAlunoDisciplinaPK;

public interface RelacaoAlunoDisciplinaRepository
		extends JpaRepository<RelacaoAlunoDisciplina, RelacaoAlunoDisciplinaPK> {

	// List<RelacaoAlunoDisciplina> findRelacaoByAluno(Aluno aluno) throws
	// Exception;

}
