@UserCatalog
Feature: Catalog API - Manage Products/Plans/Features in the Catalog

  Background:
    Given the following products exist in the catalog:
      | id | name          | description                    | price |
      | 1  | Product A     | This is product A             | 50.00 |
      | 2  | Product B     | This is product B             | 30.00 |

  Scenario: View all products in the catalog
    When the client requests to view all products in the catalog
    Then the response status code should be 200
    And the response body should contain a list of products
    And the response should include the following products:
      | id | name          | description                    | price |
      | 1  | Product A     | This is product A             | 50.00 |
      | 2  | Product B     | This is product B             | 30.00 |

  Scenario: Add a new product to the catalog
    When the client adds a new product to the catalog with the following details:
      | name          | description                    | price |
      | New Product   | This is a new product          | 25.00 |
    Then the response status code should be 201
    And the response body should contain the newly added product details
    And the product should be added to the catalog
    And the catalog should include the following products:
      | id | name          | description                    | price |
      | 1  | Product A     | This is product A             | 50.00 |
      | 2  | Product B     | This is product B             | 30.00 |
      | 3  | New Product   | This is a new product          | 25.00 |

  Scenario: Update an existing product in the catalog
    When the client updates product with ID 2 in the catalog with the following details:
      | name          | description                    | price |
      | Updated Prod  | This is the updated product B   | 35.00 |
    Then the response status code should be 200
    And the response body should contain the updated product details
    And the product with ID 2 should be updated in the catalog
    And the catalog should include the following products:
      | id | name          | description                    | price |
      | 1  | Product A     | This is product A             | 50.00 |
      | 2  | Updated Prod  | This is the updated product B   | 35.00 |

  Scenario: Delete a product from the catalog
    When the client deletes product with ID 1 from the catalog
    Then the response status code should be 204
    And the product with ID 1 should be removed from the catalog
    And the catalog should include the following products:
      | id | name          | description                    | price |
      | 2  | Updated Prod  | This is the updated product B   | 35.00 |
