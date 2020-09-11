/*
Author: Gage Coprivnicar
Section: A
Week: 2
Homework 2
*/
#include <iostream>
#include <cstdlib>
#include <ctime>
#include <ios>
#include <iomanip>
#include <cmath>
using namespace std;

int main() {
//Declaration of variables
float x1;
float y1;

float x2;
float y2;

float x3;
float y3;

float mag1;
float mag2;
float mag3;

float heronsVar;
float triPerimeter;
float triArea;

// Part I:
srand(time(0));
x1 = rand()%20-10;
y1 = rand()%20-10;

cout << "First point coordinates: " << x1 << ", " << y1 << endl << "Please enter coordinates for second point: ";
cin >> x2 >> y2;
cout << "Please enter coordinates for third and final point: ";
cin >> x3 >> y3;
//Part II:
mag1 = sqrt(pow(x1, 2) + pow(y1, 2));
mag2 = sqrt(pow(x2, 2) + pow(y2, 2));
mag3 = sqrt(pow(x3, 2) + pow(y3, 2));
triPerimeter = mag1 + mag2 + mag3;

//Herons formula
//http://mathworld.wolfram.com/SSSTheorem.html
heronsVar = (0.5) * (mag1 + mag2 + mag3);
triArea = sqrt(heronsVar * (heronsVar - mag1) * (heronsVar - mag2) * (heronsVar - mag3));

//Part III:
cout << "Sides of the triangle are " << fixed << setprecision(2) << mag1 << ", " << fixed << setprecision(2) <<  mag2 << ", "<< fixed << setprecision(2) << mag3 << ", " << endl;
cout << "Perimeter of the triangle is " << fixed << setprecision(2) << triPerimeter << endl;
cout << "Area of the triangle is " << fixed << setprecision(2) << triArea << endl;

return 0;
}
