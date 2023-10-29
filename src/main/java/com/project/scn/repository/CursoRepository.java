package com.project.scn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.scn.domain.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long>{
	
}
