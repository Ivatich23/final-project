package com.epam.valevach.final_project.service.employee;

import com.epam.valevach.final_project.entity.Employee;
import com.epam.valevach.final_project.service.BaseService;

import java.util.List;

public interface EmployeeService extends BaseService<Employee> {
    List<Employee> readEmployeesByDepartment(Integer depId);
    List<Employee> sowAllEmployee();
   boolean checkEmployeeId(int id);
}
