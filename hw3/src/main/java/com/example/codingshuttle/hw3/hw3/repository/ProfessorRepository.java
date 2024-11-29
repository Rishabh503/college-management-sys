package com.example.codingshuttle.hw3.hw3.repository;

import com.example.codingshuttle.hw3.hw3.entity.ProfessorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<ProfessorEntity,Long> {
}
