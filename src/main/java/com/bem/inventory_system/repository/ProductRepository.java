package com.bem.inventory_system.repository;

import com.bem.inventory_system.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long >{

    Optional<Product> findBySku(String sku);

    List<Product> findByQuantityLessThanEqual(int threshold);

    List<Product> findByCategory(String category);

    boolean existsBySku(String sku);
    
}
