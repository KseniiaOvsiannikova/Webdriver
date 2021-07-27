Feature: As a user I want to get ability to use menu sections

  Scenario: Docs sections should contain appropriate columns
    Given the user opens Cucumber website
    When the user clicks on the "Docs" section
    And the user clicks on the "Gherkin Syntax" item
    Then page with title "Gherkin Syntax" is displayed