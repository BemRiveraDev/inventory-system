package com.bem.inventory_system.service;

import com.bem.inventory_system.entity.Product;
import com.bem.inventory_system.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor

public class ProductService {
    
    private final ProductRepository productRepository;

    public Product addProduct(Product product) {
        if (productRepository.existsBySku(product.getSku())) {
            throw new RuntimeException("SKU already exists: " + product.getSku());
        }
        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found: " + id));
    }

    public List<Product> getLowStock(int threshold) {
        return productRepository.findByQuantityLessThanEqual(threshold);
    }
    
}
