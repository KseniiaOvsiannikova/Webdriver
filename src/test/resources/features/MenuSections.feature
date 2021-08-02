Feature: As a user I want to get ability to use menu sections

  Scenario: Docs sections should contain appropriate columns
    Given the user opens Cucumber website
    When the user clicks on the "Tools" section
    And the user clicks on the "Cucumber Open" item
    Then page with title "Cucumber Open" is displayed