package com.epam.valevach.final_project.controller;


import com.epam.valevach.final_project.entity.User;
import com.epam.valevach.final_project.security.PasswordHashing;
import com.epam.valevach.final_project.service.user.UserServiceImpl;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private UserServiceImpl userService =  UserServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<String> allUsersLoginList = new ArrayList<>(userService.showAllUsers());
        Map<String, String> usersInfo = new HashMap<>(userService.userInfo());
        PasswordHashing ph = PasswordHashing.getInstance();
        String username = request.getParameter("login");
        String password = request.getParameter("password");
        boolean isProtected = usersInfo.containsValue(ph.passwordHashing(password));

        if (allUsersLoginList.contains(username) && isProtected) {
            User user = userService.find(username);

            if (user != null) {
                request.getSession().setAttribute("user", user);
                response.sendRedirect("/homeMenu");
                return;
            }

        } else {
           String errorLogin = "This login is incorrect,try again";
            request.setAttribute("errorLogin", errorLogin);
        }


        request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
        response.sendRedirect("/login");
    }

}
