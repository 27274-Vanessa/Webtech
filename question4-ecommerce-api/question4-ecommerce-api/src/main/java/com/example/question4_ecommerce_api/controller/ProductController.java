package com.example.question4_ecommerce_api.controller;

import com.example.question4_ecommerce_api.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private List<Product> products = new ArrayList<>();

    public ProductController() {
        products.add(new Product(1L, "Laptop", "Gaming laptop", 1200.0, "Electronics", 5, "Dell"));
        products.add(new Product(2L, "Phone", "Smartphone", 800.0, "Electronics", 10, "Samsung"));
        products.add(new Product(3L, "Headphones", "Noise cancelling", 150.0, "Accessories", 0, "Sony"));
        products.add(new Product(4L, "TV", "4K Smart TV", 1000.0, "Electronics", 3, "LG"));
        products.add(new Product(5L, "Shoes", "Running shoes", 120.0, "Fashion", 20, "Nike"));
        products.add(new Product(6L, "Watch", "Smart watch", 250.0, "Accessories", 7, "Apple"));
        products.add(new Product(7L, "Keyboard", "Mechanical keyboard", 90.0, "Accessories", 15, "Logitech"));
        products.add(new Product(8L, "Mouse", "Wireless mouse", 50.0, "Accessories", 0, "Logitech"));
        products.add(new Product(9L, "Jacket", "Winter jacket", 200.0, "Fashion", 4, "Adidas"));
        products.add(new Product(10L, "Tablet", "Android tablet", 400.0, "Electronics", 6, "Samsung"));
    }

    @GetMapping
    public List<Product> getAllProducts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int limit) {

        int start = page * limit;
        int end = Math.min(start + limit, products.size());

        if (start > products.size()) {
            return new ArrayList<>();
        }
        return products.subList(start, end);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable Long productId) {
        return products.stream()
                .filter(p -> p.getProductId().equals(productId))
                .findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/category/{category}")
    public List<Product> getByCategory(@PathVariable String category) {
        return products.stream()
                .filter(p -> p.getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toList());
    }

    @GetMapping("/brand/{brand}")
    public List<Product> getByBrand(@PathVariable String brand) {
        return products.stream()
                .filter(p -> p.getBrand().equalsIgnoreCase(brand))
                .collect(Collectors.toList());
    }

    @GetMapping("/search")
    public List<Product> searchProducts(@RequestParam String keyword) {
        return products.stream()
                .filter(p -> p.getName().toLowerCase().contains(keyword.toLowerCase())
                        || p.getDescription().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
    }

    @GetMapping("/price-range")
    public List<Product> getByPriceRange(@RequestParam double min, @RequestParam double max) {
        return products.stream()
                .filter(p -> p.getPrice() >= min && p.getPrice() <= max)
                .collect(Collectors.toList());
    }

    @GetMapping("/in-stock")
    public List<Product> getInStockProducts() {
        return products.stream()
                .filter(p -> p.getStockQuantity() > 0)
                .collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        products.add(product);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    @PutMapping("/{productId}")
    public ResponseEntity<Product> updateProduct(
            @PathVariable Long productId,
            @RequestBody Product updatedProduct) {

        for (Product p : products) {
            if (p.getProductId().equals(productId)) {
                p.setName(updatedProduct.getName());
                p.setDescription(updatedProduct.getDescription());
                p.setPrice(updatedProduct.getPrice());
                p.setCategory(updatedProduct.getCategory());
                p.setBrand(updatedProduct.getBrand());
                p.setStockQuantity(updatedProduct.getStockQuantity());
                return ResponseEntity.ok(p);
            }
        }
        return ResponseEntity.notFound().build();
    }

    @PatchMapping("/{productId}/stock")
    public ResponseEntity<Product> updateStock(
            @PathVariable Long productId,
            @RequestParam int quantity) {

        for (Product p : products) {
            if (p.getProductId().equals(productId)) {
                p.setStockQuantity(quantity);
                return ResponseEntity.ok(p);
            }
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long productId) {
        products.removeIf(p -> p.getProductId().equals(productId));
        return ResponseEntity.ok("Product deleted");
    }
}
