package com.springboot.controller;

import com.springboot.model.Product;
import com.springboot.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/welcome")
    public String welcomeMessage(){
        return "Welcome to spring boot";
    }

    @GetMapping("/getallproducts")
    public List<Product> getAllProducts(){
        return productService.listAll();
    }

    @GetMapping("/getproduct/{id}")
    public Product get(@PathVariable Integer id){
        return productService.get(id);
    }

    @PostMapping("/addproduct")
    public void addProduct(@RequestBody Product product) {
        productService.saveProduct(product);
    }
}
