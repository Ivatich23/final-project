package com.epam.valevach.final_project.controller.department;

import com.epam.valevach.final_project.controller.SingOutServlet;
import com.epam.valevach.final_project.entity.Department;
import com.epam.valevach.final_project.exceptions.CreateDepartmentException;
import com.epam.valevach.final_project.exceptions.DeleteDepartmentException;
import com.epam.valevach.final_project.service.department.DepartmentServiceImpl;
import com.epam.valevach.final_project.validator.UserInputValidation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateDep")
public class UpdateDepartmentServlet extends HttpServlet {
    final Logger logger = LogManager.getLogger(UpdateDepartmentServlet.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DepartmentServiceImpl departmentService = DepartmentServiceImpl.getInstance();
        Department department = new Department();
        if (req.getParameter("action") == null) {
            DepartmentServiceImpl depService = DepartmentServiceImpl.getInstance();
            req.setAttribute("depService", depService);
            RequestDispatcher dispatcher = req.getRequestDispatcher(
                    "/WEB-INF/view/department/showAllDepartment.jsp");
            dispatcher.forward(req, resp);
        } else if ("newDep".equalsIgnoreCase(req.getParameter("action"))) {
            RequestDispatcher dispatcher = req.getRequestDispatcher(
                    "/WEB-INF/view/department/createDepartment.jsp");
            dispatcher.forward(req, resp);
        } else if ("delete".equalsIgnoreCase(req.getParameter("action"))) {
            String depId = req.getParameter("depId");
            department.setDepId(Integer.parseInt(depId));
            try {
                departmentService.delete(department);
            }catch (DeleteDepartmentException e){
                logger.error("Delete department "+department.getDepName()+" is failed");
                DepartmentServiceImpl depService = DepartmentServiceImpl.getInstance();
                req.setAttribute("depService", depService);
                String error = "invalid input,try again";
                req.setAttribute("error", error);
                RequestDispatcher dispatcher = req.getRequestDispatcher(
                        "/WEB-INF/view/department/showAllDepartment.jsp");
                dispatcher.forward(req, resp);
            }
        } else {
            Department newDep = departmentService.read(Integer.valueOf(req.getParameter("depId")));
            req.setAttribute("newDep", newDep);
            RequestDispatcher dispatcher = req.getRequestDispatcher(
                    "/WEB-INF/view/department/updateDepartment.jsp");
            dispatcher.forward(req, resp);
        }
        resp.sendRedirect("/homeMenu");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DepartmentServiceImpl departmentService = DepartmentServiceImpl.getInstance();
        Department department = new Department();
        String depName = req.getParameter("depName");
        String depPosition = req.getParameter("depPosition");
        department.setDepName(depName);
        department.setDepPosition(depPosition);
        if ("new".equalsIgnoreCase(req.getParameter("action"))) {
           try {
               departmentService.create(department);
           }catch (CreateDepartmentException e){
               logger.error("Create department "+department.getDepName()+" is failed");
               DepartmentServiceImpl depService = DepartmentServiceImpl.getInstance();
               req.setAttribute("depService", depService);
               String error = "invalid input,try again";
               req.setAttribute("error", error);
               RequestDispatcher dispatcher = req.getRequestDispatcher(
                       "/WEB-INF/view/department/showAllDepartment.jsp");
               dispatcher.forward(req, resp);
           }
        } else {
            int depId = Integer.parseInt(req.getParameter("depId"));
            department.setDepId(depId);
            departmentService.update(department);
        }
        resp.sendRedirect("/homeMenu");
    }
}
