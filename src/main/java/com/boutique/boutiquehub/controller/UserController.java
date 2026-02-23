package com.boutique.boutiquehub.controller;

import com.boutique.boutiquehub.entity.User;
import com.boutique.boutiquehub.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public User addUser(@RequestBody User user){
        return  userService.addUser(user);
    }
    @GetMapping("/{id}")
    public User getUserById(@PathVariable long id){
        return userService.getUserById(id);
    }
    @GetMapping("/email/{email}")
    public User getUserByEmail(@PathVariable String email){
        return userService.getUserByEmail(email);
    }
    @GetMapping
    public List<User> getAllUser(){
        return userService.getAllUser();
    }
    @PutMapping("/{id}")
    public User updateUser(@PathVariable long id,@RequestBody User user){
        return userService.updateUser(id,user);
    }
    @DeleteMapping("/{id}")
    public String deleteUserById(@PathVariable long id){
        userService.deleteUserById(id);
        return "Deleted successfully";
    }


}
