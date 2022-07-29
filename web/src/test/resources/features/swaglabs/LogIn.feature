#Author: Diego Fernando Merchan Jimenez

Feature: Login to the SauceDemo page
  As a user of the platform
  I want to authenticate
  To make a purchase

  Scenario: Successful login
    Given 'juan' go to the SauceDemo page
    When he enter username 'standard_user' and password 'secret_sauce'
    Then he should see the title of 'Products'

  Scenario Outline: Login with wrong credentials
    Given 'juan' go to the SauceDemo page
    When he enter username '<user>' and password '<password>'
    Then he should see the alert with the message '<message>'
    Examples:
      | user          | password        | message                                                                   |
      | standard_user | InvalidPassword | Epic sadface: Username and password do not match any user in this service |
#      | InvalidUser   | secret_sauce    | Epic sadface: Username and password do not match any user in this service |
#      |               | secret_sauce    | Epic sadface: Username is required                                        |
#      | standard_user |                 | Epic sadface: Password is required                                        |