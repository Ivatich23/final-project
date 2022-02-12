package com.epam.valevach.final_project.dao.employee;

import com.epam.valevach.final_project.dao.ConnectionToMySQL;
import com.epam.valevach.final_project.entity.Employee;
import com.epam.valevach.final_project.util.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
    private static EmployeeDAOImpl instance;
    private static final String INSERT_EMPLOYEE = "INSERT INTO " +
            "employees (dep_id,emp_name,position,salary,surname) VALUES(?,?,?,?,?)";
    private static final String READ_EMPLOYEE = "SELECT id, dep_id,emp_name,position,salary,surname FROM " +
            "employees WHERE id  = ?";
    private static final String DELETE_EMPLOYEE = "DELETE FROM " +
            "employees WHERE id = ?";
    private static final String UPDATE_EMPLOYEE = "UPDATE  " +
            "employees SET dep_id = ?,emp_name =?,position =?,salary =?,surname =? WHERE id = ?";
    private static final String SHOW_ALL_EMPLOYEE = "SELECT id, dep_id,emp_name,position,salary,surname FROM " +
            "employees ";
    private static final String SHOW_EMPLOYEE_BY_DEPARTMENT =
            "SELECT dep_id,emp_name,position,salary,surname FROM " +
                    "employees WHERE dep_id =? ";
    private static final String CHECK_EMPLOYEE_BY_ID =
            "SELECT id FROM " +
                    "employees WHERE id =? ";

    private EmployeeDAOImpl() {
    }


    public static EmployeeDAOImpl getInstance() {
        synchronized (EmployeeDAOImpl.class) {
            if (instance == null) {
                instance = new EmployeeDAOImpl();
            }
            return instance;
        }
    }

    @Override
    public void create(Employee entity) {
        try (Connection dbConnection = ConnectionManager.get();
             PreparedStatement preparedStatement = dbConnection.prepareStatement(INSERT_EMPLOYEE)) {
            preparedStatement.setInt(1, entity.getDepId());
            preparedStatement.setString(2, entity.getEmpName());
            preparedStatement.setString(3, entity.getPosition());
            preparedStatement.setInt(4, entity.getSalary());
            preparedStatement.setString(5, entity.getSurName());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Employee read(Integer id) {
        Employee employee = new Employee();
        try (Connection dbConnection = ConnectionManager.get();
             PreparedStatement preparedStatement = dbConnection.prepareStatement(READ_EMPLOYEE)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                employee.setId(resultSet.getInt("id"));
                employee.setDepId(resultSet.getInt("dep_id"));
                employee.setEmpName(resultSet.getString("emp_name"));
                employee.setPosition(resultSet.getString("position"));
                employee.setSalary(resultSet.getInt("salary"));
                employee.setSurName(resultSet.getString("surname"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public void delete(Employee entity) {
        try (Connection dbConnection = ConnectionManager.get();
             PreparedStatement preparedStatement = dbConnection.prepareStatement(DELETE_EMPLOYEE)) {
            preparedStatement.setInt(1, entity.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Employee entity) {
        try (Connection dbConnection = ConnectionManager.get();
             PreparedStatement preparedStatement = dbConnection.prepareStatement(UPDATE_EMPLOYEE)) {
            preparedStatement.setInt(1, entity.getDepId());
            preparedStatement.setString(2, entity.getEmpName());
            preparedStatement.setString(3, entity.getPosition());
            preparedStatement.setInt(4, entity.getSalary());
            preparedStatement.setString(5, entity.getSurName());
            preparedStatement.setInt(6, entity.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Employee> readEmployeesByDepartment(Integer depId) {
        List<Employee> allEmployeesByDepartment = new ArrayList<>();
        try (Connection dbConnection = ConnectionManager.get();
             PreparedStatement preparedStatement = dbConnection.prepareStatement(SHOW_EMPLOYEE_BY_DEPARTMENT)) {
            preparedStatement.setInt(1, depId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Employee employee = new Employee();
                employee.setDepId(resultSet.getInt("dep_id"));
                employee.setEmpName(resultSet.getString("emp_name"));
                employee.setPosition(resultSet.getString("position"));
                employee.setSalary(resultSet.getInt("salary"));
                employee.setSurName(resultSet.getString("surname"));
                allEmployeesByDepartment.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allEmployeesByDepartment;
    }

    @Override
    public List<Employee> showAllEmployee() {
        List<Employee> allEmployees = new ArrayList<>();
        try (Connection dbConnection = ConnectionManager.get();
             Statement statement = dbConnection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SHOW_ALL_EMPLOYEE);
            while (resultSet.next()) {
                Employee employee = new Employee();
                employee.setId(resultSet.getInt("id"));
                employee.setDepId(resultSet.getInt("dep_id"));
                employee.setEmpName(resultSet.getString("emp_name"));
                employee.setPosition(resultSet.getString("position"));
                employee.setSalary(resultSet.getInt("salary"));
                employee.setSurName(resultSet.getString("surname"));
                allEmployees.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allEmployees;
    }

    public int checkEmployeeId(int id) {
        int checkedId = 0;
        try (Connection dbConnection = ConnectionManager.get();
             PreparedStatement preparedStatement = dbConnection.prepareStatement(CHECK_EMPLOYEE_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                checkedId = resultSet.getInt("id");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return checkedId;
    }

}
