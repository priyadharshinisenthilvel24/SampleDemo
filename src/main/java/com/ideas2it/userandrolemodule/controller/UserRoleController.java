package com.ideas2it.userandrolemodule.controller;

import com.ideas2it.userandrolemodule.entity.UserSchema;
import com.ideas2it.userandrolemodule.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
//import javax.validation.Valid;

import java.util.List;

@RestController
public class UserRoleController {

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public UserSchema saveUserSchema(
            /*@Valid*/ @RequestBody UserSchema userSchema) {
        return userService.saveUser(userSchema);
    }

    //get userid
    @GetMapping("/user")
    public List<UserSchema> getUserList() {
        return userService.getUserList();
    }

    /*@GetMapping("/user/{id}")
    public List<UserSchema> getByUserId() {
        return userService.getByUserId();
    }*/

    // Update userid
    @PutMapping("/user/{id}")
    public UserSchema updateUser(@RequestBody UserSchema userSchema,
                     @PathVariable("id") String userId) {
        return userService.updateUser(
                userSchema, userId);
    }

    // Delete user by id
    @DeleteMapping("/user/{id}")
    public String deleteUserById(@PathVariable("id")
                                       String userId) {
        userService.deleteUserById(
                userId);
        return "Deleted Successfully";
    }
}
