package com.ideas2it.userandrolemodule.service;

import com.ideas2it.userandrolemodule.entity.Role;

import java.util.List;

public interface RoleService {

    // Create operation
    Role saveRole(Role role);

    // Read operation
    List<Role> getRoleList();

    Role getByRoleId(Long roleId);

    // Update operation
    Role updateRole(Role role,Long roleId);

    // Delete operation
    void deleteRoleById(Long roleId);
}
