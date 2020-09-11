/*
Author: Gage Coprivnicar
Section: A
Week: 5
Homework: 1
*/
#include <iostream>
using namespace std;

int main() {
  //defining variables
  const int NUMBER_OF_CHARS_IN_STR = 10;

  bool alreadyGuessed = false;
  bool doesUserGuessExistInStringToGuess = false;
  bool repeatVar = true;
  bool hopefullyTheLastDumbBoolThingIAmGoingToHaveToUseInThisRidiclousProgram = false;

  char stringToGuess[] = {"coprivnicar"};
  char outputString[] = {"___________"};
  char previousGuesses[26] = {};
  char userGuess;

  int numberOfGuesses = 7;
  int i;
  int j;
  int k = 0;
  int l;
  int a;
  int b;

  //initilizing
  cout << "***********************************" << endl;
  cout << "WELCOME TO WHEEL OF FORTUNE (TM)!!!" << endl;
  cout << "***********************************" << endl;
  cout << endl;

  while (repeatVar == true) {

    //GET USER INPUT
    cout << "Your Guess: ";
    cin >> userGuess;
    userGuess = tolower(userGuess);

    //!!!!!!!!!!!! THIS SECTION IS WORKING DONT MESS WITH IT PLEASE
    // CHECK IF USER HAS PUT IN A NEW VARABLE OR NOT
    for (i=0; i <= sizeof(previousGuesses); i += 1) {
      if (userGuess != previousGuesses[i]) {
        ;
      }
      else {
        alreadyGuessed = true;
      }
    }

    if (alreadyGuessed == true) {
      cout << "You already guessed '" << userGuess << "'" << endl;
      alreadyGuessed = false;
    }

    else if (alreadyGuessed == false) { //if userGuess has not alreadu been guessed
      cout << "You have not guessed '" << userGuess << "' yet!" << endl;

      for (i=0; i<=NUMBER_OF_CHARS_IN_STR; i += 1) {
        if (userGuess != stringToGuess[i]) {
          ;
        }
        else if (userGuess == stringToGuess[i]) {
          doesUserGuessExistInStringToGuess = true;
        }
      }
      // THIS IF AND ELSE IF STATEMENT CHECK THE OUTPUT OF THE PREVIOUS FOR STATEMENT
      if (doesUserGuessExistInStringToGuess == true) {
        cout << "There is a '" << userGuess << "'" << endl;
        doesUserGuessExistInStringToGuess = false;
      }
      else if (doesUserGuessExistInStringToGuess == false) {
        numberOfGuesses -= 1;
        cout << "Sorry there is no '" << userGuess << "'. ";
        cout << "You have " << numberOfGuesses << " guesses left" << endl;
      }

    }
    //END CHECK IF USER HAS PUT IN A NEW VARIABLE OR NOT

    previousGuesses[k] = userGuess;

    //START OUTPUT OF THE UNDERSCORES AND CURRENT LETTERS guessed
    for (i=0; i <= NUMBER_OF_CHARS_IN_STR; i+=1) {
      for (j=0; j <= 26; j+=1) {
        if (stringToGuess[i] != previousGuesses[j]) {
          ;
        }
        else if (stringToGuess[i] == previousGuesses[j]) {
          hopefullyTheLastDumbBoolThingIAmGoingToHaveToUseInThisRidiclousProgram = true;
          l = i;
        }
      }

      if (hopefullyTheLastDumbBoolThingIAmGoingToHaveToUseInThisRidiclousProgram == true) {
        //SOMETHIG TO DO SOMETHING OR OTHER TO ALLOW FOR NEW CHARACTERS TO BE PUT IN WITHOUT REPLACEING THE OLD ONES
        //cout << outputString[l] << endl;

        if (outputString[l] == '_') {
          outputString[l] = previousGuesses[k];
        }

        //cout << previousGuesses[k] << " ";
        hopefullyTheLastDumbBoolThingIAmGoingToHaveToUseInThisRidiclousProgram = false;
      }
      else if (hopefullyTheLastDumbBoolThingIAmGoingToHaveToUseInThisRidiclousProgram == false) {
        ;
      }
    }

  cout << "Output: " << outputString << endl;
  cout << endl;
  k += 1;

//kick if number of guesses == 0
  if ((outputString[0] == stringToGuess[0]) && (outputString[1] == stringToGuess[1]) && (outputString[2] == stringToGuess[2]) && (outputString[3] == stringToGuess[3]) && (outputString[4] == stringToGuess[4]) && (outputString[5] == stringToGuess[5]) && (outputString[6] == stringToGuess[6]) && (outputString[7] == stringToGuess[7]) && (outputString[8] == stringToGuess[8]) && (outputString[9] == stringToGuess[9]) && (outputString[10] == stringToGuess[10])) {

    //ok hear me out i know its a little cheaty but this way is sooooo much easier than writing another dumb for loop to iterate trhough all the characters in the string and comparing them so please forgive me. as i am sure you have noticed by now I have used a lot of for loops so i know how to use them and i dont really want to work with them again. you have a good day
    cout << "Nice job! You have guessed the string!" << endl;
    cout << "The string was: " << stringToGuess << endl;
    repeatVar = false;
  }
  if (numberOfGuesses == 0) {
    repeatVar = false;
    cout << "You lose." << endl;
  }
  }
/*
oof this was a doozy of a program, i have had 10 cups of coffee and i am feeling really creative right now
so yeah thats why the variables names are a bit odd but dont worry about it. This was a good challenge, the logic of for
statements has always been a pain to wrap my head around and this was no exception. so yeah this was an excellent challenge.
you have a nice day/night and thanks.
*/
}
