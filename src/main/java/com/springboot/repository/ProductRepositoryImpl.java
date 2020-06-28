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
    private List<Product> productList = null;

    @Override
    public List<Product> findAllProduct() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            InputStream inputStream = new FileInputStream(new File("./src/main/resources/product.json"));
            TypeReference<List<Product>> typeReference = new TypeReference<List<Product>>() {};
            return productList=objectMapper.readValue(inputStream, typeReference);
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
}
