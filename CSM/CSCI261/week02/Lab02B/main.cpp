/*
Author: Gage Coprivnicar
Section: A
Week: 2
Lab B
*/
#include <iostream>
#include <cstdlib>
#include <ctime>
#include <ios>
#include <iomanip>
using namespace std;

int main() {
//defining variables
int diceSides;

//seed
  srand(time(0));
  cout << "How many sides does the die have?: ";
  cin >> diceSides;

  cout << setfill(' ');
  cout << "Roll 1: " << setw(4) << right << rand()%diceSides + 1 << endl;
  cout << "Roll 2: " << setw(4) << right << rand()%diceSides + 1 << endl;
  cout << "Roll 3: " << setw(4) << right << rand()%diceSides + 1 << endl;
  cout << "Roll 4: " << setw(4) << right << rand()%diceSides + 1 << endl;
  cout << "Roll 5: " << setw(4) << right << rand()%diceSides + 1 << endl;

  return 0;
}
