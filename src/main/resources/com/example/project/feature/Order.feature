Feature: Ordering API for Consumer Customer

  Background:
    Given the consumer customer with ID 123 exists
    And the following orders exist for customer ID 123:
      | orderId | orderNumber | amount |
      | 1       | ORD-001     | 100.50 |
      | 2       | ORD-002     | 75.25  |

  Scenario: Create a new order for a consumer customer
    When the client creates a new order for customer ID 123 with the following details:
      | orderNumber | amount |
      | ORD-003     | 50.00  |
    Then the response status code should be 201
    And the response body should contain the newly created order details
    And the order should be added to the list of orders for customer ID 123
    And the list of orders for customer ID 123 should include the following orders:
      | orderId | orderNumber | amount |
      | 1       | ORD-001     | 100.50 |
      | 2       | ORD-002     | 75.25  |
      | 3       | ORD-003     | 50.00  |

  Scenario: Update an existing order for a consumer customer
    When the client updates the order with ID 2 for customer ID 123 with the following details:
      | orderNumber | amount |
      | ORD-002-X   | 80.00  |
    Then the response status code should be 200
    And the response body should contain the updated order details
    And the order with ID 2 should be updated in the list of orders for customer ID 123
    And the list of orders for customer ID 123 should include the following orders:
      | orderId | orderNumber | amount |
      | 1       | ORD-001     | 100.50 |
      | 2       | ORD-002-X   | 80.00  |
      | 3       | ORD-003     | 50.00  |

  Scenario: Get all orders for a consumer customer
    When the client retrieves all orders for customer ID 123
    Then the response status code should be 200
    And the response body should contain a list of orders
    And the list of orders should include the following orders for customer ID 123:
      | orderId | orderNumber | amount |
      | 1       | ORD-001     | 100.50 |
      | 2       | ORD-002-X   | 80.00  |
      | 3       | ORD-003     | 50.00  |

  Scenario: Get a specific order for a consumer customer
    When the client retrieves the order with ID 2 for customer ID 123
    Then the response status code should be 200
    And the response body should contain the order details for order ID 2

  Scenario: Get the status of an order for a consumer customer
    When the client retrieves the status of the order with ID 2 for customer ID 123
    Then the response status code should be 200
    And the response body should contain the status of the order for order ID 2
