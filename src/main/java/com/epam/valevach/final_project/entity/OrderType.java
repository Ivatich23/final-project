package com.epam.valevach.final_project.entity;

import java.util.Objects;

public class OrderType {
    private int orderTypeId;
    private String typeOfOrder;

    public OrderType() {
    }

    public OrderType(int orderTypeId, String typeOfOrder) {
        this.orderTypeId = orderTypeId;
        this.typeOfOrder = typeOfOrder;
    }

    public int getOrderTypeId() {
        return orderTypeId;
    }

    public void setOrderTypeId(int orderTypeId) {
        this.orderTypeId = orderTypeId;
    }

    public String getTypeOfOrder() {
        return typeOfOrder;
    }

    public void setTypeOfOrder(String typeOfOrder) {
        this.typeOfOrder = typeOfOrder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderType orderType = (OrderType) o;
        return orderTypeId == orderType.orderTypeId && typeOfOrder.equals(orderType.typeOfOrder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderTypeId, typeOfOrder);
    }

    @Override
    public String toString() {
        return "OrderType{" +
                "orderTypeId=" + orderTypeId +
                ", typeOfOrder='" + typeOfOrder + '\'' +
                '}';
    }
}
