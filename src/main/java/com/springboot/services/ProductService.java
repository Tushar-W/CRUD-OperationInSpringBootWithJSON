package com.springboot.services;

import com.springboot.model.Product;
import com.springboot.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private IProductRepository productRepository;

    public List<Product> listAll() {
        return productRepository.findAllProduct();
    }

}
