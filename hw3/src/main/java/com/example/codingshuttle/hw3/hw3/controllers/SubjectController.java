package com.example.codingshuttle.hw3.hw3.controllers;

import com.example.codingshuttle.hw3.hw3.entity.SubjectEntity;
import com.example.codingshuttle.hw3.hw3.service.SubjectService;
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
}
