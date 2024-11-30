package com.example.codingshuttle.hw3.hw3.controllers;

import com.example.codingshuttle.hw3.hw3.entity.ProfessorEntity;
import com.example.codingshuttle.hw3.hw3.entity.StudentEntity;
import com.example.codingshuttle.hw3.hw3.service.StudentService;
import jakarta.persistence.ManyToMany;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping(path = "/students")
public class StudentControllers {

    private final StudentService studentService;

    public StudentControllers(StudentService studentService) {
        this.studentService = studentService;
    }


    @PostMapping
    public StudentEntity createNewStudent(@RequestBody StudentEntity studentEntity){
        return studentService.createNewStudent(studentEntity);
    }

    @GetMapping(path="/{studentId}")
    public StudentEntity getStudentById(@PathVariable Long studentId){
        return studentService.getStudentById(studentId);
    }

   @PutMapping(path="/{studentId}/teachingproff/{professorId}")
   public StudentEntity connectStudentProfessor(@PathVariable Long studentId,@PathVariable Long professorId){
        return studentService.connectStudentProfessor(studentId,professorId);
   }


}
