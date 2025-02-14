package com.example.ProductService.controllers;

import com.example.ProductService.entities.Product;
import com.example.ProductService.services.Impl.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private ProductService productService;
    public ProductController(@Autowired ProductService productService)
    {
        this.productService = productService;
    }

    @GetMapping("/all")
    public List<Product> getAll()
    {
        return  this.productService.getAll();
    }

    @GetMapping("/{id}")
    public Product getOne(@PathVariable int id)
    {
       return this.productService.getOne(id);
    }

    @PostMapping("/add")
    public Product add(@RequestBody Product product)
    {
        return this.productService.add(product);
    }

    @GetMapping("/byUserId/{userId}")
    public List<Product> byUserId(@PathVariable int userId)
    {
        List<Product> pList = this.productService.byUserId(userId);
        return pList;
    }
}
