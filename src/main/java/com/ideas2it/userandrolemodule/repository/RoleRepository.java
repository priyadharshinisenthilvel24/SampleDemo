package com.ideas2it.userandrolemodule.repository;

import com.ideas2it.userandrolemodule.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
}
