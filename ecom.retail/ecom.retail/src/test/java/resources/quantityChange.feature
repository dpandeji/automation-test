Feature: change qty in basket
  As an End user
  I want to search product and add in basket
  So that i can buy and change quantity

  Background:
    Given I am on homepage
    When I search for product "nike"
    Then I should be able to see "Nike" product

    Given I am on result page of "nike" product
    When I click on "Nike" product
    And I see "Nike" product description
    And I click on "add to Trolley"
    Then I should able to see "Nike" product in my trolley

    Scenario: change qty for single selected item
      Given I am on trolley page
      When I select qty of "4" or more
      Then I should be able to see price for "4"
