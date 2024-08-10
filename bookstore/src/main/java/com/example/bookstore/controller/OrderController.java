package com.example.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.bookstore.entity.Order;
import com.example.bookstore.service.OrderService;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping
    public Order placeOrder(
    	    @RequestParam("userId") Long userId,
    	    @RequestBody List<Long> bookIds,
    	    @RequestParam("totalCost") double totalCost) {
        try {
            return orderService.placeOrder(userId, bookIds,totalCost);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    
    @GetMapping("/user/{userId}")
    public List<Order> getOrdersByUserId(@PathVariable("userId") Long userId) {
        return orderService.getOrdersByUserId(userId);
    }
}
