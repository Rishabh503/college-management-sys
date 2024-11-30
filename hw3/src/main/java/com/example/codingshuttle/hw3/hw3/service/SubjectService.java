package com.example.codingshuttle.hw3.hw3.service;

import com.example.codingshuttle.hw3.hw3.entity.ProfessorEntity;
import com.example.codingshuttle.hw3.hw3.entity.StudentEntity;
import com.example.codingshuttle.hw3.hw3.entity.SubjectEntity;
import com.example.codingshuttle.hw3.hw3.repository.ProfessorRepository;
import com.example.codingshuttle.hw3.hw3.repository.StudentRepository;
import com.example.codingshuttle.hw3.hw3.repository.SubjectRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SubjectService {

   private final SubjectRepository subjectRepository;
    private final StudentRepository studentRepository;


    public SubjectService(SubjectRepository subjectRepository, StudentRepository studentRepository) {
        this.subjectRepository = subjectRepository;
        this.studentRepository = studentRepository;
    }

    public SubjectEntity createNewSubject(SubjectEntity subjectEntity) {
        return subjectRepository.save(subjectEntity);
    }

    public SubjectEntity getSubjectById(Long subjectId) {
        return subjectRepository.findById(subjectId).orElse(null);
    }


    public SubjectEntity connectStudentSubject(Long subjectId, Long studentId) {
        SubjectEntity subject=subjectRepository.findById(subjectId).orElse(null);
        StudentEntity student=studentRepository.findById(studentId).orElse(null);

        if(student!=null && subject!=null){
            subject.getStudents().add(student);
            student.getSubjects().add(subject);
            studentRepository.save(student);
            return subjectRepository.save(subject);
        }
        return null;
    }
}
