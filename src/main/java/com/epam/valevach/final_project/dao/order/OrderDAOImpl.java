package com.epam.valevach.final_project.dao.order;

import com.epam.valevach.final_project.entity.Employee;
import com.epam.valevach.final_project.entity.Order;
import com.epam.valevach.final_project.util.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OrderDAOImpl implements OrderDAO {
    private static OrderDAOImpl instance;
    private static final String INSERT_ORDER = "INSERT INTO " +
            "order_table (employee_id,order_type_id,price,production_time) VALUES(?,?,?,?)";
    private static final String READ_ORDER = "SELECT order_id,employee_id,order_type_id,price,production_time" +
            " FROM order_table WHERE order_id  = ?";
    private static final String DELETE_ORDER = "DELETE FROM " +
            "order_table WHERE order_id = ?";
    private static final String UPDATE_ORDER = "UPDATE  " +
            "order_table SET employee_id= ?,order_type_id =?,price =?,production_time =? WHERE order_id  = ?";
    private static final String SHOW_ALL_ORDERS = "SELECT order_id,employee_id,type.type_of_order,price,production_time" +
            " FROM order_table ot  JOIN order_type type ON (ot.order_type_id = type.order_type_id) ";
    private static final String SHOW_ORDER_TO_EMPLOYEE_ID = "SELECT employee_id FROM " +
            "order_table  where employee_id =?";

    private OrderDAOImpl() {
    }

    public static OrderDAOImpl getInstance() {
        synchronized (OrderDAOImpl.class) {
            if (instance == null) {
                instance = new OrderDAOImpl();
            }
            return instance;
        }
    }

    @Override
    public void create(Order entity) {
        try (Connection dbConnection = ConnectionManager.get();
             PreparedStatement preparedStatement = dbConnection.prepareStatement(INSERT_ORDER)) {
            preparedStatement.setInt(1, entity.getEmployeeId());
            preparedStatement.setInt(2, entity.getOrderTypeId());
            preparedStatement.setInt(3, entity.getPrice());
            preparedStatement.setInt(4, entity.getProductionType());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Order read(Integer id) {
        Order order = new Order();
        try (Connection dbConnection = ConnectionManager.get();
             PreparedStatement preparedStatement = dbConnection.prepareStatement(READ_ORDER)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                order.setOrderId(resultSet.getInt("order_id"));
                order.setEmployeeId(resultSet.getInt("employee_id"));
                order.setOrderTypeId(resultSet.getInt("order_type_id"));
                order.setPrice(resultSet.getInt("price"));
                order.setProductionType(resultSet.getInt("production_time"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return order;
    }

    @Override
    public void delete(Order entity) {
        try (Connection dbConnection = ConnectionManager.get();
             PreparedStatement preparedStatement = dbConnection.prepareStatement(DELETE_ORDER)) {
            preparedStatement.setInt(1, entity.getOrderId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Order entity) {
        try (Connection dbConnection = ConnectionManager.get();
             PreparedStatement preparedStatement = dbConnection.prepareStatement(UPDATE_ORDER)) {
            preparedStatement.setInt(1, entity.getEmployeeId());
            preparedStatement.setInt(2, entity.getOrderTypeId());
            preparedStatement.setInt(3, entity.getPrice());
            preparedStatement.setInt(4, entity.getProductionType());
            preparedStatement.setInt(5, entity.getOrderId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Order> showAllOrders() {
        List<Order> allOrders = new ArrayList<>();
        try (Connection dbConnection = ConnectionManager.get();
             Statement statement = dbConnection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SHOW_ALL_ORDERS);
            while (resultSet.next()) {
                Order order = new Order();
                order.setOrderId(resultSet.getInt("order_id"));
                order.setEmployeeId(resultSet.getInt("employee_id"));
                order.setTypeOfOrder(resultSet.getString("type.type_of_order"));
                order.setPrice(resultSet.getInt("price"));
                order.setProductionType(resultSet.getInt("production_time"));
                allOrders.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allOrders;
    }

    @Override
    public List<Order> findOrdersByEmployeeId(Employee entity) {
        List<Order> employeeOrders = new ArrayList<>();
        try (Connection dbConnection = ConnectionManager.get();
             PreparedStatement preparedStatement = dbConnection.prepareStatement(SHOW_ORDER_TO_EMPLOYEE_ID)) {
            preparedStatement.setInt(1, entity.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Order order = new Order();
                order.setEmployeeId(resultSet.getInt("employee_id"));
                employeeOrders.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeOrders;
    }


}
