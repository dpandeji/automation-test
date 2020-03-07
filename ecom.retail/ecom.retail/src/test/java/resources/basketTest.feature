Feature: add product to basket and verify the item added
  As an End user
  I want to search product in basket
  So that i can buy

  Background:
    Given I am on homepage
    When I search for product "nike"
    Then I should be able to see "Nike" product

    Scenario: single Product added in basket
    Given I am on result page of "nike" product
      When I click on "Nike" product
      And I see "Nike" product description
      And I click on "add to Trolley"
      And I select qty of "4" or more.
      Then I should able to see "Nike" product in my trolley
