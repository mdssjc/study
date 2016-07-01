Narrative:
In order to give small changes
As a change machine
I want to give the small number of coins for an amount of money

Scenario: Simple Changes

Given a change machine
When I ask for change of <value>
Then it returns the <coin> coin

Examples:
|value|coin|
|0.01|1c|
|0.05|5c|

Scenario: Complex Changes

Given a change machine
When I ask for change of 0.03
And I ask for change of 0.02
Then it returns the 1c, 1c, 1c coins
And it return the 1c, 1c coins