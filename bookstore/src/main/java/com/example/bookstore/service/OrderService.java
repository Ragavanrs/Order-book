package com.example.bookstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.bookstore.entity.Order;
import com.example.bookstore.entity.User;
import com.example.bookstore.entity.Book;
import com.example.bookstore.repository.OrderRepository;
import com.example.bookstore.repository.UserRepository;
import com.example.bookstore.repository.BookRepository;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookRepository bookRepository;

    public Order placeOrder(Long userId, List<Long> bookIds,double totalCost) throws Exception {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new Exception("User not found"));
        
        List<Book> books = bookRepository.findAllById(bookIds);
        if (books.isEmpty()) {
            throw new Exception("No books found for the given IDs");
        }
        
        Order order = new Order();
        order.setUser(user);
        order.setBooks(books);
        
        //double totalCost = totalCost;
        order.setTotalCost(totalCost);
        
        return orderRepository.save(order);
    }
    
    public List<Order> getOrdersByUserId(Long userId) {
        return orderRepository.findByUserId(userId);
    }
}
