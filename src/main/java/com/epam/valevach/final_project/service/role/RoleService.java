package com.epam.valevach.final_project.service.role;

import com.epam.valevach.final_project.entity.Role;
import com.epam.valevach.final_project.service.BaseService;

public interface RoleService extends BaseService<Role> {
    Role findRole(String role);
}
