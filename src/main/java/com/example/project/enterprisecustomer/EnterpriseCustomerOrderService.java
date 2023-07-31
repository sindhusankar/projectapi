package com.example.project.enterprisecustomer;


import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Service
public class EnterpriseCustomerOrderService {
	 private final EnterpriseCustomerOrderRepository orderRepository;

	    @Autowired
	    public EnterpriseCustomerOrderService(EnterpriseCustomerOrderRepository orderRepository) {
	        this.orderRepository = orderRepository;
	    }

	    public EnterpriseCustomerOrder createOrder(EnterpriseCustomerOrder order) {
	        return orderRepository.save(order);
	    }

	    public Optional<EnterpriseCustomerOrder> getOrderById(Long orderId) {
	        return orderRepository.findById(orderId);
	    }

	    public List<EnterpriseCustomerOrder> getCustomerOrders(Long customerId) {
	        return orderRepository.findAllByCustomerId(customerId);
	    }

	    public EnterpriseCustomerOrder updateOrder(EnterpriseCustomerOrder updatedOrder) {
	        return orderRepository.save(updatedOrder);
	    }

	    public void deleteOrder(Long orderId) {
	        orderRepository.deleteById(orderId);
	    }
	}