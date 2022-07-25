package com.ideas2it.userandrolemodule.service;

import com.ideas2it.userandrolemodule.entity.UserSchema;
import com.ideas2it.userandrolemodule.exception.CustomException;
import com.ideas2it.userandrolemodule.exception.GlobalExceptionHandler;
import com.ideas2it.userandrolemodule.exception.ValidateRequest;
import com.ideas2it.userandrolemodule.model.ErrorResponse;
import com.ideas2it.userandrolemodule.model.UserWithRole;
import com.ideas2it.userandrolemodule.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
//@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    GlobalExceptionHandler globalExceptionHandler;

    @Autowired
    ValidateRequest validateRequest;

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
            if(userSchema != null){
                if(userSchema.getName() == null){
                    validateRequest.userNameNotFound();
                }
                if(userSchema.getName().equals("")){
                    validateRequest.invalidUserName();
                }
                if(userSchema.getRole()== null){
                    validateRequest.roleNotfound();
                }
                if(userSchema.getRole()!=null
                        && !Arrays.asList("Admin","Common").contains(userSchema.getRole().getRole())){
                    validateRequest.invalidRole();
                }
            }
        }catch (IllegalArgumentException e) {
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

        if (Objects.nonNull(userSchema.getName())
                && !"".equalsIgnoreCase(userSchema.getName())) {
            userDB.setName(userSchema.getName());
        }

        if (Objects.nonNull(userSchema.getEmail())
                && !"".equalsIgnoreCase(userSchema.getEmail())) {
            userDB.setEmail(userSchema.getEmail());
        }

        return userRepository.save(userDB);
    }

    // Delete operation
    @Override
    public void deleteUserById(Long userId) {
        UserSchema user = this.getByUserId(userId);
        if(user!= null)
            userRepository.deleteById(userId);
    }
}
