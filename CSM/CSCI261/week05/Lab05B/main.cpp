/*
Author: Gage Coprivnicar
Section: A
Week: 5
Homework: 2
*/
#include <iostream>
using namespace std;

int main() {
  //setting variables
  int userInput[15];
  int repeatVar = 1;
  bool keepingOnKeepingOn = true;
  int i = 0;
  int j = 0;
  int k = 0;
  const int NUMBER_OF_REPEATS = 15; // CHANGE TO 15
  //intro
  cout << "**********************************************************************" << endl;
  cout << "Welcome to array land and get ready for the best time of your life!!!!" << endl;
  cout << "**********************************************************************" << endl;
  cout << endl;
  cout << "Please put in 15 different numbers" << endl;

  //taking user input
  while (repeatVar <= NUMBER_OF_REPEATS) {
    cout << "Number " << repeatVar << ": ";
    cin >> userInput[repeatVar];
    //cout << endl << repeatVar << endl <<userInput[repeatVar] << endl;
    repeatVar += 1;
  }
  //reseting repeatVar
  cout << "Awesome your numbers were: ";
  repeatVar = 1;

  //kicking userInput back out
  while (repeatVar <= NUMBER_OF_REPEATS) {
    cout << userInput[repeatVar] << " ";
    repeatVar += 1;
  }
cout << endl << endl;
  repeatVar = 1;

  //finding the largest number
    while (repeatVar <= NUMBER_OF_REPEATS) {
      if (i >= userInput[repeatVar]) {
        i = i;
      }
      else if (userInput[repeatVar] > i) {
        i = userInput[repeatVar];
      }
      repeatVar += 1;
    }

cout << "The largest number found is: " << i << endl;
cout << endl << "Hope you had fun see you next time" << endl;
return 0;
}
