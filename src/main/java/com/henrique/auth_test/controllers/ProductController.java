package com.henrique.auth_test.controllers;

import com.henrique.auth_test.domain.product.Product;
import com.henrique.auth_test.domain.product.ProductRequestDTO;
import com.henrique.auth_test.domain.product.ProductResponseDTO;
import com.henrique.auth_test.repositories.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("product")
public class ProductController {
    @Autowired
    ProductRepository productRepository;

    @PostMapping
    public ResponseEntity postProduct(@RequestBody @Valid ProductRequestDTO body){
        Product newProduct = new Product(body);

        this.productRepository.save(newProduct);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity getAllProducts(){
        List<ProductResponseDTO> productList = this.productRepository.findAll()
                .stream()
                .map(ProductResponseDTO::new)
                .toList();

        return ResponseEntity.ok(productList);
    }

}
