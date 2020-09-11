/*
Author: Gage Coprivnicar
Section: A
Week: 7
Homework: Assignment 07
*/

#include <iostream>
#include <string>
#include <iomanip>

using namespace std;

//couple of universal variables
int userOption;
int i;

//menu options
string menuOptions[4] = {"lbs to kg", "ft to m", "BMI", "ft to cm"};

double doPoundsToKilograms(double lbs) {
  double kgs;
  kgs = .454 * lbs;
  return kgs;
}
void poundsToKilograms() {
  double lbs;
  double kgs;
  cout << "Welcome to Pounds to Kilograms, please enter value: ";
  cin >> lbs;
  kgs = doPoundsToKilograms(lbs);
  cout << lbs << "lbs in kilos is " << kgs << "kgs" << endl;
}

double doFeetToMeters(double ft) {
  double m;
  m = .3048 * ft;
  return m;
}
void feetToMeters() {
  double ft;
  double m;
  cout << "Welcome to Feet to Meters, please enter value: ";
  cin >> ft;
  m = doFeetToMeters(ft);
  cout << ft <<"ft in meters is " << m <<"m" << endl;
}

double doFeetToCm(double ft) {
  double cm;
  double m;
  m = doFeetToMeters(ft);
  cm = m*100;
  return cm;
}
void feetToCm() {
  double cm;
  double ft;
  cout << "Welcome to Feet to Centimeters, please enter value: ";
  cin >> ft;
  cm = doFeetToCm(ft);
  cout << ft << "ft in centimeters is " << cm <<"cm" << endl;
}

double doBMI(double ft, double lbs) {
  double kg;
  double m;
  double bmi;
  m = doFeetToMeters(ft);
  kg = doPoundsToKilograms(lbs);
  bmi = kg/(m*m);
  return bmi;
}
void BMI() {
  double ft;
  double lbs;
  double bmi;
  cout << "Welcome to BMI" << endl << "Enter Height (ft): ";
  cin >> ft;
  cout << "Enter Weight (lbs): ";
  cin >> lbs;
  bmi = doBMI(ft, lbs);
  cout << "Your BMI is: " << bmi;
}



void menu() {
  //intro
  cout << "**************************************" << endl;
  cout << "WELCOME TO YOUR PERSONAL CALCULATOR!!!" << endl;
  cout << "**************************************" << endl;

  //showing options
  for (i = 0; i < 4; i++ ) {
    cout << right << setw(10) << menuOptions[i] << ": " << i +1 << endl;
  }
  cout << "Which would you like to do?: ";
  cin >> userOption;

  //user chooses what happens next
  switch (userOption) {
    case 1: //lbs to kg
      poundsToKilograms();
      break;

    case 2:   //ft to m
      feetToMeters();
      break;

    case 3:    //bmi
      BMI();
      break;

    case 4:     //ft to cm
      feetToCm();
      break;

    default:
      cout << "Sorry, that wasnt a valid input, exiting program" << endl;

  }
}

int main() {
  menu();
  return 0;
}
//easy peasy
