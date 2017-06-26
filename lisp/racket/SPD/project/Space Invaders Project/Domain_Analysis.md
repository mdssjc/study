# Space Invaders Project: Domain Analysis

There are many different versions of Space Invaders. For this project, your Space Invaders game should have the following behaviour:

 * The tank should move right and left at the bottom of the screen when you press the arrow keys. If you press the left arrow key, it will continue to move left at a constant speed until you press the right arrow key.
 * The tank should fire missiles straight up from its current position when you press the space bar.
 * The invaders should appear randomly along the top of the scree and move at a 45 degree angle. When they hit a wall they will bounce off and continue at a 45 degree angle in the other direction.
 * When an invader reaches the bottom of the screen, the game is over.

This is an example of what the game should look like during play. The arrows have been added on to show you how the different parts of the game move.

![Space Invaders Example](Space_Invaders_Example.png "Space Invaders Example")

## Constants

* Tank Image
* Tank Starting X Position
* Tank X Speed
* Tank Y Position
* Missile Image
* Missile Starting Y Position
* Missile Y Speed
* Missile Rate
* Invader Image
* Missile Starting Y Position
* Invader Y Speed
* Degree Angle
* Invader Rate
* Width
* Height
* MTS

## Changing

* X Position Tank
* Y Position Missile
* X Position Invader
* Y Position Invader

## Big Bang

* on-tick
* to-draw
* on-key (left, right, space)
* stop-when
