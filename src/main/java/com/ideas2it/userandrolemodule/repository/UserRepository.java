package com.ideas2it.userandrolemodule.repository;

import com.ideas2it.userandrolemodule.entity.UserSchema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserSchema, String>{
}
