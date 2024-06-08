Feature: K12 App

  #SMOKE

  Scenario: Verify video exists and can be played
    Given user is in who we are page
    And video is present
    And video can be played

  Scenario: Verify carrousel
    Given user is in who we are page
    When click on right arrow
    Then user is in what we offer page


  Scenario Outline: Successful Login as LC
    Given "<user>" is selected
    When  login as an LC
    Then user is redirected to dashboard page
    And user is logged out of the app

    Examples:
      | user  |
      | lcprod |

  Scenario Outline: Successful Login as LG
    Given "<user>" is selected
    When login as an LG
    Then user is redirected to dashboard page
    And user is logged out of the app

    Examples:
      | user  |
      | lgprod |

  Scenario: LG create account
    When navigate to login page
    And click sign up link
    And select LG Role
    And and click on create account button
    And completes the registration process







  Scenario Outline: New PP Login as LG
    Given "<user>" is selected
    When login as an LG
    Then user is redirected to dashboard page

    Examples:
      | user  |
      | user4 |

  Scenario: New PP from carrousel
    When going to How to Start Page
    And click on ready for inscription button
    And click on back button in new PP Page

  Scenario Outline: New PP Login as LC
    Given "<user>" is selected
    When login as an LC
    And user is redirected to dashboard page
    And click on re-reg button
    Then parent portal page is open
    When click on back button in new PP Page
    And user is redirected to dashboard page
    When click on enrollment button


    Examples:
      | user  |
      | user5 |




  Scenario: Verify information icon
    Given user is in who we are page
    When click on information icon
    Then sign up or sign in can be performed

  Scenario: Verify School finder
    Given user in in Find Your School Page


