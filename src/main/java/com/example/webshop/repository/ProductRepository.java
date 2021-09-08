package com.example.webshop.repository;

import com.example.webshop.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository {
    @Autowired
    JdbcTemplate jdbc;


    public List<Product> fetchAllProducts(){
        return jdbc.query("SELECT * FROM products", new BeanPropertyRowMapper<>(Product.class));
    }

    public Product fetchProductById(int id){
        String sql = "SELECT * FROM products WHERE product_id = ?";
        RowMapper<Product> productRowMapper = new BeanPropertyRowMapper<>(Product.class);
        Product productReturn = jdbc.queryForObject(sql,productRowMapper,id);
        return productReturn;
    }

    public void insertProduct(Product product){
        String insertStr = "INSERT INTO products (name,price) VALUES ('"+product.getName()+"', "+product.getPrice()+")";
        jdbc.update(insertStr);
        
    }

    public Product updateProduct (Product product){

        String updateStr = "UPDATE products SET"+
                " name = '"+product.getName()+"',"+
                " price = '"+product.getPrice()+"'"+
                " WHERE product_id = "+product.getProduct_id();
        jdbc.update(updateStr);
        return product;
    }

    public void deleteProductById(int id){
        String deleteStr = "DELETE FROM products WHERE product_id = "+id;
        jdbc.update(deleteStr);
    }



}
