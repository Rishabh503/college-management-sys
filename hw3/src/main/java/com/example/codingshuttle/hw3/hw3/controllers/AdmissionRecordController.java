package com.example.codingshuttle.hw3.hw3.controllers;

import com.example.codingshuttle.hw3.hw3.entity.AdmissionRecordEntity;
import com.example.codingshuttle.hw3.hw3.entity.StudentEntity;
import com.example.codingshuttle.hw3.hw3.service.AdmissionRecordService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/admissionrecords")
public class AdmissionRecordController {

    private final AdmissionRecordService admissionRecordService;
    public AdmissionRecordController(AdmissionRecordService admissionRecordService) {
        this.admissionRecordService = admissionRecordService;
    }

    @PostMapping
    public AdmissionRecordEntity addfees(@RequestBody AdmissionRecordEntity admissionRecordEntity){
        return admissionRecordService.addfees(admissionRecordEntity);
    }

    @GetMapping(path="/{feesId}")
    public AdmissionRecordEntity getstudentfees(@PathVariable Long feesId){
        return admissionRecordService.getstudentfees(feesId);
    }
    @PutMapping(path="/{studentId}/fees/{feesId}")
    public AdmissionRecordEntity alotfees(@PathVariable Long studentId,@PathVariable Long feesId){
        return admissionRecordService.alotfees(studentId,feesId);
    }

}
