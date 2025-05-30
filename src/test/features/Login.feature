@login
  Feature: The current script is used to test the base automation system

    Background:
      Given I am at the main site

    @template
    Scenario: Test login
      Given I type "admin" on "username" input
      Then  I type "admin" on "password" input
      And   I click on "submit" button
