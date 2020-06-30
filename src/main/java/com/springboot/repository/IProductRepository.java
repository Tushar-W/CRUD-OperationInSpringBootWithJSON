package com.springboot.repository;

import com.springboot.model.Product;
import java.util.List;

public interface IProductRepository {

    List<Product> getAllProducts();

    Product findProductById(int id);

    String saveProduct(Product product);

    String updateProduct(int id, Product product);

    String deleteProduct(int id);
}
