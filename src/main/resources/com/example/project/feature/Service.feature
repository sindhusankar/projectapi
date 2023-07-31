Feature: Service Provisioning API

  Scenario: Enable wireless service connection
    When the client enables wireless service connection with the following details:
      | connectionId | serviceType  | customerName  | deviceType   | deviceSerial |
      | 12345        | Wireless     | John Doe      | Smartphone   | ABC123       |
    Then the response status code should be 200
    And the response body should contain the connection details
    And the wireless service connection with ID 12345 should be enabled

  Scenario: Test device Quality of Service (QOS)
    When the client tests the device with ID ABC123 for Quality of Service (QOS)
    Then the response status code should be 200
    And the response body should contain the QOS test results for device ID ABC123

  Scenario: Disable a connection
    When the client disables the service connection with ID 12345
    Then the response status code should be 200
    And the response body should contain the disabled connection details
    And the wireless service connection with ID 12345 should be disabled

  Scenario: Hold a connection
    When the client puts the service connection with ID 12345 on hold
    Then the response status code should be 200
    And the response body should contain the connection details in the "on-hold" state
    And the wireless service connection with ID 12345 should be on hold

  Scenario: Resume a connection
    When the client resumes the service connection with ID 12345
    Then the response status code should be 200
    And the response body should contain the resumed connection details
    And the wireless service connection with ID 12345 should be resumed
