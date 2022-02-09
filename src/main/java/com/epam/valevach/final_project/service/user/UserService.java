package com.epam.valevach.final_project.service.user;

import com.epam.valevach.final_project.entity.User;
import com.epam.valevach.final_project.service.BaseService;

import java.util.List;
import java.util.Map;

public interface UserService extends BaseService<User> {
    public User find(String login);
    Map<String,String> userInfo();
    List<String> showAllUsers();
    List<User> showAllUsersInfo();
}
