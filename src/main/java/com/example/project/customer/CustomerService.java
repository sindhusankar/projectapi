package com.example.project.customer;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
 public class CustomerService {
	public class CustomerNotFoundException extends RuntimeException {

	    public CustomerNotFoundException(String message) {
	        super(message);
	    }
	}


private final CustomerRepository customerRepository;

@Autowired
public CustomerService(CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
}

public Customer createCustomer(Customer customer) {
    return customerRepository.save(customer);
}

public Customer updateCustomer(Long customerId, Customer updatedCustomer) {
    Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
    if (optionalCustomer.isPresent()) {
        Customer customer = optionalCustomer.get();
        customer.setName(updatedCustomer.getName());
        customer.setEmail(updatedCustomer.getEmail());
        customer.setDiscount(updatedCustomer.getDiscount());
        return customerRepository.save(customer);
    } else {
        throw new CustomerNotFoundException("Customer not found with ID: " + customerId);
    }
}

public List<Customer> getAllCustomers() {
    return customerRepository.findAll();
}

public Customer getCustomerById(Long customerId) {
    return customerRepository.findById(customerId)
            .orElseThrow(() -> new CustomerNotFoundException("Customer not found with ID: " + customerId));
}
}