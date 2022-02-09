package com.epam.valevach.final_project.dao.user;

import com.epam.valevach.final_project.dao.BaseDAO;
import com.epam.valevach.final_project.entity.User;

import java.util.List;
import java.util.Map;

public interface UserDAO extends BaseDAO<User> {
     User find(String login);
     Map<String,String> userInfo();
     List<String> showAllUsers();
     List<User> showAllUsersInfo();
}
