Feature: K12 App

  Scenario Outline: Successful Login
    Given "<user>" is selected
    And user is on the landing page
    When user enters valid credentials
    Then user is in Dashboard Page
    Examples:
      | user  |
      | user1 |

  Scenario Outline: Crash when tap on back
    Given "<user>" is selected
    When user goes to dashboard page
    And user taps on comunity button
    And user clicks on hivebrite button
    Examples:
      | user  |
      | user1 |