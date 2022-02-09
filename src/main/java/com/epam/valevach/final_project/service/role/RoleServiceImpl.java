package com.epam.valevach.final_project.service.role;

import com.epam.valevach.final_project.dao.role.RoleDAOImpl;
import com.epam.valevach.final_project.entity.Role;
import com.epam.valevach.final_project.service.order.OrderServiceImpl;

public class RoleServiceImpl implements RoleService {
    RoleDAOImpl roleDAO = RoleDAOImpl.getInstance();
    private static RoleServiceImpl instance;
    private RoleServiceImpl(){}
    public static RoleServiceImpl getInstance(){
        synchronized (RoleServiceImpl.class) {
            if (instance == null) {
                instance = new RoleServiceImpl();
            }
        }
        return instance;
    }

    @Override
    public void create(Role entity) {
        roleDAO.create(entity);
    }

    @Override
    public Role read(Integer id) {
        return roleDAO.read(id);
    }

    @Override
    public void delete(Role entity) {
        roleDAO.delete(entity);
    }

    @Override
    public void update(Role entity) {
        roleDAO.update(entity);
    }

    @Override
    public Role findRole(String role) {
        return roleDAO.findRole(role);
    }
}
