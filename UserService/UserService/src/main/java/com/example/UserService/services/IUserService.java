package com.example.UserService.services;

import com.example.UserService.entities.User;

import java.util.List;

public interface IUserService {

    List<User> getAll();

    User getOne(int id);

    User add(User user);
}
