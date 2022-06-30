package com.ideas2it.userandrolemodule.controller;

import com.ideas2it.userandrolemodule.entity.Role;
import com.ideas2it.userandrolemodule.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping("/role")
    public Role saveRole(
            /*@Valid*/ @RequestBody Role role) {
        return roleService.saveRole(role);
    }

    //get userid
    @GetMapping("/role")
    public List<Role> getUserList() {
        return roleService.getRoleList();
    }

    @GetMapping("/role/{id}")
    @ResponseBody
    public ResponseEntity<Role> getByRoleId(@PathVariable("id") Long roleId) {
        try {
            Role role = roleService.getByRoleId(roleId);
            return new ResponseEntity<>(role, HttpStatus.OK);
        }
        catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Update userid
    @PutMapping("/role/{id}")
    public Role updateUser(@RequestBody Role role,
                     @PathVariable("id") Long roleId) {
        return roleService.updateRole(role, roleId);
    }

    //Patch update
    @PatchMapping("/role/{id}")
    public Role patchUser(@RequestBody Role role,
                                 @PathVariable("id") Long roleId) {
        return roleService.updateRole(role, roleId);
    }

    // Delete user by id
    @DeleteMapping("/role/{id}")
    public String deleteRoleById(@PathVariable("id") Long roleId) {
        roleService.deleteRoleById(roleId);
        return "Deleted Successfully";
    }
}
