/*
Author: Gage Coprivnicar, sunshengliu
Section: A
Week: 7
Homework: 2
*/
#include <iostream>

using namespace std;

const int LENGTH_OF_USERINPUT = 5;
int userInput[LENGTH_OF_USERINPUT];

int allThrees(int userInput[LENGTH_OF_USERINPUT]) {
  for (int i = 0; i < LENGTH_OF_USERINPUT; i++) {
    if (userInput[i] != 3) {
      return 0;
    }
  }
  return 15;
}

int allSixes(int userInput[LENGTH_OF_USERINPUT]) {
  for (int i = 0; i < LENGTH_OF_USERINPUT; i++) {
    if (userInput[i] != 6) {
      return 0;
    }
  }
  return 30;
}

int main() {
  //defining variables
  int totScore = 0;
  for (int i = 0; i < LENGTH_OF_USERINPUT; i++) {
      cout << "Value for Die0" << i+1 << ": ";
      cin >> userInput[i];
  }

  totScore += allThrees(userInput);

  totScore += allSixes(userInput);
  cout << "Total Score: " << totScore << endl;

return 0;
}
