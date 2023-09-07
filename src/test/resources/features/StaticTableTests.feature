
Feature: Test different actions on the Static Table Page.

  Rule: The user can return values from the table and validate them

  Background: Navigate to Table web app
    Given I Navigate to the dinamic table

  Scenario: As a Test Engineer, I want to retrieve a value of an dinamic table
    Then I can return the value I wanted

    Scenario: As a Test Engineer, I want to validate the static table is displayed
      Then I can validate the table is displayed


