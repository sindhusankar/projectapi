package com.example.project.enterprisecustomer;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class EnterpriseCustomerOrder {
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long orderId;
	    private Long customerId;
	    private String orderDescription;
	    

	    public Long getOrderId() {
	        return orderId;
	    }

	    public void setOrderId(Long orderId) {
	        this.orderId = orderId;
	    }

	    public Long getCustomerId() {
	        return customerId;
	    }

	    public void setCustomerId(Long customerId) {
	        this.customerId = customerId;
	    }

	    public String getOrderDescription() {
	        return orderDescription;
	    }

	    public void setOrderDescription(String orderDescription) {
	        this.orderDescription = orderDescription;
	    }

		/*
		 * public String getAmount() { return Amount; }
		 * 
		 * public void setAmount(String amount) { this.Amount = amount; }
		 */

		
	}



