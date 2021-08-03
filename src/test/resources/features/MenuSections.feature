Feature: As a user I want to get ability to use menu sections

  Scenario Outline: Tools sections should contain appropriate columns
    Given the user opens Cucumber website
    When the user clicks on the 'Tools' section
    And the user clicks on the '<title>' item
    Then page with title '<title>' is displayed
    Examples:
      | title         |
      | Cucumber Open |
      | Contribute    |
      | Sponsors      |