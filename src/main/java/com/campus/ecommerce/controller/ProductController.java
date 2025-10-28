package com.campus.ecommerce.controller;

import com.campus.ecommerce.Product;
import com.campus.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "*")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    // Add a new product
    @PostMapping("/add")
    public Product addProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    // Get all products
    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Get products by vendorId
    @GetMapping("/vendor/{vendorId}")
    public List<Product> getProductsByVendor(@PathVariable int vendorId) {
        return productRepository.findByVendorId(vendorId);
    }
}
