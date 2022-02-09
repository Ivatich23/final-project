package com.epam.valevach.final_project.controller.order;

import com.epam.valevach.final_project.entity.Order;
import com.epam.valevach.final_project.service.employee.EmployeeServiceImpl;
import com.epam.valevach.final_project.service.order.OrderServiceImpl;
import com.epam.valevach.final_project.service.orderType.OrderTypeServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/updateOrder")
public class UpdateOrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        OrderServiceImpl orderService = OrderServiceImpl.getInstance();
        Order order = new Order();
        if(req.getParameter("action")==null) {
            OrderServiceImpl orderServ = OrderServiceImpl.getInstance();
            req.setAttribute("orderServ",orderServ);
            RequestDispatcher dispatcher = req.getRequestDispatcher(
                    "/WEB-INF/view/order/showAllOrder.jsp");
            dispatcher.forward(req, resp);
        } else if ("new".equalsIgnoreCase(req.getParameter("action"))) {
            RequestDispatcher dispatcher = req.getRequestDispatcher(
                    "/WEB-INF/view/order/createOrder.jsp");
            dispatcher.forward(req, resp);
        } else if ("delete".equalsIgnoreCase(req.getParameter("action"))) {
            String orderId = req.getParameter("id");
            order.setOrderId(Integer.parseInt(orderId));
            orderService.delete(order);
        } else {
            Order newOrder = orderService.read(Integer.valueOf(req.getParameter("id")));
            req.setAttribute("newOrder", newOrder);
            RequestDispatcher dispatcher = req.getRequestDispatcher(
                    "/WEB-INF/view/order/updateOrder.jsp");
            dispatcher.forward(req, resp);
        }
        resp.sendRedirect("/homeMenu");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        OrderServiceImpl orderService = OrderServiceImpl.getInstance();
        EmployeeServiceImpl employeeService = EmployeeServiceImpl.getInstance();
        OrderTypeServiceImpl orderTypeService = OrderTypeServiceImpl.getInstance();
        Order order = new Order();
        int employeeId = Integer.parseInt(req.getParameter("employeeId"));
        int orderTypeId = Integer.parseInt(req.getParameter("orderTypeId"));
        int productionType = Integer.parseInt(req.getParameter("productionType"));
        int price = Integer.parseInt(req.getParameter("price"));
         if(!employeeService.checkEmployeeId(employeeId)){
             OrderServiceImpl orderServ = OrderServiceImpl.getInstance();
             req.setAttribute("orderServ",orderServ);
                String wrongEmployeeIdMess = "Wrong id";
                req.setAttribute("wrongEmployeeIdMess",wrongEmployeeIdMess);
                RequestDispatcher dispatcher = req.getRequestDispatcher(
                        "/WEB-INF/view/order/showAllOrder.jsp");
                dispatcher.forward(req, resp);
            }
            order.setEmployeeId(employeeId);
            order.setOrderTypeId(orderTypeId);

        order.setProductionType(productionType);
        order.setPrice(price);
        if("new".equalsIgnoreCase(req.getParameter("action"))){
            orderService.create(order);
        }else {
            int orderId = Integer.parseInt(req.getParameter("id"));
            order.setOrderId(orderId);
            orderService.update(order);
        }

    }
}
