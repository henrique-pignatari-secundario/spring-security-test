package com.henrique.auth_test.repositories;

import com.henrique.auth_test.domain.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
}
