/*
Author: Gage Coprivnicar
Section: A
Week: 4
Homework 3
*/
#include <iostream>
#include <cstdlib>
#include <ctime>
using namespace std;

int main() {
  //declaring variables
  int userInput;
  int computerInput;
  bool repeatVar = true;
  int userTries = 0;
  const int TOO_CLOSE_DIFFERENCE = 5;
  const int TOO_HIGH_DIFFERENCE = 25;

  //generate sudo random number between 0 and 100 and set it equal to computerInput
  srand(time(NULL));
  computerInput = rand() % 101;

  //intro
  cout << "****************************************************************" << endl;
  cout << "Get ready because we are going to be playing guess the number!!!" << endl;
  cout << "****************************************************************" << endl;
  //cout << computerInput; //REMOVE THIS
  cout << endl;


  //while loop
  while (repeatVar == true) {

    cout << "Okay, guess a number between 0 and 100 please!: ";
    cin >> userInput;

    //start if statements
    if (userInput == computerInput) {
      cout << "Hey nice job! You managed to guess the number in " << userTries << " tries! Good Game" << endl;
      repeatVar = false;
    }
    else {
      if (userInput > computerInput) { //userInput is greater than computer input
        //cout << userInput - computerInput << endl;
        if ((userInput - computerInput) <= TOO_CLOSE_DIFFERENCE) {
          cout << "Too high of a guess, but your really close!" << endl;
        }
        else {
          cout << "Too high of a guess, not even close" << endl;
        }
      }

      if (userInput < computerInput) { // userInput is less than computer input
        //cout << computerInput - userInput << endl;
        if ((computerInput - userInput) <= TOO_CLOSE_DIFFERENCE) {
          cout << "Too low of a guess, but your really close!" << endl;
        }
        else {
          cout << "Too low of a guess, not even close" << endl;
        }
      }
      //add one to try counter
      userTries += 1;
      cout << endl;
    }
}
}
