package com.springbatch.batch.config;

import com.springbatch.batch.model.Product;
import com.springbatch.batch.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataSeeder implements CommandLineRunner {
    private final ProductRepository productRepository;

    public DataSeeder(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @Override
    public void run(String... args) {
        if (productRepository.count() == 0) {
            productRepository.saveAll(List.of(
                    new Product("Laptop"),
                    new Product("Mobile"),
                    new Product("Tablet")
            ));
        }
    }

}
