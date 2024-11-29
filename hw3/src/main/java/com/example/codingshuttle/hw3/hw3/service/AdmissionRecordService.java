package com.example.codingshuttle.hw3.hw3.service;

import com.example.codingshuttle.hw3.hw3.entity.AdmissionRecordEntity;
import com.example.codingshuttle.hw3.hw3.repository.AdmissionRecordRepository;
import org.springframework.stereotype.Service;

@Service
public class AdmissionRecordService {

    private final AdmissionRecordRepository admissionRecordRepository;


    public AdmissionRecordService(AdmissionRecordRepository admissionRecordRepository) {
        this.admissionRecordRepository = admissionRecordRepository;
    }

    public AdmissionRecordEntity addfees(AdmissionRecordEntity admissionRecordEntity) {
        return admissionRecordRepository.save(admissionRecordEntity);
    }

    public AdmissionRecordEntity getstudentfees(Long feesId) {
        return admissionRecordRepository.findById(feesId).orElse(null);
    }
}

