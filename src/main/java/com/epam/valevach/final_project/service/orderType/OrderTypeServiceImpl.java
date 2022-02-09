package com.epam.valevach.final_project.service.orderType;

import com.epam.valevach.final_project.dao.orderType.OrderTypeDAOImpl;
import com.epam.valevach.final_project.entity.OrderType;
import com.epam.valevach.final_project.service.order.OrderServiceImpl;

import java.util.List;

public class OrderTypeServiceImpl implements OrderTypeService {
    OrderTypeDAOImpl orderTypeDAO = OrderTypeDAOImpl.getInstance();
    private static OrderTypeServiceImpl instance;
    private OrderTypeServiceImpl(){}
    public static OrderTypeServiceImpl getInstance(){
        synchronized (OrderTypeServiceImpl.class) {
            if (instance == null) {
                instance = new OrderTypeServiceImpl();
            }
        }
        return instance;
    }

    @Override
    public void create(OrderType entity) {
        orderTypeDAO.create(entity);
    }

    @Override
    public OrderType read(Integer id) {
        return orderTypeDAO.read(id);
    }

    @Override
    public void delete(OrderType entity) {
        orderTypeDAO.delete(entity);
    }

    @Override
    public void update(OrderType entity) {
        orderTypeDAO.update(entity);
    }

    @Override
    public List<OrderType> showAllOrderType() {
        return orderTypeDAO.showAllOrderType();
    }

    @Override
    public boolean checkOrderTypeId(int id) {
        List<OrderType> checkList = showAllOrderType();
        for (OrderType orderType : checkList) {
            if(orderType.getOrderTypeId()==id){
                return true;
            }
        }
        return false;
    }
}
