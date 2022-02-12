package com.epam.valevach.final_project.dao.orderType;

import com.epam.valevach.final_project.dao.ConnectionToMySQL;
import com.epam.valevach.final_project.dao.order.OrderDAOImpl;
import com.epam.valevach.final_project.entity.Department;
import com.epam.valevach.final_project.entity.OrderType;
import com.epam.valevach.final_project.util.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OrderTypeDAOImpl implements OrderTypeDAO{
    private static OrderTypeDAOImpl instance;
    private static final String INSERT_ORDER_TYPE = "INSERT INTO " +
            "order_type (type_of_order) VALUES(?)";
    private static final String READ_ORDER_TYPE = "SELECT order_type_id, type_of_order" +
            " FROM order_type WHERE order_type_id = ?";
    private static final String DELETE_ORDER_TYPE = "DELETE FROM " +
            "order_type WHERE order_type_id = ?";
    private static final String UPDATE_ORDER_TYPE = "UPDATE  " +
            "order_type SET  type_of_order= ? WHERE order_type_id  = ?";
    private static final String SHOW_ALL_ORDER_TYPE = "SELECT order_type_id,type_of_order FROM " +
            "order_type ";
    private OrderTypeDAOImpl(){}
    public static OrderTypeDAOImpl getInstance(){
        synchronized (OrderDAOImpl.class) {
            if (instance == null) {
                instance = new OrderTypeDAOImpl();
            }
            return instance;
        }
    }
    @Override
    public void create(OrderType entity) {
        try (Connection dbConnection = ConnectionManager.get();
             PreparedStatement preparedStatement = dbConnection.prepareStatement(INSERT_ORDER_TYPE)) {
            preparedStatement.setString(1, entity.getTypeOfOrder());

            preparedStatement.executeUpdate();

        } catch ( SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public OrderType read(Integer id) {
        OrderType orderType = new OrderType();
        try (Connection dbConnection = ConnectionManager.get();
             PreparedStatement preparedStatement = dbConnection.prepareStatement(READ_ORDER_TYPE)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                orderType.setOrderTypeId(Integer.parseInt(resultSet.getString("order_type_id")));
                orderType.setTypeOfOrder(resultSet.getString("type_of_order"));
            }

        } catch ( SQLException e) {
            e.printStackTrace();
        }
        return orderType;
    }

    @Override
    public void delete(OrderType entity) {
        try (Connection dbConnection = ConnectionManager.get();
             PreparedStatement preparedStatement = dbConnection.prepareStatement(DELETE_ORDER_TYPE)) {
            preparedStatement.setInt(1, entity.getOrderTypeId());
            preparedStatement.executeUpdate();

        } catch ( SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(OrderType entity) {
        try (Connection dbConnection = ConnectionManager.get();
             PreparedStatement preparedStatement = dbConnection.prepareStatement(UPDATE_ORDER_TYPE)) {
            preparedStatement.setString(1, entity.getTypeOfOrder());
            preparedStatement.setInt(2, entity.getOrderTypeId());
            preparedStatement.executeUpdate();

        } catch ( SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<OrderType> showAllOrderType() {
        List<OrderType> allOrderTypes = new ArrayList<>();
        try (Connection dbConnection = ConnectionManager.get();
             Statement statement = dbConnection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SHOW_ALL_ORDER_TYPE);
            while (resultSet.next()) {
               OrderType orderType = new OrderType();
                orderType.setOrderTypeId(resultSet.getInt("order_type_id"));
                orderType.setTypeOfOrder(resultSet.getString("type_of_order"));
                allOrderTypes.add(orderType);
            }
        } catch ( SQLException e) {
            e.printStackTrace();
        }
        return allOrderTypes;
    }
}
