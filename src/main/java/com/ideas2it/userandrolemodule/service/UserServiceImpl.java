package com.ideas2it.userandrolemodule.service;

import com.ideas2it.userandrolemodule.exception.GlobalExceptionHandler;
import com.ideas2it.userandrolemodule.entity.UserSchema;
import com.ideas2it.userandrolemodule.model.UserWithRole;
import com.ideas2it.userandrolemodule.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
//@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    GlobalExceptionHandler globalExceptionHandler;

    //save user with role
    public UserSchema saveUserwithRole(UserSchema userSchema) {
        //Long roleid = userSchema.getUserId();
        //Role role = userRepository.findRole(roleid.intValue());
        //userSchema.setRole(role);
        UserWithRole userWithRole = new UserWithRole();
        return userRepository.save(userSchema);
    }

    // Save operation
    @Override
    public UserSchema saveUser(UserSchema userSchema) {

        try{
            if(userSchema == null
                    || userSchema.getUserName() == null
                    || userSchema.getUserName().equals("")) {
                //globalExceptionHandler.invalidField();
                throw new NullPointerException();
            }
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException(e);
        }
        return userRepository.save(userSchema);


    }

    // Read operation
    @Override
    public List<UserSchema> getUserList() {

        return (List<UserSchema>) userRepository.findAll();
    }

    /**
     * @param userId
     * @return Userschema
     * @description get user data for the particular userid
     */
    @Override
    public UserSchema getByUserId(Long userId) {
        Optional<UserSchema> user = Optional.of(userRepository.findById(userId)
                .get());
        return user.get();
    }

    // Update operation
    @Override
    public UserSchema updateUser(UserSchema userSchema,
                     Long userId) {
        UserSchema userDB
                = userRepository.findById(userId)
                .get();

        if (Objects.nonNull(userSchema.getUserName())
                && !"".equalsIgnoreCase(userSchema.getUserName())) {
            userDB.setUserName(userSchema.getUserName());
        }

        if (Objects.nonNull(userSchema.getUserEmail())
                && !"".equalsIgnoreCase(userSchema.getUserEmail())) {
            userDB.setUserEmail(userSchema.getUserEmail());
        }

        if (Objects.nonNull(userSchema.getUserInfo())
                && !"".equalsIgnoreCase(userSchema.getUserInfo())) {
            userDB.setUserInfo(userSchema.getUserInfo());
        }

        return userRepository.save(userDB);
    }

    // Delete operation
    @Override
    public void deleteUserById(Long userId) {
        userRepository.deleteById(userId);
    }
}
