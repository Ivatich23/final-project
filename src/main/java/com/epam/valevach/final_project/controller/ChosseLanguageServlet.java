package com.epam.valevach.final_project.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/lang")

public class ChosseLanguageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("language") == null) {
            RequestDispatcher dispatcher = req.getRequestDispatcher(
                    "/WEB-INF/view/chooseLanguage.jsp");
            dispatcher.forward(req, resp);
        } else {
            HttpSession session = req.getSession();
            String language =  req.getParameter("language");
            session.setAttribute("language", language);
            RequestDispatcher dispatcher = req.getRequestDispatcher(
                    "/WEB-INF/view/homeMenuAndStartPage/startPage.jsp");
            dispatcher.forward(req, resp);
        }

    }
}
