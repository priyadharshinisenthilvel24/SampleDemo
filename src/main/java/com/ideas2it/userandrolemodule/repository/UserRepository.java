package com.ideas2it.userandrolemodule.repository;

import com.ideas2it.userandrolemodule.entity.UserSchema;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
//@Profile("test")
public interface UserRepository extends JpaRepository<UserSchema, Long>{
}
