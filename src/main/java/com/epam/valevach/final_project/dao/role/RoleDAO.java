package com.epam.valevach.final_project.dao.role;

import com.epam.valevach.final_project.dao.BaseDAO;
import com.epam.valevach.final_project.entity.Role;

public interface RoleDAO extends BaseDAO<Role> {
Role findRole(String role);
}
