/*
Author: Gage Coprivnicar
Section: A
Week: 7
Homework: 1
*/
#include <iostream>
#include <cstdlib>
#include <ctime>

using namespace std;

int myRand(int maxValue) {
  int valueToReturn;

  valueToReturn = rand() % maxValue;
  return valueToReturn;
}

int main() {
  //declaration of variables
  int maxValue = 0;
  int returnedValue = 0;

  //making random
  srand(time(NULL));

  //asking and taking userinput
  cout << "What is the max random number you would like?: ";
  cin >> maxValue;

  //pinging fuction myRand 10 times
  for (int i = 0; i <= 10; i++) {
    returnedValue = myRand(maxValue);
    cout << "Random Value #" << i << ": " << returnedValue << endl;
  }
  return 0;
}
