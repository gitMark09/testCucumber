@HomepageTests
Feature: Feature to test logout link and inventory item displayed with COMMON STEPS in the BACKGROUND

  Background: user has browser open
    Given user is on login webpage
    When valid username and password is entered by user
    Then user is taken to the homepage


  Scenario: check valid login credentials
    When user clicks burger icon
    Then logout link is displayed

  Scenario Outline: check inventory displayed
    When user enters homepage
    Then item <itemName> is in inventory

    Examples:
      |itemName|
      |Sauce Labs Backpack|
      |Ube                |

