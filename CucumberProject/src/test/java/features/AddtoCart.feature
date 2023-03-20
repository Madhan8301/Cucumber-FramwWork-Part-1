Feature: Search and Place the order
@Test2
Scenario: To Search the Item and add that Item to the cart
	Given User Switch back to the LandingPage
	When User Searched for "beet" in search box
	Then User Added three "Beetroot" to the cart
	Then User Procedd to the checkout page and validate the items "Beetroot"