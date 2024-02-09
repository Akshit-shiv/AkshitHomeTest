#Author:akshit.shiv@gmail.com
#Date:Oct 7,2023
#Description:Scenarios to validate the Demoblaze UI functionalities
Feature: Feature to test Login and add to cart Functionalities
          As a customer
  In order to use the application
  I want to login with email and password and check if item can be added to cart

  @e2e
  Scenario: Logging in with valid credentials
 Given I am at the Account/Login page
  When I enter the account username
   And I enter the password
   And I click the login button
  Then I should be at the home page
  
  #@e2e
  #Scenario: Add item to Cart
 #Given I click on phones categories 
  #When I add the item to Cart
  #Then the item is added to the Cart
