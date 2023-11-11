package com.project.scn.repository;

import com.project.scn.domain.Aluno;
import com.project.scn.domain.Trabalho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrabalhoRepository extends JpaRepository<Trabalho, Long> {


}