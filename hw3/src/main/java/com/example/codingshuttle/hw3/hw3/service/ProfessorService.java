package com.example.codingshuttle.hw3.hw3.service;

import com.example.codingshuttle.hw3.hw3.entity.ProfessorEntity;
import com.example.codingshuttle.hw3.hw3.entity.SubjectEntity;
import com.example.codingshuttle.hw3.hw3.repository.ProfessorRepository;
import com.example.codingshuttle.hw3.hw3.repository.SubjectRepository;
import org.springframework.stereotype.Service;

@Service
public class ProfessorService {

    private final ProfessorRepository professorRepository;
    private final SubjectRepository subjectRepository;

    public ProfessorService(ProfessorRepository professorRepository, SubjectRepository subjectRepository) {
        this.professorRepository = professorRepository;
        this.subjectRepository = subjectRepository;
    }

    public ProfessorEntity getProfessorById(Long professorId) {
        return professorRepository.findById(professorId).orElse(null);
    }

    public ProfessorEntity createNewProfessor(ProfessorEntity professorEntity) {
        return professorRepository.save(professorEntity);
    }

    public ProfessorEntity assingSubjectToProfesor(Long professorId, Long subjectId) {
        ProfessorEntity professor=professorRepository.findById(professorId).orElse(null);
        SubjectEntity subject=subjectRepository.findById(subjectId).orElse(null);

        if(subject!=null && professor!=null){
            subject.setProfessor_of_this_subject(professor);
            professor.getSubjectsbyproffesor().add(subject);

            subjectRepository.save(subject);
            return professor;
        }
        return null;
    }
}
