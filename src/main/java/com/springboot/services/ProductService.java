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
        return productRepository.getAllProducts();
    }

    public Product get(Integer id){
        return productRepository.findProductById(id);
    }

    public String saveProduct(Product product){
        return productRepository.saveProduct(product);
    }

    public String updateProduct(Integer id, Product product) {
        return productRepository.updateProduct(id, product);
    }

    public String deleteProduct(int id) {
        return productRepository.deleteProduct(id);
    }
}
