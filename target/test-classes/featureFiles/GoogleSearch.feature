Feature: Search something on google

  @googleSearch
  Scenario Outline: Successful search on google
    Given the user has launched the browser
    When the user searches "<searchInput>"
    Then the user should see results page

    Examples:
    |searchInput|
    |REPL       |