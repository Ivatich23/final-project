package com.epam.valevach.final_project.filter;

import com.epam.valevach.final_project.controller.user.UpdateUserServlet;
import com.epam.valevach.final_project.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebFilter(urlPatterns = {"/updateOrderType", "/updateUsers"})
public class AssignmentRoleFilter implements Filter {
    final Logger logger = LogManager.getLogger(UpdateUserServlet.class);
    private static final List<String> ADMIN_PATH = new ArrayList<>(
            Arrays.asList("/updateDep", "/updateEmp", "/updateOrder", "/updateOrderType", "/updateUsers"));
    private static final List<String> USER_PATH = new ArrayList<>(
            Arrays.asList("/updateDep", "/updateOrderType"));
    private static final List<String> DIRECTOR_PATH = new ArrayList<>(
            Arrays.asList("/updateDep", "/updateEmp", "/updateOrder", "/updateOrderType"));
    private static final Map<String, List<String>> ALLOWED_PATH_FOR_CLIENT;

    static {
        ALLOWED_PATH_FOR_CLIENT = new HashMap<>();
        ALLOWED_PATH_FOR_CLIENT.put("admin", ADMIN_PATH);
        ALLOWED_PATH_FOR_CLIENT.put("director", DIRECTOR_PATH);
        ALLOWED_PATH_FOR_CLIENT.put("user", USER_PATH);
    }


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        HttpSession session = request.getSession();
        String path = request.getRequestURI().substring(request.getContextPath().length()).replaceAll("[/]+$", "");
        User user = (User) session.getAttribute("user");
        List<String> containPath = new ArrayList<>();
        if (user != null) {
            containPath = ALLOWED_PATH_FOR_CLIENT.get(user.getUserRole());

            boolean allowedPath = containPath.contains(path);
            if (allowedPath) {
                filterChain.doFilter(req, res);

            } else {
                logger.error("User with "+user.getLogin()+ " is access denied");
                String message = "???????????????? ?? ??????????????";
                req.setAttribute("message", message);
                RequestDispatcher dispatcher = req.getRequestDispatcher(
                        "/WEB-INF/view/homeMenuAndStartPage/startPage.jsp");
                dispatcher.forward(req, res);
            }
        }else {
            response.sendRedirect("/homeMenu");
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
