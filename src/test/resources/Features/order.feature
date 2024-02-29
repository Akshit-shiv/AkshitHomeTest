#Author:akshit.shiv@gmail.com
#Date:Oct 7,2023
#Description:Scenarios to validate the Demoblaze UI functionalities
Feature: Feature to test order flow

  @e2e2
  Scenario: Add item to Cart
Given I am at the Account/Login page
  When I enter the account username
   And I enter the password
   And I click the login button
  Then I should be at the home page
And I click on phones categories 
 When I add the item to Cart
 Then the item is added to the Cart
