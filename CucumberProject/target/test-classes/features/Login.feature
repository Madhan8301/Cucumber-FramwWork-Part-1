
Feature: Search order
  @Test1
  Scenario Outline: To search and extract Product name in both orderspage and offerspage 
    Given User is no Landing page
    When User searched for a product <Name> and extracted the name
    Then User searched <Name> in the offer page and extraced the name
    Then validate the name in productPage and offersPage matches
    
Examples:
| Name |
| Tom  |
| Beet |
| Bri  |
