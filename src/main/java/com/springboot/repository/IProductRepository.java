package com.springboot.repository;

import com.springboot.model.Product;
import java.util.List;

public interface IProductRepository {

    List<Product> findAllProduct();
}
