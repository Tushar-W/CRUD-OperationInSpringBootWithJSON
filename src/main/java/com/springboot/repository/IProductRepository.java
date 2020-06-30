package com.springboot.repository;

import com.springboot.model.Product;
import java.util.List;

public interface IProductRepository {

    List<Product> getAllProducts();

    Product findProductById(Integer id);

    void saveProduct(Product product);

    void updateProduct(Integer id, Product product);
}
