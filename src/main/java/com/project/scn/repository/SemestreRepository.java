package com.project.scn.repository;

import com.project.scn.domain.Semestre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SemestreRepository extends JpaRepository<Semestre, Long> {

    @Query("FROM Semestre ORDER BY codigo DESC LIMIT 1")
    Semestre buscarUltimoSemestre();
}
