Feature: Searching amazon for particular model from the result set and extracting the details

Scenario: Amazon search with scenario
Given user launches amazon website
When user searches for a product and clicks on search button
Then result set should contain that particular model
And user must be able to extract the details
