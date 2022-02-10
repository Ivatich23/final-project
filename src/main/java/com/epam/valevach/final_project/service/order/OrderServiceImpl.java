package com.epam.valevach.final_project.service.order;

import com.epam.valevach.final_project.dao.order.OrderDAOImpl;
import com.epam.valevach.final_project.entity.Order;
import com.epam.valevach.final_project.service.employee.EmployeeServiceImpl;
import com.epam.valevach.final_project.validator.EmployeeDeleteValidation;

import java.util.List;

public class OrderServiceImpl implements OrderService {
    OrderDAOImpl orderDAO = OrderDAOImpl.getInstance();
    private static OrderServiceImpl instance;
    private OrderServiceImpl(){}
    public static OrderServiceImpl getInstance(){
        synchronized (OrderServiceImpl.class) {
            if (instance == null) {
                instance = new OrderServiceImpl();
            }
        }
        return instance;
    }

    @Override
    public List<Order> showAllOrders() {
        return orderDAO.showAllOrders();
    }

    @Override
    public void create(Order entity) {
        orderDAO.create(entity);
    }

    @Override
    public Order read(Integer id) {

        return orderDAO.read(id);
    }

    @Override
    public void delete(Order entity) {
        orderDAO.delete(entity);
    }

    @Override
    public void update(Order entity) {
        orderDAO.update(entity);
    }
}
