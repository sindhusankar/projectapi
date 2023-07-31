package com.example.project.order;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service

public class OrderService {
	 private final OrderRepository orderrepository;
	 private List<Orders> orders = new ArrayList<>();
		@Autowired
		public OrderService(OrderRepository _orderrepository) {

			this.orderrepository = _orderrepository;
			orders.addAll(orderrepository.findAll());
		}
		

	    public List<Orders> getOrdersByCustomerId(Long customerId) {
	        // Return a list of orders associated with the given customerId
	        return orders.stream()
	                .filter(order -> order.getCustomerId().equals(customerId))
	                .collect(Collectors.toList());
	    }

	    public Orders getOrderById(Long orderId) {
	        // Return the order with the given orderId, or null if not found
	        return orders.stream()
	                .filter(order -> order.getOrderId().equals(orderId))
	                .findFirst()
	                .orElse(null);
	    }

	    public Orders createOrder(Orders order) {
	        // Generate a unique orderId and add the order to the list
	    	// Long newOrderId = generateNewOrderId();
	    	//order.setOrderId(newOrderId);
	    	orderrepository.save(order);	        
	    	orders.add(order);
	        return order;
	    }
	    public String getOrderStatus(Long orderId) {
	        // Find the order with the specified orderId
	        Orders order = orders.stream()
	                .filter(o -> o.getOrderId().equals(orderId))
	                .findFirst()
	                .orElse(null);

	        // If the order is found, return its status; otherwise, return null or an error message
	        return (order != null) ? order.getStatus() : null;
	    }
	    public boolean updateOrder(Long customerId, Long orderId, Orders updatedOrder) {
	        // Find the order with the specified customerId and orderId
	        Orders orderToUpdate = orders.stream()
	                .filter(o -> o.getCustomerId().equals(customerId) && o.getOrderId().equals(orderId))
	                .findFirst()
	                .orElse(null);

	        // If the order is found, update its properties with the new values
	        if (orderToUpdate != null) {
	            orderToUpdate.setOrderDescription(updatedOrder.getOrderDescription());
	            orderToUpdate.setStatus(updatedOrder.getStatus());
	            orderrepository.save(orderToUpdate);
	            // Update other fields as needed
	            return true;
	        } else {
	            return false; // Order not found
	        }
	    }

//	    private Long generateNewOrderId() {
//	        // Generate a new unique orderId (You can use UUID or any other method)
//	        return System.currentTimeMillis();
//	    }
	}