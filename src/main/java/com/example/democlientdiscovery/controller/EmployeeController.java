package com.example.democlientdiscovery.controller;

import com.example.democlientdiscovery.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/info")
public class EmployeeController {
    private final RestTemplate restTemplate;

    @Autowired
    public EmployeeController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/getAllEmployees")
    public List<Employee> getAllEmployees() {
        List<Employee>  response = restTemplate
                .exchange("http://eurekaTest/employees",
                        HttpMethod.GET,null,
                        new ParameterizedTypeReference<List<Employee>>() {}).getBody();
        return response;
    }
    @GetMapping("/getEmployeeById/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        Employee response = restTemplate
                .exchange("http://eurekaTest/employees/{id}",
                        HttpMethod.GET,null,
                        new ParameterizedTypeReference<Employee>() {},id).getBody();
        return response;
    }
    @PutMapping("/updateEmployee/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        HttpEntity<Employee> entity = new HttpEntity<>(employee);

        Employee response = restTemplate
                .exchange("http://eurekaTest/employees/{id}",
                        HttpMethod.PUT,entity,
                        new ParameterizedTypeReference<Employee>() {},
                        id).getBody();
        return response;
    }
}
