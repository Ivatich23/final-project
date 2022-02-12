package com.epam.valevach.final_project.dao.role;

import com.epam.valevach.final_project.dao.ConnectionToMySQL;
import com.epam.valevach.final_project.dao.order.OrderDAOImpl;
import com.epam.valevach.final_project.entity.Role;
import com.epam.valevach.final_project.util.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RoleDAOImpl implements RoleDAO {
    private static RoleDAOImpl instance;
    private static final String INSERT_ROLE = "INSERT INTO " +
            "role (role) VALUES(?)";
    private static final String READ_ROLE = "SELECT role" +
            " FROM role WHERE order_type_id = ?";
    private static final String DELETE_ROLE = "DELETE FROM " +
            "role WHERE id = ?";
    private static final String UPDATE_ROLE = "UPDATE  " +
            "role SET  role= ? WHERE id  = ?";
    private static final String FIND_ROLE = "SELECT role FROM  " +
            "role WHERE role = ?";
    private RoleDAOImpl(){}
    public static RoleDAOImpl getInstance(){
        synchronized (RoleDAOImpl.class) {
            if (instance == null) {
                instance = new RoleDAOImpl();
            }
            return instance;
        }
    }

    @Override
    public void create(Role entity) {
        try (Connection dbConnection = ConnectionManager.get();
             PreparedStatement preparedStatement = dbConnection.prepareStatement(INSERT_ROLE)) {
            preparedStatement.setString(1, entity.getRole());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Role read(Integer id) {
        Role role = new Role();
        try (Connection dbConnection = ConnectionManager.get();
             PreparedStatement preparedStatement = dbConnection.prepareStatement(READ_ROLE)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                role.setRole(resultSet.getString("role"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return role;
    }

    @Override
    public void delete(Role entity) {
        try (Connection dbConnection = ConnectionManager.get();
             PreparedStatement preparedStatement = dbConnection.prepareStatement(DELETE_ROLE)) {
            preparedStatement.setInt(1, entity.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Role entity) {
        try (Connection dbConnection = ConnectionManager.get();
             PreparedStatement preparedStatement = dbConnection.prepareStatement(UPDATE_ROLE)) {
            preparedStatement.setString(1, entity.getRole());
            preparedStatement.setInt(2, entity.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Role findRole(String role) {
        Role role1 = new Role();
        try (Connection dbConnection = ConnectionManager.get();
             PreparedStatement preparedStatement = dbConnection.prepareStatement(FIND_ROLE)) {
            preparedStatement.setString(1, role);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                role1.setRole(resultSet.getString("role"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return role1;
    }
}
