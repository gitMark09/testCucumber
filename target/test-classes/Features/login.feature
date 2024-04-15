@loginTests
Feature: feature to test login functionality

  Scenario Outline: Check login is successful with valid credentials

    Given user already browser open
    And user is on login page
    When user enters <username> and <password>
    And clicks on login button
    Then user is navigated to homepage

    Examples:
    | username | password |
    | standard_user    | secret_sauce    |
    | user2    | pass2    |
