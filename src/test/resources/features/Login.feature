Feature: Login Funtionality

  Scenario: Login with valid credentials
    Given User navigates to login page
    When User enters valid email "solo12@gmail.com" into email field
    And User enters valid password "admin123" into password field
    And User clicks on login button
    Then User should get succeffully logged in

  Scenario: Login with invalid credentials
    Given User navigates to login page
    When User enters invalid email into email field
    And User enters invalid password "scedi123" into password field
    And User clicks on login button
    Then User should get Invalid credentials message

  Scenario: Login without providing any credentials
    Given User navigates to login page
    When User dont enter any email in email field
    And User dont enter any password in password field
    And User clicks on login button
    Then User should get an required message in credentials field
