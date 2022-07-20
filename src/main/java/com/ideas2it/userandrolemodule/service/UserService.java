package com.ideas2it.userandrolemodule.service;

import com.ideas2it.userandrolemodule.entity.UserSchema;
import com.ideas2it.userandrolemodule.model.UserWithRole;

import java.util.List;

public interface UserService {
    // Save operation
    UserSchema saveUser(UserSchema userSchema);

    // Read operation
    List<UserSchema> getUserList();

    UserSchema getByUserId(Long userId);

    // Update operation
    UserSchema updateUser(UserSchema userSchema,
                                Long userId);

    // Delete operation
    void deleteUserById(Long userId);

    //save user with Role
    //UserWithRole saveUserwithRole(UserWithRole userWithRole);
}
