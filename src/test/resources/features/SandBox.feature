
  Feature: Test different actions on a sandbox page.
    Scenario: Test different actions on a sandbox page.
      Given I am on the sandbox page
      And Select a value from the dropdown

  @Test
  Scenario: As a Test Engineer, I want to retrieve a value of an dinamic table
    Given I Navigate to the dinamic table
    And I can return the value I wanted
    And Return other value that I want to proove
    Then I can validate the table is displayed