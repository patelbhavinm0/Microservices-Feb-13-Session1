package com.example.ProductService.services;

import com.example.ProductService.entities.Product;
import java.util.List;

public interface IProductService {

     List<Product> getAll();

     Product getOne(int id);

     Product add(Product product);

    List<Product> byUserId(int userId);

}
