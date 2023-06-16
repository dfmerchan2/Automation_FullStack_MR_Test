Feature: Back end - Create reservation on the platform

  Background:
    Given "Juan" authenticates with user "admin" and password "password123"

  Scenario: Create a successful booking
    When create a reservation request
    Then should see in the response the information of the reservation created
