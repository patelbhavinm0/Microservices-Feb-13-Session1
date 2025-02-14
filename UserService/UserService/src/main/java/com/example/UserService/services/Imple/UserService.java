package com.example.UserService.services.Imple;

import com.example.UserService.entities.Product;
import com.example.UserService.entities.User;
import com.example.UserService.repositories.UserRepository;
import com.example.UserService.services.IProductClient;
import com.example.UserService.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {

   @Autowired
   private UserRepository userRepository;

   @Autowired
   private IProductClient productClient;

    @Override
    public List<User> getAll() {

        List<User> users = this.userRepository.findAll();

//        List<User> newUserList = users.stream().map(user -> {
//                user.setProducts(productClient.byUserId(user.getUserId()));
//                return user;
//        }).collect(Collectors.toList());


        List<User> newUserList = new ArrayList<>();
        for(User user: users)
        {
            int userId = user.getUserId();
            List<Product> pList = productClient.byUserId(userId);
            user.setProducts(pList);
            newUserList.add(user);
        }
        return newUserList;
    }

    @Override
    public User getOne(int id) {
        User user = this.userRepository.findById(id).orElseThrow(()-> new RuntimeException("User not found"));
        user.setProducts(productClient.byUserId(user.getUserId()));
        //return userRepository.findById(id).orElseThrow(() -> new RuntimeException("user not found"));
        return user;
    }

    @Override
    public User add(User user) {
        return this.userRepository.save(user);
    }
}
