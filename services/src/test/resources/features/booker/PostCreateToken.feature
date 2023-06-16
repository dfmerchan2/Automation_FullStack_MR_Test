Feature: Back end - Creation of token for authentication

  Scenario: Create token with successful credentials
    When "Juan" authenticates with user "admin" and password "password123"
    Then should see the token generated successfully

  Scenario Outline: Create token with incorrect credentials
    When "Juan" authenticates with user "<user>" and password "<password>"
    Then should see the error message "Bad credentials"
    Examples:
      | user           | password          |
      | adminIncorrect | password123       |
      | admin          | passwordIncorrect |