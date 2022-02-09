package com.epam.valevach.final_project.dao.department;

import com.epam.valevach.final_project.dao.ConnectionToMySQL;
import com.epam.valevach.final_project.entity.Department;
import com.epam.valevach.final_project.util.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDAOImpl implements DepartmentDAO {
    private static  DepartmentDAOImpl instance;
    private static final String INSERT_DEPARTMENT = "INSERT INTO " +
            "department (dep_name,dep_position) VALUES(?,?)";
    private static final String READ_DEPARTMENT = "SELECT dep_id,dep_name,dep_position FROM " +
            "department WHERE dep_id  = ?";
    private static final String DELETE_DEPARTMENT = "DELETE FROM " +
            "department WHERE dep_id = ?";
    private static final String UPDATE_DEPARTMENT = "UPDATE  " +
            "department SET dep_name = ?,dep_position =? WHERE dep_id = ?";
    private static final String SHOW_ALL_DEPARTMENTS = "SELECT dep_id,dep_name,dep_position FROM " +
            "department ";
    private DepartmentDAOImpl(){}

    public static  DepartmentDAOImpl getInstance(){
        if(instance ==null){
            instance = new DepartmentDAOImpl();
        }
        return instance;
    }
    @Override
    public void create(Department entity) {
        try (Connection dbConnection = ConnectionManager.get();
             PreparedStatement preparedStatement = dbConnection.prepareStatement(INSERT_DEPARTMENT)) {
            preparedStatement.setString(1, entity.getDepName());
            preparedStatement.setString(2, entity.getDepPosition());

            preparedStatement.executeUpdate();

        } catch ( SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Department read(Integer id) {
        Department department = new Department();
        try (Connection dbConnection = ConnectionManager.get();
             PreparedStatement preparedStatement = dbConnection.prepareStatement(READ_DEPARTMENT)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                department.setDepId(resultSet.getInt("dep_id"));
                department.setDepPosition(resultSet.getString("dep_position"));
                department.setDepName(resultSet.getString("dep_name"));
            }

        } catch ( SQLException e) {
            e.printStackTrace();
        }
        return department;
    }

    @Override
    public void delete(Department entity) {
        try (Connection dbConnection = ConnectionManager.get();
             PreparedStatement preparedStatement = dbConnection.prepareStatement(DELETE_DEPARTMENT)) {
            preparedStatement.setInt(1, entity.getDepId());
            preparedStatement.executeUpdate();

        } catch ( SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Department entity) {
        try (Connection dbConnection = ConnectionManager.get();
             PreparedStatement preparedStatement = dbConnection.prepareStatement(UPDATE_DEPARTMENT)) {
            preparedStatement.setString(1, entity.getDepName());
            preparedStatement.setString(2, entity.getDepPosition());
            preparedStatement.setInt(3, entity.getDepId());
            preparedStatement.executeUpdate();

        } catch ( SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Department> showAllDepartments() {
        List<Department> allDepartments = new ArrayList<>();
        try (Connection dbConnection = ConnectionManager.get();
             Statement statement = dbConnection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SHOW_ALL_DEPARTMENTS);
            while (resultSet.next()) {
                Department department = new Department();
                department.setDepId(resultSet.getInt("dep_id"));
                department.setDepPosition(resultSet.getString("dep_position"));
                department.setDepName(resultSet.getString("dep_name"));
                allDepartments.add(department);
            }
        } catch ( SQLException e) {
            e.printStackTrace();
        }
        return allDepartments;
    }
}
