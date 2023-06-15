Feature: Mathematical operations in the Windows calculator
  I as a user
  I want to open the calculator
  To perform basic operations

  Scenario: Successful "Sum" Operation
    Given that "Diego" opens the calculator application
    When he performs the "sum" operation with the values "20" and "5"
    Then he should observe the result equal to "25"

  Scenario: Successful "Subtraction" Operation
    Given that "Diego" opens the calculator application
    When he performs the "subtraction" operation with the values "10" and "6"
    Then he should observe the result equal to "4"

  Scenario: Successful "Multiplication" Operation
    Given that "Diego" opens the calculator application
    When he performs the "multiplication" operation with the values "10" and "6"
    Then he should observe the result equal to "60"

  Scenario: Successful "Division" Operation
    Given that "Diego" opens the calculator application
    When he performs the "Division" operation with the values "100" and "5"
    Then he should observe the result equal to "20"