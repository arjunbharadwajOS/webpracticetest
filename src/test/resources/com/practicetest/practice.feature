Feature: Amazon website search feature
  Amazon website search with search and filters

  Background:
    Given User is on AmazonAU page "https://www.amazon.com.au/"


  Scenario Outline: Verify Search and Apply Filters Amazon AU website
    Given I search for "<searchText>"
    When I select filters on the lefthand panel "<brand>" and "<screensize>" and "<resolution1>" and "<resolution2>"
    Then I verify the search results are displayed and sorted by price
    Examples:
      | searchText | brand | screensize   | resolution1 | resolution2 |
      | LG TV       | LG    | Up to 32 in | 4k          | 1080p       |
