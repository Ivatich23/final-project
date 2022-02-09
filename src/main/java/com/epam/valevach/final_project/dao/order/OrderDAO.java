package com.epam.valevach.final_project.dao.order;

import com.epam.valevach.final_project.dao.BaseDAO;
import com.epam.valevach.final_project.entity.Order;

import java.util.List;

public interface OrderDAO extends BaseDAO<Order> {
    List<Order> showAllOrders();

    Order orderToEmployee(Order entity);
}
