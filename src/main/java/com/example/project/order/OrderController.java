package com.example.project.order;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/consumer")
public class OrderController {

	@Autowired
    private OrderService orderService;

    @GetMapping("/customers/{customerId}/orders")
    //@CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<List<Orders>> getOrdersByCustomerId(@PathVariable Long customerId) {
        List<Orders> orders = orderService.getOrdersByCustomerId(customerId);
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/orders/{orderId}")
    public ResponseEntity<Orders> getOrderById(@PathVariable Long orderId) {
        Orders order = orderService.getOrderById(orderId);
        if (order == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(order);
    }

    @PostMapping("/customers/{customerId}/orders")
    public ResponseEntity<Orders> createOrder(@PathVariable Long customerId, @RequestBody Orders order) {
        if (!order.getCustomerId().equals(customerId)) {
            return ResponseEntity.badRequest().build();
        }
        Orders createdOrder = orderService.createOrder(order);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdOrder);
    }

    @PutMapping("/customers/{customerId}/orders/{orderId}")
    //@CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<String> updateOrder(
            @PathVariable Long customerId,
            @PathVariable Long orderId,
            @RequestBody Orders updatedOrder) {
        boolean updated = orderService.updateOrder(customerId, orderId, updatedOrder);
        if (updated) {
            return ResponseEntity.ok("Order updated successfully.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/orders/status/{orderId}")
    public ResponseEntity<String> getOrderStatus(@PathVariable Long orderId) {
        String status = orderService.getOrderStatus(orderId);
        if (status != null) {
            return ResponseEntity.ok(status);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}