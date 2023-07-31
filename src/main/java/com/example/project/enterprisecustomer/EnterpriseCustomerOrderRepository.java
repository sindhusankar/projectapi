package com.example.project.enterprisecustomer;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface EnterpriseCustomerOrderRepository  extends JpaRepository<EnterpriseCustomerOrder,Long> {
	List<EnterpriseCustomerOrder> findAllByCustomerId(Long customerId);
	}

