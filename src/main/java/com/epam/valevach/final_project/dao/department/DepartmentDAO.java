package com.epam.valevach.final_project.dao.department;

import com.epam.valevach.final_project.dao.BaseDAO;
import com.epam.valevach.final_project.entity.Department;
import com.epam.valevach.final_project.entity.Employee;

import java.util.List;

public interface DepartmentDAO extends BaseDAO<Department> {
    List<Department>showAllDepartments();
}
