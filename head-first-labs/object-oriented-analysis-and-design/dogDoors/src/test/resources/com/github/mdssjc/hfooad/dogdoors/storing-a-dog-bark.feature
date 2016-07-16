# The Ultimate Dog Door, version 3.0
Feature: Storing a Dog Bark 

Scenario: Main Path 
  Given The owner’s dog barks$ into the dog door. 
    |"Woof" | "Rif"| 
  When The dog door stores the owner’s dog’s bark. 
  Then The barks$ are stored. 
    |"Woof" | "Rif"| 
