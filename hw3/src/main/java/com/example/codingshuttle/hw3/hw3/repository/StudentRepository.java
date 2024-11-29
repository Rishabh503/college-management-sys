package com.example.codingshuttle.hw3.hw3.repository;

import com.example.codingshuttle.hw3.hw3.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentEntity,Long> {
}
