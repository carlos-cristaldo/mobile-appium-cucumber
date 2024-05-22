Feature: K12 App

  Scenario Outline: Successful Login
    Given "<user>" is selected
    And user is in landing page
    When user click on login button
    And user enters valid credentials
    And user clicks on login session button
    Then user accesses to dashboard page

    Examples:
      | user  |
      | user1 |


  Scenario: Verify Marketing intro
    Given user is in landing page
    When click on right arrow
    Then the carrousel is working


  Scenario Outline: Crash when tap on back
    Given "<user>" is selected
    When user goes to dashboard page
    And user taps on comunity button
    And user clicks on hivebrite button
    Examples:
      | user  |
      | user1 |

