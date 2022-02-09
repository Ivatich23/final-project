package com.epam.valevach.final_project.dao.employee;

import com.epam.valevach.final_project.dao.BaseDAO;
import com.epam.valevach.final_project.entity.Employee;

import java.util.List;

public interface EmployeeDAO extends BaseDAO<Employee> {
   List<Employee> readEmployeesByDepartment(Integer depId);
   List<Employee> showAllEmployee();
}
