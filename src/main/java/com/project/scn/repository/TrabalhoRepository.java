package com.project.scn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.scn.domain.Trabalho;

@Repository
public interface TrabalhoRepository extends JpaRepository<Trabalho, Long> {


}