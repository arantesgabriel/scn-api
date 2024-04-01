package com.project.scn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.scn.domain.Semestre;

public interface SemestreRepository extends JpaRepository<Semestre, Long> {

    @Query("FROM Semestre ORDER BY codigo DESC LIMIT 1")
    Semestre buscarUltimoSemestre();
}
