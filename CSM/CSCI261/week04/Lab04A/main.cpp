/*
Author: Gage Coprivnicar
Section: A
Week: 4
Homework 1
*/
#include <iostream>
#include <cmath>
#include <iomanip>
#include <algorithm>
#include <ios>
using namespace std;

int main() {
//declaration of vars
  double varA;
  double varB;
  double varC;
  double varD;
  const double TOLERANCE = 0.0001;
  bool continueLoop = true;
  double varArea;

while (continueLoop == true) {
//userinput
  cout << "Please put in 3 different values to determine what type of triangle they make." << endl;
  cout << "First side:  ";
  cin >> varA;
  cout << "Second side: ";
  cin >> varB;
  cout << "Third side:  ";
  cin >> varC;

//Swap values around from lowest to highest
  if(varB>varA) {
    varD = varB;
    varB = varA;
    varA = varD;
  //swap(varB,varA);
  }
  if(varB>varC) {
    varD = varB;
    varB = varC;
    varC = varD;
  //swap(varB,varC);
  }
  if(varC>varA) {
    varD = varC;
    varC = varA;
    varA = varD;
  //swap(varC,varA);
  }
  if(varC>varB) {
    varD = varC;
    varC = varB;
    varB = varD;
  //swap(varC,varB);
  }
  if(varA>varC) {
    varD = varA;
    varA = varC;
    varC = varD;
  //swap(varA,varC);
  }
  cout << endl;

//eliminate negatives and zeros as well as any invalid triangles
  if ((varA <= 0) || (varB <= 0) || (varC <= 0) || (varC >= (varA + varB))) {
    cout << "Uh oh it looks like those points dont make a triange. Try again" << endl << endl;
  }
  else {
    //right tri
    if (fabs(pow(varA,2 ) + pow(varB, 2) - pow(varC, 2)) <= TOLERANCE) {
      cout << "Woohoo - input is valid" << endl;
      cout << "The triangle with the sides entered is a right triangle!" << endl; //definition of triangle
      cout << "The perimeter of the triangle is: " << (varA + varB + varC) << " units." << endl; //perimeter
      varD = (varA + varB + varC)/2; // area
      varArea = sqrt((varD*(varD-varA)*(varD-varB)*(varD-varC))); // area
      cout << "The area of the triange is: " << fixed << setprecision(2) << varArea << " units." << endl; // area
      continueLoop = false;
    }
    //acute tri
    else if (pow(varA,2) + pow(varB,2) > pow(varC,2)) {
      cout << "Woohoo - input is valid" << endl;
      cout << "The triange with the sides entered is an acute triange!" << endl; //definition of triangle
      cout << "The perimeter of the triangle is: " << (varA + varB + varC) << " units." << endl; //perimeter
      varD = (varA + varB + varC)/2; // area
      varArea = sqrt((varD*(varD-varA)*(varD-varB)*(varD-varC))); // area
      cout << "The area of the triange is: " << fixed << setprecision(2) << varArea << " units." << endl; // area
      continueLoop = false;
    }
    //obtuse tri
    else if (pow(varA,2) + pow(varB,2) < pow(varC,2)) {
      cout << "Woohoo - input is valid" << endl;
      cout << "The triange with the sides entered is an obtuse triange!" << endl; //definition of triangle
      cout << "The perimeter of the triangle is: " << (varA + varB + varC) << " units." << endl; //perimeter
      varD = (varA + varB + varC)/2; // area
      varArea = sqrt((varD*(varD-varA)*(varD-varB)*(varD-varC))); // area
      cout << "The area of the triange is: " << fixed <<setprecision(2) << varArea << " units." << endl; // area
      continueLoop = false;
    }
  }


  }
return 0;
}
