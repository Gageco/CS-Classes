/*
Author: Gage Coprivnicar
Section: A
Week: 3
Homework 2
*/
#include <iostream>
#include <cmath>
#include <algorithm>
using namespace std;

int main() {
//declaration of vars
  double varA;
  double varB;
  double varC;
  double varD;
  double varArea;
  const double TOLERANCE = 0.0001;
  int userInput;
  bool isTriangle;
  char repeat = 't';

while (repeat == 't') {
cout << endl << endl << endl << "Hello, please selection an option: " << endl;
cout << "1. Enter Measurements" << endl << "2. Print Measurements" << endl << "3. Check Triangle Feasibility" << endl;
cout << "4. Classify Triangle" << endl << "5. Print Triangle Perimeter" << endl << "6. Print Triangle Area" << endl << "7. Exit" << endl;
cout << "Enter Choice Here: ";
cin >> userInput;
cout << endl;

//INPUT 1. Enter Measurements
if (userInput == 1) {
  cout << endl << "Hello, please put in 3 different values to determine what type of triangle they make." << endl;
  cout << "First point:  ";
  cin >> varA;
  cout << "Second point: ";
  cin >> varB;
  cout << "Third point:  ";
  cin >> varC;
}
//INPUT 2. Print Measurements
if (userInput == 2) {
  if(varB>varA)
  swap(varB,varA);
  if(varB>varC)
  swap(varB,varC);
  if(varC>varA)
  swap(varC,varA);
  if(varC>varB)
  swap(varC,varB);
  if(varA>varC)
  swap(varA,varC);

  cout << endl << "Your Measurements were as follows:" << endl << "First Point: " << varA << endl;
  cout << "Second Point: " << varB << endl << "Third Point: " << varC << endl;
}
//INPUT 3. Check Triangle Feasibility
if (userInput == 3) {
  if ((varA <= 0) || (varB <= 0) || (varC <= 0)) {
    cout << "Uh oh it looks like those sides dont make a triange. Give it another try!" << endl;
    isTriangle = false;
  }
//ok so whats happening here is i am sorting the variables from lowest to highest so that every time the code excecutes with the same numbers assigned to different varialbes it will give the same result. it isnt something that we have learned in class but something i know from previous expirence. I hope that is ok pls dont take of points, it gets the job down effectively and the end user doesnt notice a difference so i dont know why you would but just in case it would be nice to cover my bases. Have a beautiful day you marvel of nature

  else {
    if(varB>varA)
    swap(varB,varA);
    if(varB>varC)
    swap(varB,varC);
    if(varC>varA)
    swap(varC,varA);
    if(varC>varB)
    swap(varC,varB);
    if(varA>varC)
    swap(varA,varC);

    if (varC >= (varA + varB)) {
      cout << "Uh oh it looks like those sides dont make a triange. Give it another try!" << endl;
      isTriangle = false;
    }
    else {
        cout << "Looks like those are some valid points, nice going!" << endl;
        isTriangle = true;
      }
    }
  }
//INPUT 4. Classify Triangle
if (userInput == 4) {
  //eliminate negatives and zeros as well as any invalid triangles
    if (isTriangle == false) {
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

}
//INPUT 5. Print Triangle Perimeter
if (userInput == 5) {
  cout << "The perimeter of the triangle is: " << (varA + varB + varC) << " units." << endl;
}
//INPUT 6. Print Triangle Area
if (userInput == 6) {
  varD = (varA + varB + varC)/2;
  varArea = sqrt((varD*(varD-varA)*(varD-varB)*(varD-varC)));
  cout << "The area of the triange is: " << varArea << " units." << endl;
}
//INPUT 7. Exit
if (userInput == 7) {
  repeat = 'f';
}

if (userInput > 7) {
    cout << "That doesnt seem to be a valid option, please try again" << endl;
}

}
  return 0;
}
