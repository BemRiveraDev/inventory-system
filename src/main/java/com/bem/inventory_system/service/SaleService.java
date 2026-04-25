package com.bem.inventory_system.service;

import com.bem.inventory_system.entity.Product;
import com.bem.inventory_system.entity.Sale;
import com.bem.inventory_system.repository.ProductRepository;
import com.bem.inventory_system.repository.SaleRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SaleService {

    private final ProductRepository productRepository;
    private final SaleRepository saleRepository;

    @Transactional
    public Sale recordSale(Long productId, int quantitySold) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found: " + productId));

        if (product.getQuantity() < quantitySold) {
            throw new RuntimeException("Insufficient stock. Available: " + product.getQuantity());
        }

        product.setQuantity(product.getQuantity() - quantitySold);
        productRepository.save(product);

        Sale sale = Sale.builder()
                .product(product)
                .quantitySold(quantitySold)
                .salePrice(product.getPrice())
                .build();

        return saleRepository.save(sale);
    }

    public List<Sale> getSalesByProduct(Long productId) {
        return saleRepository.findByProductId(productId);
    }
}
