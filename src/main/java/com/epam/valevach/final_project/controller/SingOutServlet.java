package com.epam.valevach.final_project.controller;




import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet("/singOut")
public class SingOutServlet extends HttpServlet {
    final Logger logger = LogManager.getLogger(SingOutServlet.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        logger.info("выход пользователя "+session.getAttribute("user"));
        resp.sendRedirect("/startPage");
        session.invalidate();
    }
}
