Feature: Back end - Consult the reservations on the platform

  Background:
    Given "Juan" authenticates with user "admin" and password "password123"

  Scenario: Consult the id of an existing reservation
    When create a reservation request
    And should see in the response the information of the reservation created
    Then consult the information of the created reservation
    And should see in the response the information of the reservation consulted

  Scenario: consult reservations exist
    When create a reservation request
    And should see in the response the information of the reservation created
    Then consult existing reservations on the platform
    And should see that the query returns information

  Scenario: Consult a reservation that does not exist
    When consult the reservation with the id "99999" non-existent
    Then should see the message of error "Not Found"