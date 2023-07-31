Feature: Orders for Enterprise Customers API

  Scenario: Create an order for an enterprise customer
    Given the customer with ID 123 exists
    When the client creates an order for customer ID 123 with the following details:
      | orderNumber | amount |
      | ORD-001     | 100.50 |
    Then the response status code should be 201
    And the response body should contain the order details

  Scenario: Update an order for an enterprise customer
    Given the customer with ID 123 exists
    And the order with ID 456 exists for customer ID 123
    When the client updates the order with ID 456 for customer ID 123 with the following details:
      | orderNumber | amount |
      | ORD-002     | 150.75 |
    Then the response status code should be 200
    And the response body should contain the updated order details

  Scenario: Get all orders for an enterprise customer
    Given the customer with ID 123 exists
    And the customer has the following orders:
      | orderNumber | amount |
      | ORD-001     | 100.50 |
      | ORD-002     | 150.75 |
    When the client retrieves all orders for customer ID 123
    Then the response status code should be 200
    And the response body should contain all the customer's orders

  Scenario: Get a specific order for an enterprise customer
    Given the customer with ID 123 exists
    And the order with ID 456 exists for customer ID 123
    When the client retrieves the order with ID 456 for customer ID 123
    Then the response status code should be 200
    And the response body should contain the order details

  Scenario: Delete an order for an enterprise customer
    Given the customer with ID 123 exists
    And the order with ID 456 exists for customer ID 123
    When the client deletes the order with ID 456 for customer ID 123
    Then the response status code should be 204
    And the order with ID 456 should be removed from the system
