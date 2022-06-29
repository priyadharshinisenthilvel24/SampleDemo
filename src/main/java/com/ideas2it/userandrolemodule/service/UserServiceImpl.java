package com.ideas2it.userandrolemodule.service;

import com.ideas2it.userandrolemodule.entity.UserSchema;
import com.ideas2it.userandrolemodule.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
//@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    // Save operation
    @Override
    public UserSchema saveUser(UserSchema userSchema) {
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
