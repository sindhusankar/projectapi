Feature: Orders for Enterprise Customers API

  Scenario: Create a new order for an enterprise customer
    Given the enterprise customer with ID 123 exists
    When the client creates a new order for customer ID 123 with the following details:
      | orderId | orderNumber | amount |
      | 1       | ORD-001     | 100.50 |
    Then the response status code should be 201
    And the response body should contain the newly created order details
    And the order should be added to the list of orders for customer ID 123
    And the list of orders for customer ID 123 should include the following orders:
      | orderId | orderNumber | amount |
      | 1       | ORD-001     | 100.50 |

  Scenario: Update an existing order for an enterprise customer
    Given the enterprise customer with ID 123 exists
    And the order with ID 1 exists for customer ID 123
    When the client updates the order with ID 1 for customer ID 123 with the following details:
      | orderNumber | amount |
      | ORD-001-X   | 150.75 |
    Then the response status code should be 200
    And the response body should contain the updated order details
    And the order with ID 1 should be updated in the list of orders for customer ID 123
    And the list of orders for customer ID 123 should include the following orders:
      | orderId | orderNumber | amount |
      | 1       | ORD-001-X   | 150.75 |

  Scenario: Get all orders for an enterprise customer
    Given the enterprise customer with ID 123 exists
    And the following orders exist for customer ID 123:
      | orderId | orderNumber | amount |
      | 1       | ORD-001-X   | 150.75 |
      | 2       | ORD-002     | 75.25  |
    When the client retrieves all orders for customer ID 123
    Then the response status code should be 200
    And the response body should contain a list of orders
    And the list of orders should include the following orders for customer ID 123:
      | orderId | orderNumber | amount |
      | 1       | ORD-001-X   | 150.75 |
      | 2       | ORD-002     | 75.25  |

  Scenario: Get a specific order for an enterprise customer
    Given the enterprise customer with ID 123 exists
    And the order with ID 1 exists for customer ID 123
    When the client retrieves the order with ID 1 for customer ID 123
    Then the response status code should be 200
    And the response body should contain the order details for order ID 1

  Scenario: Get a specific order by order ID
    When the client retrieves the order with ID 2
    Then the response status code should be 200
    And the response body should contain the order details for order ID 2
