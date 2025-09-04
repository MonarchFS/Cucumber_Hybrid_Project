Feature: Search functionality

Scenario: User searches for a valid product
Given User is in store page
When User enters valid product "HP" into search box field
And User clicks on search button
Then User should get valid proiduct displayed in search result

Scenario: User searches for invalid product
Given User is in store page
When User enters invalid product "Honda" into search box field
And User clicks on search button
Then User should get a message about no product matching

Scenario: User searches without entering any product
Given User is in store page
When User do not enter any product name in the search box field
And User clicks on search button
Then User should get a message about no product matching
