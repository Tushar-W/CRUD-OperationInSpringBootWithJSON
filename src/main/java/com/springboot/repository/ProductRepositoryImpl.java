package com.springboot.repository;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.model.Product;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.List;

@Repository
public class ProductRepositoryImpl implements IProductRepository{
    private List<Product> productList;
    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public List<Product> getAllProducts() {
        try {
            InputStream inputStream = new FileInputStream(new File("./src/main/resources/product.json"));
            TypeReference<List<Product>> typeReference = new TypeReference<List<Product>>() {};
            productList = objectMapper.readValue(inputStream, typeReference);
            return productList;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Product findProductById(Integer id) {
        productList = getAllProducts();
        for (Product product: productList) {
            if (product.getId()==id){
                return product;
            }
        }
        return null;
    }

    @Override
    public void saveProduct(Product product) {
        try {
            productList.add(product);
            objectMapper.writeValue(new File("./src/main/resources/product.json"), productList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateProduct(Integer id, Product product) {
        try {
            Product product1 = findProductById(id);
            product1.setName(product.getName()== null ? product1.getName() : product.getName());
            product1.setPrice(product.getPrice()== 0 ? product1.getPrice() : product.getPrice());
            productList.add(product1);
            objectMapper.writeValue(new File("./src/main/resources/product.json"), productList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
