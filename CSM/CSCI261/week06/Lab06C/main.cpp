/*
Author: Gage Coprivnicar
Section: A
Week: 6
Homework: 3
*/
#include <iostream>
using namespace std;

int main() {
  //setting variables
  int userInput[100];
  int repeatVar = 1;
  bool keepingOnKeepingOn = true;
  int i = 0;
  int j = 0;
  int k = 0;
  int finalNumber;
  //intro
  cout << "**********************************************************************" << endl;
  cout << "Welcome to array land and get ready for the best time of your life!!!!" << endl;
  cout << "**********************************************************************" << endl;
  cout << endl;
  cout << "Please put in different numbers" << endl;

  //taking user input
  while (userInput[repeatVar-1] != -1) {
    cout << "Number " << repeatVar << ": ";
    cin >> userInput[repeatVar];
    repeatVar += 1;
  }

  //reseting repeatVar
  cout << "Awesome your numbers were: ";
  repeatVar = 1;

  //kicking userInput back out
  while (userInput[repeatVar] != -1) {
    cout << userInput[repeatVar] << " ";
    repeatVar += 1;
  }

  finalNumber = repeatVar-1;

  cout << endl << endl;
  cout << "The first number is " << userInput[1] << endl;
  cout << "The last number is " << userInput[finalNumber] << endl;

  repeatVar = 1;

  //finding the largest number
    while (repeatVar <= finalNumber) {
      if (i >= userInput[repeatVar]) {
        i = i;
      }
      else if (userInput[repeatVar] > i) {
        i = userInput[repeatVar];
      }
      repeatVar += 1;
    }
cout << "The largest number found is: " << i << endl;

//finding the smallest number
  repeatVar = 1;
  while (repeatVar <= finalNumber) {
    if (i <= userInput[repeatVar]) {
      i = i;
    }
    else if (userInput[repeatVar] < i) {
      i = userInput[repeatVar];
    }
    repeatVar += 1;
  }
cout << "The smallest number found is: " << i << endl;


cout << endl << "Hope you had fun see you next time" << endl;
return 0;
}
