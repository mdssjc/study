# The Ultimate Dog Door, version 3.0
Feature: What the Door Does

  Scenario: Remote Path
    Given The owner’s dog barks to be let out ("Woof").
    # The owner hears her dog barking.
    When The owner presses the button on the remote control.
    Then The dog door "opens".
    # The owner’s dog goes outside.
    # The owner’s dog does his business.
    # The owner’s dog goes back inside.
    When The door shuts automatically.
    Then The dog door "closes".

  Scenario: Remote Alternate Path
    Given The owner’s dog barks to be let out ("Woof").
     # The owner hears her dog barking.
    When The owner presses the button on the remote control.
    Then The dog door "opens".
    # The owner’s dog goes outside.
    # The owner’s dog does his business.
    When The door shuts automatically.
    Then The dog door "closes".
    # The owner’s dog barks to be let back inside.
    # The owner hears her dog barking.
    When The owner presses the button on the remote control.
    Then The dog door "opens".
    # The owner’s dog goes back inside.
    When The door shuts automatically.
    Then The dog door "closes".

  Scenario: Recognizer Path
    Given The owner’s dog barks to be let out ("Woof").
    When The bark recognizer hears a bark ("Woof").
    Then If it’s the owner’s dog barking, the bark recognizer sends a request to the door to open.
    And The dog door "opens".
    # The owner’s dog goes outside.
    # The owner’s dog does his business.
    # The owner’s dog goes back inside.
    When The door shuts automatically.
    Then The dog door "closes".

  Scenario: Recognizer Alternate Path
    Given The owner’s dog barks to be let out ("Woof").
    When The bark recognizer hears a bark ("Woof").
    Then If it’s the owner’s dog barking, the bark recognizer sends a request to the door to open.
    And The dog door "opens".
    # The owner’s dog goes outside.
    # The owner’s dog does his business.
    When The door shuts automatically.
    Then The dog door "closes".
    # The owner’s dog barks to be let back inside.
    When The bark recognizer hears a bark ("Woof").
    Then If it’s the owner’s dog barking, the bark recognizer sends a request to the door to open.
    And The dog door "opens".
    # The owner’s dog goes back inside.
    When The door shuts automatically.
    Then The dog door "closes".
