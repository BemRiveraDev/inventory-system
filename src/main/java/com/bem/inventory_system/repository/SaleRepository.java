package com.bem.inventory_system.repository;

import com.bem.inventory_system.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SaleRepository extends JpaRepository<Sale, Long> {

    List<Sale> findByProductId(Long productId);
    
}
