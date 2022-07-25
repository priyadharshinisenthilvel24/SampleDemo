package com.ideas2it.userandrolemodule.service;

import com.ideas2it.userandrolemodule.entity.Role;
import com.ideas2it.userandrolemodule.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
//@Transactional
public class RoleServiceImpl implements RoleService{

    @Autowired
    private RoleRepository roleRepository;

    // Save operation
    @Override
    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }

    /**
     * @return
     */
    @Override
    public List<Role> getRoleList() {
        return (List<Role>) roleRepository.findAll();
    }

    /**
     * @param roleId
     * @return
     */
    @Override
    public Role getByRoleId(Long roleId) {
        Optional<Role> role = Optional.of(roleRepository.findById(roleId)
                .get());
        return role.get();
    }

    /**
     * @param role
     * @param roleId
     * @return
     */
    @Override
    public Role updateRole(Role role, Long roleId) {
        Role roleDB
                = roleRepository.findById(roleId)
                .get();

        if (Objects.nonNull(role.getRole())
                && !"".equalsIgnoreCase(role.getRole())){
            roleDB.setRole(role.getRole());
        }

        return roleRepository.save(roleDB);
    }

    /**
     * @param roleId
     */
    @Override
    public void deleteRoleById(Long roleId) {
        roleRepository.deleteById(roleId);

    }

}
