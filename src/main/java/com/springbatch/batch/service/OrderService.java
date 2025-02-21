package com.springbatch.batch.service;

import com.springbatch.batch.model.Order;
import com.springbatch.batch.model.Product;
import com.springbatch.batch.repository.OrderRepository;
import com.springbatch.batch.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    public OrderService(OrderRepository orderRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    public Long placeOrder(String userName, Long productId) {
        Optional<Product> product = productRepository.findById(productId);

        if (product.isEmpty()) {
            throw new RuntimeException("Product not found");
        }

        Order order = new Order();
        order.setUserName(userName);
        order.setProductName(product.get().getName());

        Order savedOrder = orderRepository.save(order);
        return savedOrder.getId(); // Return generated order ID
    }
}
