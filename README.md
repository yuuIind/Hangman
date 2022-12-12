# Hangman
**IT'S NOT FINISHED YET**
**A Simple Hangman game**

## Features

- Has a Gui!
- Records the players detail on a file
- At any time, users are able to quit the game by clicking on the appropriate key combination
- The game GUI has a visual keyboard which can be interacted via mouse of arrow buttons
- Questions include:
     > a tip about the question
      
     > a list of 6 letters - vowels and nonvowels that are not in the given in the question
  
  as hints to assist player
- At any time during the game, current status of game is shown
     >  In progress

     >  You WON!
     
     >  You LOSE!
- The question should be answered in time limit.
- The timeout period is set based on the difficulty of the question
- All the questions of the game are stored comma-separated values (CSV) in a text file
    > the tip, not-in-string characters, the hidden string, countdown timeout value
- Question file is manually created
- Game randomly picks a question from the question file to ask to the player
- Players are able to start a new game by clicking on the relevant menu item
- Players are able to restart their current attempt without changing the question by clicking relevant menu item.
- Players are also able to see the scores list
- Scores list contains the list of ten highest scoring players
- Every time the player fails to identify a character in the question, one of the six body parts is added to the picture
- Plays the relevant sounds after each character selection of the player
