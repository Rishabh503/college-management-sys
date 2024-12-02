package com.example.codingshuttle.hw3.hw3.clients.impl;

import com.example.codingshuttle.hw3.hw3.clients.EmployeeClient;
import com.example.codingshuttle.hw3.hw3.entity.EmployeeEntity;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;
@Service
@RequiredArgsConstructor
public class EmployeeClientImpl implements EmployeeClient {


    private final RestClient restClient;

    @Override
    public List<EmployeeEntity> getAllEmployees() {
        try{
        List<EmployeeEntity> employeeEntityList=restClient.get()
                .uri("employees")
                .retrieve()
                .body(new ParameterizedTypeReference<List<EmployeeEntity>>() {
                });
        return employeeEntityList.stream().toList();
        }
        catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public EmployeeEntity getEmployeeById(Long employeeId) {
        try{
            EmployeeEntity employee=restClient.get()
                    .uri("employees/{employeeId}",employeeId)
                    .retrieve()
                    .body(new ParameterizedTypeReference<EmployeeEntity>(){});

            return employee;

        }
        catch(Exception e){
            throw  new RuntimeException(e);
        }
    }
}
