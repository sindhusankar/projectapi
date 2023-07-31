package com.example.project.enterprisecustomer;

import java.util.List;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*import com.example.project.order.OrderService;
import com.example.project.order.Orders;*/

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/enterprise")
public class EnterpriseCustomerOrderController {
	 private final EnterpriseCustomerOrderService orderService;

	    @Autowired
	    public EnterpriseCustomerOrderController(EnterpriseCustomerOrderService orderService) {
	        this.orderService = orderService;
	    }

	    @PostMapping("/customers/{customerId}/orders")
	    public ResponseEntity<EnterpriseCustomerOrder> createOrder(@PathVariable Long customerId, @RequestBody EnterpriseCustomerOrder order) {
	        order.setCustomerId(customerId);
	        EnterpriseCustomerOrder createdOrder = orderService.createOrder(order);
	        return new ResponseEntity<>(createdOrder, HttpStatus.CREATED);
	    }

	    @GetMapping("/customers/{customerId}/orders")
	    public ResponseEntity<List<EnterpriseCustomerOrder>> getCustomerOrders(@PathVariable Long customerId) {
	        List<EnterpriseCustomerOrder> orders = orderService.getCustomerOrders(customerId);
	        return new ResponseEntity<>(orders, HttpStatus.OK);
	    }

	    @GetMapping("/orders/{orderId}")
	    public ResponseEntity<EnterpriseCustomerOrder> getOrderById(@PathVariable Long orderId) {
	        java.util.Optional<EnterpriseCustomerOrder> order = orderService.getOrderById(orderId);
	        return order.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
	                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	    }

	    @PutMapping("/customers/{customerId}/orders/{orderId}")
	    public ResponseEntity<EnterpriseCustomerOrder> updateOrder(@PathVariable Long customerId, @PathVariable Long orderId, @RequestBody EnterpriseCustomerOrder updatedOrder) {
	    	java.util.Optional<EnterpriseCustomerOrder> existingOrder = orderService.getOrderById(orderId);
	        if (existingOrder.isPresent()) {
	            EnterpriseCustomerOrder orderToUpdate = existingOrder.get();
	            orderToUpdate.setOrderDescription(updatedOrder.getOrderDescription());
	           
	            // Set other fields to be updated as needed
	            EnterpriseCustomerOrder savedOrder = orderService.updateOrder(orderToUpdate);
	            return new ResponseEntity<>(savedOrder, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }

//	    @DeleteMapping("/{customerId}/orders/{orderId}")
//	    public ResponseEntity<Void> deleteOrder(@PathVariable Long customerId, @PathVariable Long orderId) {
//	    	java.util.Optional<EnterpriseCustomerOrder> existingOrder = orderService.getOrderById(orderId);
//	        if (existingOrder.isPresent()) {
//	            orderService.deleteOrder(orderId);
//	            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//	        } else {
//	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//	        }
//	    }
	}