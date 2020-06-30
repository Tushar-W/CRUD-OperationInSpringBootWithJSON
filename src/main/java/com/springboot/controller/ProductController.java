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
    public Product getProduct(@PathVariable int id){
        return productService.get(id);
    }

    @PostMapping("/addproduct")
    public String addProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @PutMapping("/updateproduct/{id}")
    public String updateProduct(@PathVariable int id, @RequestBody Product product){
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/deleteproduct/{id}")
    public String deleteProduct(@PathVariable int id){
        return productService.deleteProduct(id);
    }
}
