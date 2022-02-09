package com.epam.valevach.final_project.service.orderType;

import com.epam.valevach.final_project.entity.OrderType;
import com.epam.valevach.final_project.service.BaseService;

import java.util.List;

public interface OrderTypeService extends BaseService<OrderType> {
    List<OrderType> showAllOrderType();
    boolean checkOrderTypeId(int id);
}
