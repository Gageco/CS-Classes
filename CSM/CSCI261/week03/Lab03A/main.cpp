/*
Author: Gage Coprivnicar
Section: A
Week: 3
Homework 1
*/
#include <iostream>
#include <cmath>
using namespace std;

int main() {
//declaration of vars
  double varA;
  double varB;
  double varC;
  const double TOLERANCE = 0.0001;
//userinput
  cout << "Hello, please put in 3 different values to determine what type of triangle they make." << endl;
  cout << "First point:  ";
  cin >> varA;
  cout << "Second point: ";
  cin >> varB;
  cout << "Third point:  ";
  cin >> varC;

//eliminate negatives and zeros as well as any invalid triangles
  if ((varA <= 0) || (varB <= 0) || (varC <= 0) || (varC >= (varA + varB))) {
    cout << "Uh oh it looks like those points dont make a triange. Give it another try!" << endl;
  }
  else {
    //right tri
    if (fabs(pow(varA,2 ) + pow(varB, 2) - pow(varC, 2)) <= TOLERANCE) {
      cout << "The triangle with the sides entered is a right triangle!" << endl;
    }
    //acute tri
    if (pow(varA,2) + pow(varB,2) > pow(varC,2)) {
      cout << "The triange with the sides entered is an acute triange!" << endl;
    }
    //obtuse tri
    if (pow(varA,2) + pow(varB,2) < pow(varC,2)) {
      cout << "The triange with the sides entered is an obtuse triange!" << endl;
    }
  }

  return 0;
}
