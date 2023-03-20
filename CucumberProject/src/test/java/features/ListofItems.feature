Feature: Place more than one Order
@Test3
Scenario: To Place More than one Items and verify it in the CheckoutPage

	Given User Navigated to landing Page
	When User adds the List of Item to the cart
	Then User Click on CartPage and Proceed to CheckoutPage
	And User validates the Item in the CheckoutPage
	

 