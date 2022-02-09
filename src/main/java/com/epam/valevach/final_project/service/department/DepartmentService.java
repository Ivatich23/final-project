package com.epam.valevach.final_project.service.department;

import com.epam.valevach.final_project.entity.Department;
import com.epam.valevach.final_project.service.BaseService;

import java.util.List;

public interface DepartmentService extends BaseService<Department> {
    List<Department> showAllDepartments();
}
