package com.springboot.services;

import com.springboot.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private IProductRepository productRepository;

}
