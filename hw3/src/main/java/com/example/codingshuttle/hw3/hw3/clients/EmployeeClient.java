package com.example.codingshuttle.hw3.hw3.clients;

import com.example.codingshuttle.hw3.hw3.entity.EmployeeEntity;

import java.util.List;

public interface EmployeeClient {


//    pehle method yaha bnana hai /
    List<EmployeeEntity> getAllEmployees();

    EmployeeEntity getEmployeeById(Long id);

}
