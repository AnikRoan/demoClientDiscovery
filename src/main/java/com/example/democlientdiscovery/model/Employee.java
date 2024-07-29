package com.example.democlientdiscovery.model;

public class Employee {
    private Long id;
    private String name;
    private String company;
    // Публичный конструктор без параметров
    public Employee() {}

    // Публичные геттеры и сеттеры
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
