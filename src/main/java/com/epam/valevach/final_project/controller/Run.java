package com.epam.valevach.final_project.controller;

import com.epam.valevach.final_project.dao.department.DepartmentDAOImpl;
import com.epam.valevach.final_project.entity.Department;

import java.io.File;

public class Run {
    public static void main(String[] args) {
        Department department = new Department("asd","asd",5);
        DepartmentDAOImpl departmentDAO = DepartmentDAOImpl.getInstance();
        departmentDAO.delete(department);


    }
}
