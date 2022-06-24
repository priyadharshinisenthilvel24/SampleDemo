package com.ideas2it.userandrolemodule.service;

import com.ideas2it.userandrolemodule.entity.UserSchema;
import com.ideas2it.userandrolemodule.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Objects;

public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    // Save operation
    @Override
    public UserSchema saveUser(UserSchema userSchema)
    {
        return userRepository.save(userSchema);
    }

    // Read operation
    @Override public List<UserSchema> getUserList()
    {
        return (List<UserSchema>)
                userRepository.findAll();
    }

    // Update operation
    @Override
    public UserSchema updateUser(UserSchema userSchema,
                     String userId)
    {
        UserSchema userDB
                = userRepository.findById(userId)
                .get();

        if (Objects.nonNull(userSchema.getUserName())
                && !"".equalsIgnoreCase(
                userSchema.getUserName())) {
            userDB.setUserName(
                    userSchema.getUserName());
        }

        if (Objects.nonNull(
                userSchema.getUserEmail())
                && !"".equalsIgnoreCase(
                userSchema.getUserEmail())) {
            userDB.setUserEmail(
                    userSchema.getUserEmail());
        }

        if (Objects.nonNull(userSchema.getUserInfo())
                && !"".equalsIgnoreCase(
                userSchema.getUserInfo())) {
            userDB.setUserInfo(
                    userSchema.getUserInfo());
        }

        return userRepository.save(userDB);
    }

    // Delete operation
    @Override
    public void deleteUserById(String userId)
    {
        userRepository.deleteById(userId);
    }
}
