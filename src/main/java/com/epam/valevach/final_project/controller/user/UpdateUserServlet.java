package com.epam.valevach.final_project.controller.user;

import com.epam.valevach.final_project.entity.User;
import com.epam.valevach.final_project.service.user.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateUsers")
public class UpdateUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserServiceImpl userService = UserServiceImpl.getInstance();
        User user = new User();
        if (req.getParameter("action") == null) {
            UserServiceImpl userServ = UserServiceImpl.getInstance();
            req.setAttribute("userServ",userServ);
            RequestDispatcher dispatcher = req.getRequestDispatcher(
                    "/WEB-INF/view/user/showAllUsers.jsp");
            dispatcher.forward(req, resp);
        } else if ("delete".equalsIgnoreCase(req.getParameter("action"))) {
            String userId = req.getParameter("userId");
            user.setId(Integer.parseInt(userId));
            userService.delete(user);
        } else {
            User newUser = userService.read(Integer.valueOf(req.getParameter("userId")));
            req.setAttribute("newUser", newUser);
            RequestDispatcher dispatcher = req.getRequestDispatcher(
                    "/WEB-INF/view/user/updateUser.jsp");
            dispatcher.forward(req, resp);
        }
        resp.sendRedirect("/homeMenu");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserServiceImpl userService = UserServiceImpl.getInstance();
        User user = new User();
        int userRole = Integer.parseInt(req.getParameter("role"));
        int userId = Integer.parseInt(req.getParameter("id"));
        if (userRole < 4 && userRole > 0) {
            user.setId(userId);
            user.setRole(userRole);
            userService.update(user);
        }else {
            UserServiceImpl userServ = UserServiceImpl.getInstance();
            req.setAttribute("userServ",userServ);
            String message = "Incorrect input userRole";
            req.setAttribute("message",message);
            RequestDispatcher dispatcher = req.getRequestDispatcher(
                    "/WEB-INF/view/user/updateUser.jsp");
            dispatcher.forward(req, resp);
        }
        resp.sendRedirect("/homeMenu");
    }
}
