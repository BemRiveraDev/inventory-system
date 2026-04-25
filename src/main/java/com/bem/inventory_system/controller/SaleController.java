package com.bem.inventory_system.controller;

import com.bem.inventory_system.entity.Sale;
import com.bem.inventory_system.service.SaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/sales")
@RequiredArgsConstructor
public class SaleController {

    private final SaleService saleService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Sale recordSale(@RequestBody Map<String, Object> request) {
        Long productId = ((Number) request.get("productId")).longValue();
        int quantitySold = ((Number) request.get("quantitySold")).intValue();
        return saleService.recordSale(productId, quantitySold);
    }
}
