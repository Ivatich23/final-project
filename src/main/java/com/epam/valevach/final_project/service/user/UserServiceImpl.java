package com.epam.valevach.final_project.service.user;

import com.epam.valevach.final_project.dao.user.UserDAOImpl;
import com.epam.valevach.final_project.entity.User;
import com.epam.valevach.final_project.service.order.OrderServiceImpl;

import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {
    UserDAOImpl userDAO = UserDAOImpl.getInstance();
    private static UserServiceImpl instance;
    private UserServiceImpl(){}
    public static UserServiceImpl getInstance(){
        synchronized (UserServiceImpl.class) {
            if (instance == null) {
                instance = new UserServiceImpl();
            }
        }
        return instance;
    }
    @Override
    public void create(User entity) {
        userDAO.create(entity);
    }

    @Override
    public User read(Integer id) {
        return userDAO.read(id);
    }

    @Override
    public void delete(User entity) {
        userDAO.delete(entity);
    }

    @Override
    public void update(User entity) {
        userDAO.update(entity);
    }

    @Override
    public User find(String login) {
      return   userDAO.find(login);
    }

    @Override
    public Map<String,String> userInfo() {
        return userDAO.userInfo();
    }

    @Override
    public List<String> showAllUsers() {
        return userDAO.showAllUsers();
    }

    @Override
    public List<User> showAllUsersInfo() {
        return userDAO.showAllUsersInfo();
    }
}
