Feature: Login functionality

  Scenario: Valid login

    Given user is on the login page
    When user logs in with valid credentials
    Then user should be navigated to the secure area
  
  
  # scenario = one specific test case under the feature
  # can have multiple scenario if needed