package com.springbatch.batch.controller;


import com.springbatch.batch.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/place")
    public ResponseEntity<String> placeOrder(
            @RequestParam String userName,
            @RequestParam Long productId
    ){
        Long orderId = orderService.placeOrder(userName, productId);
        return ResponseEntity.ok("Order placed with ID: " + orderId);
    }
}
