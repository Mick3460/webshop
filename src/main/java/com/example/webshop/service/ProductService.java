package com.example.webshop.service;

import com.example.webshop.model.Product;
import com.example.webshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public List<Product> fetchAllProducts(){ return productRepository.fetchAllProducts();}

    public Product fetchProductById(int id){ return productRepository.fetchProductById(id);}

    public void insertProduct(Product product){ productRepository.insertProduct(product);}

    public Product updateProduct(Product product){
        return productRepository.updateProduct(product);
    }

    public void deleteProductbyId(int id){ productRepository.deleteProductById(id);}

}
