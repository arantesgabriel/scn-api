package com.project.scn.repository;

import com.project.scn.domain.GradeCurricular;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GradeCurricularRepository extends JpaRepository<GradeCurricular, Long> {
}
