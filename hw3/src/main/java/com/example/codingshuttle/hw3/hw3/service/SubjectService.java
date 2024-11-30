package com.example.codingshuttle.hw3.hw3.service;

import com.example.codingshuttle.hw3.hw3.entity.ProfessorEntity;
import com.example.codingshuttle.hw3.hw3.entity.StudentEntity;
import com.example.codingshuttle.hw3.hw3.entity.SubjectEntity;
import com.example.codingshuttle.hw3.hw3.repository.ProfessorRepository;
import com.example.codingshuttle.hw3.hw3.repository.SubjectRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SubjectService {

   private final SubjectRepository subjectRepository;
    private final ProfessorRepository professorRepository;

    public SubjectService(SubjectRepository subjectRepository, ProfessorRepository professorRepository) {
        this.subjectRepository = subjectRepository;
        this.professorRepository = professorRepository;
    }

    public SubjectEntity createNewSubject(SubjectEntity subjectEntity) {
        return subjectRepository.save(subjectEntity);
    }

    public SubjectEntity getSubjectById(Long subjectId) {
        return subjectRepository.findById(subjectId).orElse(null);
    }


}
