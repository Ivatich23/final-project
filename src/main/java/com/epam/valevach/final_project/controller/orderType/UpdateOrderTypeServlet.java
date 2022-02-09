package com.epam.valevach.final_project.controller.orderType;

import com.epam.valevach.final_project.dao.orderType.OrderTypeDAOImpl;
import com.epam.valevach.final_project.entity.Order;
import com.epam.valevach.final_project.entity.OrderType;
import com.epam.valevach.final_project.service.order.OrderServiceImpl;
import com.epam.valevach.final_project.service.orderType.OrderTypeServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/updateOrderType")
public class UpdateOrderTypeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        OrderTypeServiceImpl orderTypeService = OrderTypeServiceImpl.getInstance();
        OrderType orderType = new OrderType();
        if(req.getParameter("action")==null) {
            OrderTypeServiceImpl orderTypeServ = OrderTypeServiceImpl.getInstance();
            req.setAttribute("orderTypeServ",orderTypeServ);
            RequestDispatcher dispatcher = req.getRequestDispatcher(
                    "/WEB-INF/view/orderType/showAllOrderType.jsp");
            dispatcher.forward(req, resp);
        } else if ("new".equalsIgnoreCase(req.getParameter("action"))) {
            RequestDispatcher dispatcher = req.getRequestDispatcher(
                    "/WEB-INF/view/orderType/createOrderType.jsp");
            dispatcher.forward(req, resp);
        } else if ("delete".equalsIgnoreCase(req.getParameter("action"))) {
            String orderTypeId = req.getParameter("id");
            orderType.setOrderTypeId(Integer.parseInt(orderTypeId));
            orderTypeService.delete(orderType);
        } else {
            OrderType newOrderType = orderTypeService.read(Integer.valueOf(req.getParameter("id")));
            req.setAttribute("newOrderType", newOrderType);
            RequestDispatcher dispatcher = req.getRequestDispatcher(
                    "/WEB-INF/view/orderType/updateOrderType.jsp");
            dispatcher.forward(req, resp);
        }
        resp.sendRedirect("/homeMenu");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        OrderTypeServiceImpl orderTypeService = OrderTypeServiceImpl.getInstance();
        OrderType orderType = new OrderType();
        String typeOfOrder = req.getParameter("typeOfOrder");
        orderType.setTypeOfOrder(typeOfOrder);
        if("new".equalsIgnoreCase(req.getParameter("action"))){
            orderTypeService.create(orderType);
        }else {
            int orderTypeId = Integer.parseInt(req.getParameter("id"));
            orderType.setOrderTypeId(orderTypeId);
            orderTypeService.update(orderType);
        }
        resp.sendRedirect("/homeMenu");
    }
}
