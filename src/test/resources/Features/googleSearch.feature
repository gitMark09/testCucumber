@GoogleSearch
Feature: feature to test search capability of google

  Scenario Outline: Validate search function is working in google

    Given user has browser open
    And user opens google webpage
    When user enters a search <text> in search box
    And presses Enter
    Then user is navigated to search results

    Examples:
    | text |
    | moose |
    | openheimer |
    | cucumber |