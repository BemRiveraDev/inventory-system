# Inventory Management System

A RESTful inventory management API built with Spring Boot, designed for warehouses and retail environments. Tracks products, stock levels, and sales with transactional integrity. 

## Features

- **Product Management** - Full CRUD with SKU uniqueness and field validation.

- **Sales Recording** - Atomic transactions: stock decrement and sale record saved together, with automatic rollback on failure.

- **Low-Stock Alerts** - Query products below any quantity threshold.

- **Clean Error Handling** - Structured JSON error responses for invalid requests.

- **Demo-Ready Seed Data** - Pre-loaded inventory on startup

## Tech Stack

| Layer | Technology |
|-------|------------|
| Framework | Spring Boot 3.5 |
| Language | Java 17 |
| Database | H2 (in-memory , auto-configured) |
| ORM | Spring Data JPA / Hibernate |
| Build Tool | Maven |
| Validation | Jakarta Bean Validation |

## Getting Started

### Prerequisites

- Java 17+

- Maven (or use the included Maven wrapper)

### Run the Application

```bash 
./mvnw spring-boot:run
```

- The server starts on localhost:8080

- Seed data is loaded automatically - no setup required 

## API Endpoints 

### Products

|Method  | Endpoint  | Description  |
|--------|-----------|--------------|
| POST   | /api/products | Add a new product |
| GET    | /api/products | List all products |
| GET    | /api/products/{id} | Get product by ID |
| GET    | /api/products/low-stock?threshold=5 | Find products below threshold |

### Sales

|Method  | Endpoint  | Description  |
|--------|-----------|--------------|
| POST   | /api/sales| Record a sale (decrements stock) |

### Health

|Method  | Endpoint  | Description  |
|--------|-----------|--------------|
| GET    | /actuator/health | Application health check |

## Example Requests

### Add a Product
```bash
curl -X POST http://localhost:8080/api/products \
  -H "Content-Type: application/json" \
  -d '{"name":"Scanner","sku":"SCN-001","quantity":50,"price":9.99,"category":"Electronics"}
```

### Record a Sale
```bash
curl -X POST http://localhost:8080/api/sales \
  -H "Content-Type: application/json" \
  -d '{"productId":1,"quantitySold":5}'
```

### Check Low Stock
```bash
curl "http://localhost:8080/api/products/low-stock?threshold=10"
```
- Import the curl commands above into Postman or use the terminal directly.

## Transactional Integrity

The POST /api/sales endpoint is annotated with @Transactional. If a sale would exceed available stock, the operation rolls back completely - no partial updates, no phantom inventory changes.

## Project Structure
```
src/main/java/com/bem/inventory_system/
├── InventorySystemApplication.java
├── entity/
│   ├── Product.java
│   └── Sale.java
├── repository/
│   ├── ProductRepository.java
│   └── SaleRepository.java
├── service/
│   ├── ProductService.java
│   └── SaleService.java
├── controller/
│   ├── ProductController.java
│   └── SaleController.java
└── exception/
    └── GlobalExceptionHandler.java
```
