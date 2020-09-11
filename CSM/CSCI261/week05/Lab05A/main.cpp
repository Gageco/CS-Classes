/*
Author: Gage Coprivnicar
Section: A
Week: 5
Homework: 1
*/
#include <iostream>
using namespace std;

int main() {
  //setting variables
  int userInput[15];
  int repeatVar = 1;
  int i = 0;
  //intro
  cout << "**********************************************************************" << endl;
  cout << "Welcome to array land and get ready for the best time of your life!!!!" << endl;
  cout << "**********************************************************************" << endl;
  cout << endl;
  cout << "Please put in 15 different numbers" << endl;

  //taking user input
  while (repeatVar <= 15) {
    cout << "Number " << repeatVar << ": ";
    cin >> userInput[repeatVar];
    //cout << endl << repeatVar << endl <<userInput[repeatVar] << endl;
    repeatVar += 1;
  }
  //reseting repeatVar
  cout << "Awesome your numbers were: ";
  repeatVar = 1;

  //kicking userInput back out
  while (repeatVar <= 15) {
    cout << userInput[repeatVar] << " ";
    repeatVar += 1;
  }

cout << endl << "Hope you had fun see you next time" << endl;

return 0;
}
