Feature: Back end - End-to-end testing of platform services

  Background:
    Given "Juan" authenticates with user "admin" and password "password123"

  Scenario: End-to-end booking
    Given create a reservation request
    And should see in the response the information of the reservation created
    When consult the information of the created reservation
    And should see in the response the information of the reservation consulted
    Then delete a booking created
    And should see the response "Created" when deleting the user
    And should see the message "Created" generated by the ping