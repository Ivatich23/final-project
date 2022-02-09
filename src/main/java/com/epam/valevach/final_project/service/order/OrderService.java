package com.epam.valevach.final_project.service.order;

import com.epam.valevach.final_project.entity.Order;
import com.epam.valevach.final_project.service.BaseService;

import java.util.List;

public interface OrderService extends BaseService<Order> {
    List<Order> showAllOrders();
}
