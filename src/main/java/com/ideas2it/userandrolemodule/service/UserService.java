package com.ideas2it.userandrolemodule.service;

import com.ideas2it.userandrolemodule.entity.UserSchema;
import java.util.List;

public interface UserService {
    // Save operation
    UserSchema saveUser(UserSchema userSchema);

    // Read operation
    List<UserSchema> getUserList();

    UserSchema getByUserId(String userId);

    // Update operation
    UserSchema updateUser(UserSchema userSchema,
                                String userId);

    // Delete operation
    void deleteUserById(String userId);
}
