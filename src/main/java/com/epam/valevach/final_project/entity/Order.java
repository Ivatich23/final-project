package com.epam.valevach.final_project.entity;

import java.util.Objects;

public class Order {
    private int employeeId;
    private int orderId;
    private int orderTypeId;
    private int productionType;
    private int price;
    private String typeOfOrder;

    public Order() {
    }

    public Order(int employeeId, int orderId, int orderTypeId, int productionType, int price, String typeOfOrder) {
        this.employeeId = employeeId;
        this.orderId = orderId;
        this.orderTypeId = orderTypeId;
        this.productionType = productionType;
        this.price = price;
        this.typeOfOrder = typeOfOrder;
    }

    public Order(int employeeId, int orderId, int productionType, int price) {
        this.employeeId = employeeId;
        this.orderId = orderId;
        this.productionType = productionType;
        this.price = price;
    }

  /*  public Order(int employeeId, int orderId, int orderTypeId, int productionType, int price) {
        this.employeeId = employeeId;
        this.orderId = orderId;
        this.orderTypeId = orderTypeId;
        this.productionType = productionType;
        this.price = price;
    }*/

    public String getTypeOfOrder() {
        return typeOfOrder;
    }

    public void setTypeOfOrder(String typeOfOrder) {
        this.typeOfOrder = typeOfOrder;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getOrderTypeId() {
        return orderTypeId;
    }

    public void setOrderTypeId(int orderTypeId) {
        this.orderTypeId = orderTypeId;
    }

    public int getProductionType() {
        return productionType;
    }

    public void setProductionType(int productionType) {
        this.productionType = productionType;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order orders = (Order) o;
        return employeeId == orders.employeeId && orderId == orders.orderId && orderTypeId == orders.orderTypeId && productionType == orders.productionType && price == orders.price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, orderId, orderTypeId, productionType, price);
    }

    @Override
    public String toString() {
        return "Order{" +
                "employeeId=" + employeeId +
                ", orderId=" + orderId +
                ", orderTypeId=" + orderTypeId +
                ", productionType=" + productionType +
                ", price=" + price +
                '}';
    }
}
