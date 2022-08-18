# Suga Engine

The Suga Engine is a complete game engine written in Java written from scratch. As follows is a small description of the
contents of each package as well as the goal each aims to achieve.

## Game Engine

The Game Engine section only contains the class GameEngine which has only static methods to manage the engine. These
include creating the game window, starting graphics/logic threads, stopping the engine, and providing a straight forward
to use logger.

## Game

The game package handles things relating specifically to the game. This includes things like the actual main game class,
scenes that may be loaded by a game, objects that interact in the game, and AIAgents.

### Game

Generally when using the Suga Engine developers should start by implementing the Game interface provided in the Game
package. Games contain the entry point for keyboard and mouse input, a collection of scenes to be loaded on demand, the
physics engine of choice, and any game objects or AI currently loaded. The game some middle level overhead with direct 
access to the graphics panel and logic thread along with containing the 'main loop' running on the logic thread.

### Scene

Scenes contain a collection of game objects and AI to load and inject into the game while loaded. They are also the
next destination and likely final destination for keyboard and mouse input. 

### Game Object

What defines a game object is likely the most gray part of the Suga Engine currently. As of v2.0.0 game objects are
things that can run logic on every frame and provide a draw listener/collidable. This definition is not strict as
game objects are free to return null for either/both of these without causing warnings. 

Game objects are expected to be the building blocks of games including walls, intractable items, characters, enemies, 
etc. UI is expected to be implemented using just a draw listener.

### AI Agent

AIAgents are simply objects which have their own method, runLogic() called independently of game objects and physics. In 
the case of the BasicGame implementation this happens after physics and before game object logic. AIAgents are intended
to essentially be game objects without needing to provide a collidable/draw listeners.

## Graphics

Anything relating specifically to drawing graphics to the screen. At a lower level than the graphics package both JFrame
and JPanel are being used. Contains some useful shortcuts for graphical elements.

### UI

Game elements which are only for the interface. These are essentially just draw listeners or game objects without a
collidable with some extra shortcuts to aid them.

#### Menu

A menu has one or more options which are moved between using the mouse and/or keyboard. Depending on the option
currently highlighted the display may need to be altered or a different result called.

### Draw Listener

Draw listeners are objects which are queried on each frame whether they have something to draw, and how they'd like to
draw it. They can range wildly from a score indicator to an enemy character.

## Input

## Logger

## Physics

## Sound

## Threads
