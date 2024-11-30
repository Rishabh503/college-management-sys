package com.example.codingshuttle.hw3.hw3.service;

import com.example.codingshuttle.hw3.hw3.entity.ProfessorEntity;
import com.example.codingshuttle.hw3.hw3.entity.StudentEntity;
import com.example.codingshuttle.hw3.hw3.entity.SubjectEntity;
import com.example.codingshuttle.hw3.hw3.repository.ProfessorRepository;
import com.example.codingshuttle.hw3.hw3.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final ProfessorRepository professorRepository;


    public StudentService(StudentRepository studentRepository, ProfessorRepository professorRepository) {
        this.studentRepository = studentRepository;
        this.professorRepository = professorRepository;
    }

    public StudentEntity createNewStudent(StudentEntity studentEntity) {
        return studentRepository.save(studentEntity);
    }

    public StudentEntity getStudentById(Long studentId) {
        return studentRepository.findById(studentId).orElse(null);
    }

    public StudentEntity connectStudentProfessor(Long studentId, Long professorId) {
        StudentEntity student=studentRepository.findById(studentId).orElse(null);
        ProfessorEntity professor=professorRepository.findById(professorId).orElse(null);

        if(student!=null && professor!=null){
            student.getProfessorTeachingStudent().add(professor);
            professor.getStudentsTaughtByProffesor().add(student);
            professorRepository.save(professor);
            return studentRepository.save(student);
        }
        return null;
    }
//    public ProfessorEntity assingSubjectToProfesor(Long professorId, Long subjectId) {
//        ProfessorEntity professor=professorRepository.findById(professorId).orElse(null);
//        SubjectEntity subject=subjectRepository.findById(subjectId).orElse(null);
//
//        if(subject!=null && professor!=null){
//            subject.setProfessor_of_this_subject(professor);
//            professor.getSubjectsbyproffesor().add(subject);
//
//            subjectRepository.save(subject);
//            return professor;
//        }
//        return null;
//    }
}
