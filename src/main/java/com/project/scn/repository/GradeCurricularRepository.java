package com.project.scn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.scn.domain.GradeCurricular;

@Repository
public interface GradeCurricularRepository extends JpaRepository<GradeCurricular, Long> {
}
