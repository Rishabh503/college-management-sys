package com.example.codingshuttle.hw3.hw3.controllers;

import com.example.codingshuttle.hw3.hw3.entity.ProfessorEntity;
import com.example.codingshuttle.hw3.hw3.entity.SubjectEntity;
import com.example.codingshuttle.hw3.hw3.service.SubjectService;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/subjects")
public class SubjectController {

    private  final SubjectService subjectService;
    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @PostMapping
    public SubjectEntity createNewSubject(@RequestBody SubjectEntity subjectEntity){
        return subjectService.createNewSubject(subjectEntity);
    }

    @GetMapping(path="/{subjectId}")
    public SubjectEntity getSubjectById(@PathVariable Long subjectId){
        return subjectService.getSubjectById(subjectId);
    }
    @PutMapping(path = "{subjectId}/subjectToStudent/{studentId}")
    public SubjectEntity connectStudentSubject(@PathVariable Long subjectId,@PathVariable Long studentId){
        return subjectService.connectStudentSubject(subjectId,studentId);
    }
}
