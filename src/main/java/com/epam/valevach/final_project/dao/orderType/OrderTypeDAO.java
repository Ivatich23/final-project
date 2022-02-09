package com.epam.valevach.final_project.dao.orderType;

import com.epam.valevach.final_project.dao.BaseDAO;
import com.epam.valevach.final_project.entity.OrderType;

import java.util.List;

public interface OrderTypeDAO extends BaseDAO< OrderType>{
    List<OrderType> showAllOrderType();
}
