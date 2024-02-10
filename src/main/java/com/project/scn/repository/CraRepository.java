package com.project.scn.repository;

import com.project.scn.domain.Aluno;
import com.project.scn.domain.Cra;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CraRepository extends JpaRepository<Cra, Long> {
}
