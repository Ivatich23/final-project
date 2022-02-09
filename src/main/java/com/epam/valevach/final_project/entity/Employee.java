package com.epam.valevach.final_project.entity;

import java.util.Objects;

public class Employee {
    private int id;
    private String position;
    private String empName;
    private String surName;
    private int salary;
    private int depId;

    public Employee() {
    }

    public Employee(int id, String position, String empName, String surName, int salary, int depId) {
        this.id = id;
        this.position = position;
        this.empName = empName;
        this.surName = surName;
        this.salary = salary;
        this.depId = depId;
    }

    public Employee(int depId, String name, String position, int salary, String surName) {
        this.position = position;
        this.empName = name;
        this.surName = surName;
        this.salary = salary;
        this.depId = depId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getDepId() {
        return depId;
    }

    public void setDepId(int depId) {
        this.depId = depId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && salary == employee.salary && depId == employee.depId && position.equals(employee.position) && empName.equals(employee.empName) && surName.equals(employee.surName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, position, empName, surName, salary, depId);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", position='" + position + '\'' +
                ", empName='" + empName + '\'' +
                ", surName='" + surName + '\'' +
                ", salary=" + salary +
                ", depId=" + depId +
                '}';
    }
}
