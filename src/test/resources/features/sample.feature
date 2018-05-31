Feature: To cucumber test

  
  Scenario Outline: Test Home Page Cards
    When I open snapdeal website
    And I sign in with "<username>" and "<password>"
    Then I click on active banner link
    And I click on item
    Then I sign out
    Examples:
    | username   | password    |
    | 8379865576 | Ilovemy@106 |
