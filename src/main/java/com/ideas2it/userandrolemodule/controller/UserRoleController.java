package com.ideas2it.userandrolemodule.controller;

import com.ideas2it.userandrolemodule.entity.UserSchema;
import com.ideas2it.userandrolemodule.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//import javax.validation.Valid;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class UserRoleController {

    @Autowired
    private UserService userService;

    @PostMapping("/users")
    public UserSchema saveUserSchema(
            /*@Valid*/ @RequestBody UserSchema userSchema) {
        return userService.saveUser(userSchema);
    }

    //get userid
    @GetMapping("/users")
    public List<UserSchema> getUserList() {
        return userService.getUserList();
    }

    @GetMapping("/users/{id}")
    @ResponseBody
    public ResponseEntity<UserSchema> getByUserId(@PathVariable("id") String userId) {
        try {
            UserSchema userSchema = userService.getByUserId(userId);
            return new ResponseEntity<>(userSchema, HttpStatus.OK);
        }
        catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Update userid
    @PutMapping("/users/{id}")
    public UserSchema updateUser(@RequestBody UserSchema userSchema,
                     @PathVariable("id") String userId) {
        return userService.updateUser(
                userSchema, userId);
    }

    // Delete user by id
    @DeleteMapping("/users/{id}")
    public String deleteUserById(@PathVariable("id") String userId) {
        userService.deleteUserById(
                userId);
        return "Deleted Successfully";
    }
}
