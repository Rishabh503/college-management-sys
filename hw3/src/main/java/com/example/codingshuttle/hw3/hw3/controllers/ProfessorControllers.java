package com.example.codingshuttle.hw3.hw3.controllers;

import com.example.codingshuttle.hw3.hw3.entity.ProfessorEntity;
import com.example.codingshuttle.hw3.hw3.service.ProfessorService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/professors")
public class ProfessorControllers {
    private final ProfessorService professorService;

    public ProfessorControllers(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @GetMapping(path = "/{professorId}")
    public ProfessorEntity getProfessorById(@PathVariable Long professorId){
        return professorService.getProfessorById(professorId);
    }


    @PostMapping
    public ProfessorEntity createNewProfessor(@RequestBody ProfessorEntity professorEntity){
        return professorService.createNewProfessor(professorEntity);
    }
    @PutMapping(path="/{professorId}/proffesor/{subjectId}")
    public ProfessorEntity assingSubjectToProfesor(@PathVariable Long professorId,@PathVariable Long subjectId ){
        return professorService.assingSubjectToProfesor(professorId,subjectId);
    }



}
