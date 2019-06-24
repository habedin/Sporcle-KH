Feature: Kingdom Hearts Series Characters Quiz 

Scenario Outline: Successfully take this quiz through automation 

	Given I open "<browser>" and navigate to Sporcle website 
	When I enter search term and click on the characters quiz 
	And I enter the characters from my test data 
	Then I will finish the quiz and the browser will close
	
	
	Examples: 
		|browser|
		|chrome|
		|firefox|