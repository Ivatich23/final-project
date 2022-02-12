package com.epam.valevach.final_project.controller.employee;

import com.epam.valevach.final_project.controller.SingOutServlet;
import com.epam.valevach.final_project.entity.Employee;
import com.epam.valevach.final_project.exceptions.ChangeEmployeeDepartmentException;
import com.epam.valevach.final_project.exceptions.EmployeeOrderAssignedException;
import com.epam.valevach.final_project.exceptions.NewEmployeeException;
import com.epam.valevach.final_project.service.department.DepartmentServiceImpl;
import com.epam.valevach.final_project.service.employee.EmployeeServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateEmp")
public class UpdateEmployeeServletV1 extends HttpServlet {
    final Logger logger = LogManager.getLogger(UpdateEmployeeServletV1.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EmployeeServiceImpl employeeService = EmployeeServiceImpl.getInstance();
        Employee employee = new Employee();
        if (req.getParameter("action") == null) {
            EmployeeServiceImpl empService = EmployeeServiceImpl.getInstance();
            req.setAttribute("empService", empService);
            RequestDispatcher dispatcher = req.getRequestDispatcher(
                    "/WEB-INF/view/employee/showAllEmp.jsp");
            dispatcher.forward(req, resp);
        } else if ("new".equalsIgnoreCase(req.getParameter("action"))) {
            RequestDispatcher dispatcher = req.getRequestDispatcher(
                    "/WEB-INF/view/employee/createEmployee.jsp");
            dispatcher.forward(req, resp);
        } else if ("delete".equalsIgnoreCase(req.getParameter("action"))) {
            String empId = req.getParameter("id");
            employee.setId(Integer.parseInt(empId));
            try {
                employeeService.delete(employee);
            } catch (EmployeeOrderAssignedException e) {
                logger.error("Delete employee "+employee.getSurName()+" is failed");
                EmployeeServiceImpl empService = EmployeeServiceImpl.getInstance();
                req.setAttribute("empService", empService);
                String deleteEmployeeError1 = "delete orders";
                req.setAttribute("deleteEmployeeError1", deleteEmployeeError1);
                RequestDispatcher dispatcher = req.getRequestDispatcher(
                        "/WEB-INF/view/employee/showAllEmp.jsp");
                dispatcher.forward(req, resp);
            }
        } else {
            Employee newEmp = employeeService.read(Integer.valueOf(req.getParameter("id")));
            req.setAttribute("newEmp", newEmp);
            RequestDispatcher dispatcher = req.getRequestDispatcher(
                    "/WEB-INF/view/employee/updateEmployee.jsp");
            dispatcher.forward(req, resp);
        }
        resp.sendRedirect("/homeMenu");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EmployeeServiceImpl employeeService = EmployeeServiceImpl.getInstance();
        Employee employee = new Employee();
        int depId = Integer.parseInt(req.getParameter("depId"));
        String empName = req.getParameter("empName");
        String surName = req.getParameter("surName");
        String position = req.getParameter("position");
        int salary = Integer.parseInt(req.getParameter("salary"));
        employee.setEmpName(empName);
        employee.setSurName(surName);
        employee.setPosition(position);
        employee.setSalary(salary);
        employee.setDepId(depId);
        if ("new".equalsIgnoreCase(req.getParameter("action"))) {
            try {
                employeeService.create(employee);
            } catch (NewEmployeeException e) {
                logger.error("Create employee "+employee.getSurName()+" is failed");
                EmployeeServiceImpl empService = EmployeeServiceImpl.getInstance();
                req.setAttribute("empService", empService);
                String error = "invalid input,try again";
                req.setAttribute("error", error);
                RequestDispatcher dispatcher = req.getRequestDispatcher(
                        "/WEB-INF/view/employee/showAllEmp.jsp");
                dispatcher.forward(req, resp);
            }
        } else {
            employee.setId(Integer.parseInt(req.getParameter("id")));
            try {
                employeeService.update(employee);
            } catch (ChangeEmployeeDepartmentException   e) {
                logger.error("Update employee "+employee.getSurName()+" is failed");
                EmployeeServiceImpl empService = EmployeeServiceImpl.getInstance();
                req.setAttribute("empService", empService);
                String error = "invalid input,try again";
                req.setAttribute("error", error);
                RequestDispatcher dispatcher = req.getRequestDispatcher(
                        "/WEB-INF/view/employee/showAllEmp.jsp");
                dispatcher.forward(req, resp);
            }
        }
        resp.sendRedirect("/updateEmp");
    }
}
