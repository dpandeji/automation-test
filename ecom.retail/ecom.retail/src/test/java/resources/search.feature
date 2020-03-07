@search
Feature: Search
  As an end user
  I want to search for product
  So that i can view product i wish

  @smoke
  Scenario: Search for single product
    Given I am on homepage
    When I search for product "nike"
    Then I should be able to see "Nike" product

  @regression
  Scenario Outline: Search multi product
    Given I am on homepage
    When I search for product "<searchItem>"
    Then I should be able to see "<resultItem>" product

    Examples:
      | searchItem |resultItem|
      | Puma       |Puma      |
      | adidas     | Adidas   |