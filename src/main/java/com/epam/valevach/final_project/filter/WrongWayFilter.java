package com.epam.valevach.final_project.filter;

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
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
@WebFilter("/*")
public class WrongWayFilter implements Filter {
    private static final Set<String> ALLOWED_PATHS = Collections.unmodifiableSet(new HashSet<>(
            Arrays.asList("/singOut", "/reg", "/lang", "/singOut", "/updateDep", "/updateEmp","/login",
                    "/updateOrder", "/updateOrderType", "/homeMenu", "/startPage", "/updateUsers")));

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String path = request.getRequestURI()
                .substring(request.getContextPath().length()).replaceAll("[/]+$", "");
        if (!ALLOWED_PATHS.contains(path) ) {
            String wrongWay = "delete";
            servletRequest.setAttribute("wrongWay", wrongWay);
            request.getRequestDispatcher("/WEB-INF/view/wrongWay.jsp").forward(request, response);
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
