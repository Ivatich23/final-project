package com.epam.valevach.final_project.controller;

import com.epam.valevach.final_project.dao.order.OrderDAOImpl;
import com.epam.valevach.final_project.entity.Employee;

public class Run {
    public static void main(String[] args) {
        Employee employee = new Employee(5,"disayner","Kirill",
                "Valevach",10,4);
        OrderDAOImpl orderDAO = OrderDAOImpl.getInstance();
        System.out.println(orderDAO.findOrdersByEmployeeId(employee));


    }
}
