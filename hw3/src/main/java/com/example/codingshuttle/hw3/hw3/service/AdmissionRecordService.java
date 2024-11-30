package com.example.codingshuttle.hw3.hw3.service;

import com.example.codingshuttle.hw3.hw3.entity.AdmissionRecordEntity;
import com.example.codingshuttle.hw3.hw3.entity.StudentEntity;
import com.example.codingshuttle.hw3.hw3.repository.AdmissionRecordRepository;
import com.example.codingshuttle.hw3.hw3.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class AdmissionRecordService {

    private final AdmissionRecordRepository admissionRecordRepository;
    private final StudentRepository studentRepository;


    public AdmissionRecordService(AdmissionRecordRepository admissionRecordRepository, StudentRepository studentRepository) {
        this.admissionRecordRepository = admissionRecordRepository;
        this.studentRepository = studentRepository;
    }



    public AdmissionRecordEntity addfees(AdmissionRecordEntity admissionRecordEntity) {
        return admissionRecordRepository.save(admissionRecordEntity);
    }

    public AdmissionRecordEntity getstudentfees(Long feesId) {
        return admissionRecordRepository.findById(feesId).orElse(null);
    }

    public AdmissionRecordEntity alotfees(Long studentId, Long feesId) {
        StudentEntity student=studentRepository.findById(studentId).orElse(null);
        AdmissionRecordEntity fees=admissionRecordRepository.findById(feesId).orElse(null);

        if(student!=null && fees!=null){
            student.setFeesSlip(fees);
            studentRepository.save(student);
            return admissionRecordRepository.save(fees);
        }
        return null;
    }
}

