package com.epam.valevach.final_project.controller;

import com.epam.valevach.final_project.entity.User;
import com.epam.valevach.final_project.security.PasswordHashing;
import com.epam.valevach.final_project.service.user.UserServiceImpl;
import com.epam.valevach.final_project.validator.UserInputValidation;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/reg")
public class RegistrationServlet extends HttpServlet {
    UserServiceImpl userService = UserServiceImpl.getInstance();
    private List<String> userList = new ArrayList<>(userService.showAllUsers());


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher dispatcher = req.getRequestDispatcher(
                "/WEB-INF/view/registration.jsp");
        dispatcher.forward(req, resp);
    }

    @Override

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserInputValidation validation = UserInputValidation.getInstance();
        PasswordHashing ph = PasswordHashing.getInstance();
        User user = new User();
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        if (!userList.contains(login) && validation.instance.checkLengthLimit(login) && validation.instance.checkLengthLimit(password)) {
            user.setLogin(login);
            user.setPassword(ph.passwordHashing(password));
            user.setRole(3);
            user.setUserRole("user");
            userService.create(user);
        } else {
            String error = "invalid login,try again";
            req.setAttribute("error", error);
            RequestDispatcher dispatcher = req.getRequestDispatcher(
                    "/WEB-INF/view/registration.jsp");
            dispatcher.forward(req, resp);
        }

        resp.sendRedirect("/startPage");

    }


}
