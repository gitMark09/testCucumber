# NOTE ON TAGS: tags are inherited downwards.
# For example below, @loginTests and @normalPath are also tags of Scenario Outline and Scenario: Tags Sample 1, etc...
# Another example below, @loginSteps is also the tag of Examples

@loginTests @normalPath
Feature: feature to test login functionality
  @loginSteps
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

    @Tag1
    Scenario: Tags Sample 1
      Given
      When
      Then

    @Tag2
    Scenario: Tags Sample 2
    Given
    When
    Then

