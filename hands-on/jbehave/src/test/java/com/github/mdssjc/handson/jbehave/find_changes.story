Narrative:
In order to give small changes
As a change machine
I want to give the small number of coins for an amount of money

Scenario: One Coin Changes

Given a change machine
When I ask for change of <value>
Then it returns the <coin> coins

Examples:
|value|coin|
|0.01|1c|
|0.05|5c|
|0.10|10c|
|0.25|25c|
|0.50|50c|

Scenario: Only coin changes

Given a change machine
When I ask for change of 1.00
Then it will raise an error

Given a change machine
When I ask for change of -0.10
Then it will raise an error

Scenario: More than one coin, but same type

Given a change machine
When I ask for change of <value>
Then it returns the <coin> coins

Examples:
|value|coin|
|0.02|1c,1c|
|0.03|1c,1c,1c|
|0.04|1c,1c,1c,1c|
|0.20|10c,10c|

Scenario: Mixed coin types

Given a change machine
When I ask for change of <value>
Then it returns the <coin> coins

Examples:
|value|coin|
|0.06|5c,1c|
|0.17|10c,5c,1c,1c|
|0.38|25c,10c,1c,1c,1c|
|0.96|50c,25c,10c,10c,1c|
