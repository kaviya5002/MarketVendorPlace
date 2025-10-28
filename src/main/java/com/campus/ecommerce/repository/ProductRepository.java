package com.campus.ecommerce.repository;

import com.campus.ecommerce.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findByVendorId(int vendorId);
}
