package com.example.ProductService.services.Impl;

import com.example.ProductService.entities.Product;
import com.example.ProductService.repositories.ProductRepository;
import com.example.ProductService.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    public ProductRepository productRepository;

    public ProductService(ProductRepository productRepository)
    {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAll() {
        return this.productRepository.findAll();
    }

    @Override
    public Product getOne(int id) {
        return this.productRepository.findById(id).orElseThrow(() -> new RuntimeException("do not found product"));
    }

    @Override
    public Product add(Product product) {
        return this.productRepository.save(product);
    }

    @Override
    public List<Product> byUserId(int userId) {
        List<Product> pList =  this.productRepository.findByUserId(userId);
        return pList;
//        return this.productRepository.findAll();
    }

}
