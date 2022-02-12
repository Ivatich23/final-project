package com.epam.valevach.final_project.dao.user;

import com.epam.valevach.final_project.dao.ConnectionToMySQL;
import com.epam.valevach.final_project.dao.order.OrderDAOImpl;
import com.epam.valevach.final_project.entity.User;
import com.epam.valevach.final_project.util.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class UserDAOImpl implements UserDAO {
    private static UserDAOImpl instance;

    private static final String INSERT_USER_VALUES = "INSERT INTO " +
            "user (login,password,role) VALUES(?,?,?)";
    private static final String READ_USER_VALUES = "SELECT id,login,password,role FROM " +
            "user WHERE id = ?";
    private static final String READ_USER_VALUES_JOIN_ROLE = "SELECT user.id,login,password,r.role FROM " +
            "user JOIN role r ON (user.role = r.id) ";
    private static final String DELETE_USER_VALUES = "DELETE  FROM " +
            "user WHERE id = ?";
    private static final String UPDATE_USER_VALUES = "UPDATE  " +
            "user SET role=? WHERE id = ?";
    private static final String FIND_USER_VALUES = "SELECT login,password,role.role FROM " +
            "user JOIN role  ON (user.role = role.id) WHERE login = ?";
    private static final String SHOW_ALL_USERS = "SELECT login,role FROM " +
            "user ";
    private static final String SHOW_ALL_USERS_INFO = "SELECT id, login,password,role FROM " +
            "user ";

    private UserDAOImpl() {
    }

    public static UserDAOImpl getInstance() {
        synchronized (UserDAOImpl.class) {
            if (instance == null) {
                instance = new UserDAOImpl();
            }
            return instance;
        }
    }

    @Override
    public void create(User entity) {
        try (Connection dbConnection = ConnectionManager.get();
             PreparedStatement preparedStatement = dbConnection.prepareStatement(INSERT_USER_VALUES)) {
            preparedStatement.setString(1, entity.getLogin());
            preparedStatement.setString(2, entity.getPassword());
            preparedStatement.setInt(3, entity.getRole());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User read(Integer id) {
        User user = new User();
        try (Connection dbConnection = ConnectionManager.get();
             PreparedStatement preparedStatement = dbConnection.prepareStatement(READ_USER_VALUES)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                user.setId(resultSet.getInt("id"));
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
                user.setRole(resultSet.getInt("role"));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return user;
    }

    @Override
    public void delete(User entity) {
        try (Connection dbConnection = ConnectionManager.get();
             PreparedStatement preparedStatement = dbConnection.prepareStatement(DELETE_USER_VALUES)) {
            preparedStatement.setInt(1, entity.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public void update(User entity) {
        try (Connection dbConnection = ConnectionManager.get();
             PreparedStatement preparedStatement = dbConnection.prepareStatement(UPDATE_USER_VALUES)) {
            preparedStatement.setInt(1, entity.getRole());
            preparedStatement.setInt(2, entity.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User find(String login) {
        User user = new User();
        try (Connection dbConnection = ConnectionManager.get();
             PreparedStatement preparedStatement = dbConnection.prepareStatement(FIND_USER_VALUES)) {
            preparedStatement.setString(1, login);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
                user.setUserRole(resultSet.getString("role.role"));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return user;
    }

    @Override
    public Map<String, String> userInfo() {
        Map<String, String> allUsersInfo = new HashMap<>();
        try (Connection dbConnection = ConnectionManager.get();
             PreparedStatement preparedStatement = dbConnection.prepareStatement(SHOW_ALL_USERS_INFO)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                allUsersInfo.
                        put(resultSet.
                                getString("login"), resultSet.getString("password"));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return allUsersInfo;
    }

    @Override
    public List<String> showAllUsers() {
        List<String> allUsersLogin = new ArrayList<>();
        try (Connection dbConnection = ConnectionManager.get();
             PreparedStatement preparedStatement = dbConnection.prepareStatement(SHOW_ALL_USERS)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String userLogin = resultSet.getString("login");
                allUsersLogin.add(userLogin);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return allUsersLogin;
    }

    @Override
    public List<User> showAllUsersInfo() {
        List<User> allUsersLogin = new ArrayList<>();
        try (Connection dbConnection = ConnectionManager.get();
             PreparedStatement preparedStatement = dbConnection.prepareStatement(READ_USER_VALUES_JOIN_ROLE)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setLogin(resultSet.getString("login"));
                user.setUserRole(resultSet.getString("r.role"));
                allUsersLogin.add(user);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return allUsersLogin;
    }
}
