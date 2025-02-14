package com.example.UserService.controllers;

import com.example.UserService.entities.User;
import com.example.UserService.services.Imple.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/all")
    public List<User> getAll()
    {
        return this.userService.getAll();
    }

    @GetMapping("/{id}")
    public User getOne(@PathVariable int id)
    {
        return this.userService.getOne(id);
    }

    @PostMapping("/add")
    public User add(@RequestBody User user)
    {
        return this.userService.add(user);
    }
}
