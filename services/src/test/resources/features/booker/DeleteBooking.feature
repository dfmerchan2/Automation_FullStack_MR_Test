Feature: Back end - Delete reservation on the platform

  Background:
    Given "Juan" authenticates with user "admin" and password "password123"

  Scenario: Delete an existing reservation
    When create a reservation request
    #And should see in the response the information of the reservation created
    #Then delete a booking created
    #And should see the response "Created" when deleting the user

  #Scenario: Delete a non-existent reservation
   # Then delete the reservation with the id "99999" non-existent
    #And should see the response "Method Not Allowed" when deleting the user