Feature: Registration functionality

  Scenario: User creates an account only with mandatory fields
    Given User navigates to Register Account page
    When User enters the below fields
      | firstname | Donald             |
      | lastname  | Trump              |
      | email     | donald44@gmail.com |
      | telephone |         2145784578 |
      | password  | donald10           |
    And User selects privacy policy checkbox
    And User clicks on continue button
    Then User account should get created successfully

  Scenario: User creates an account only with all fields
    Given User navigates to Register Account page
    When User enters the below fields
      | firstname | Donald             |
      | lastname  | Trump              |
      | email     | donald541@gmail.com |
      | telephone |         2145784578 |
      | password  | donald10           |
    And User selects Yes for Newsletter
    And User selects privacy policy checkbox
    And User clicks on continue button
    Then User account should get created successfully

  Scenario: User creates a duplicate account
    Given User navigates to Register Account page
    When User enters the below fields with duplicate email
      | firstname | Donald             |
      | lastname  | Trump              |
      | email     | donald313@gmail.com |
      | telephone |          123456789 |
      | password  | donald10           |
    And User selects Yes for Newsletter
    And User selects privacy policy checkbox
    And User clicks on continue button
    Then User get a proper warning about exisiting email

  Scenario: User creates an account without filling any details
    Given User navigates to Register Account page
    When User do not enter any credentials
    And User clicks on continue button
    Then User should get proper warning messages for every mandatory field
