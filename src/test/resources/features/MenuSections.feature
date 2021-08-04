Feature: As a user I want to get ability to use menu sections

  Background:
    Given The user opens Cucumber website

  Scenario Outline: Tools sections should contain appropriate columns
    When the user clicks on the 'Tools' section
    And the user clicks on the '<title>' item
    Then page with title '<title>' is displayed

    Examples:
      | title         |
      | Cucumber Open |
      | Contribute    |
      | Sponsors      |