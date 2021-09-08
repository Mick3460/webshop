package com.example.webshop.controller;

import com.example.webshop.model.Product;
import com.example.webshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    ProductService productService;


    //HOME PAGE
    @GetMapping("/")
    public String index(Model model){

        List<Product> productList = productService.fetchAllProducts();
        model.addAttribute("products",productList);

        return "home/index";
    }

    //INSPECT PRODUCT
    @GetMapping("/inspectProductId={product_id}")
    public String inspectProduct(@PathVariable("product_id") int id, Model model){
        Product product = productService.fetchProductById(id);
        model.addAttribute("product",product);
        return "home/inspectProduct";
    }

    //DELETE PRODUCT
    @GetMapping("/deleteProductId={product_id}")
    public String deleteProduct(@PathVariable("product_id") int id){
        productService.deleteProductbyId(id);

        return "redirect:/";
    }


    //UPDATE BUTTON
    @GetMapping ("/updateProductId={product_id}")
    public String updateProductButton(@PathVariable("product_id") int id, Model model){
        Product product = productService.fetchProductById(id);
        model.addAttribute("product",product);
        return "home/updateProduct";
    }

    //UPDATE PRODUCT
    @PostMapping("/updateProduct")
    public String updateProduct(@ModelAttribute Product product, Model model){
        model.addAttribute("product",product);
        productService.updateProduct(product);
        return "redirect:/";
    }

    //CREATE PRODUCT BUTTON
    @GetMapping("/createProduct")
    public String createProduct(){
        return "home/createProduct";
    }

    //CREATE PRODUCT
    @PostMapping("/createProduct")
    public String createProduct(@ModelAttribute Product product, Model model){
        model.addAttribute("product",product);
        productService.insertProduct(product);
        return "redirect:/";

    }




}
