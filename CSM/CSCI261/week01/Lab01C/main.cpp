/*
Author: Gage Coprivnicar
Section: A
Week: 0
Lab C
*/
#include <iostream>
using namespace std;

int main() {
  float length;
  float width;
  float height;
  float volume;
  float radius;
  float circ_area;
  const float pi = 3.14159;

  cout << "To find the dimensions of your bos first enter the following information please.";
  //height
  cout << "Height: ";
  cin >> height;
  //length
  cout << "Length: ";
  cin >> length;
  //width
  cout << "Width: ";
  cin >> width;

  volume = length * width * height;
  cout << "Thank you, the volume is: " << volume << endl;

  //Area of a circle
  cout << "Next we will be calulating the area of a circle given the radius." << endl;
  cout << "Radius: ";
  cin >> radius;
  circ_area = pi * radius * radius;
  cout << "Thank you, the area is: " << circ_area << endl;


  return 0;
}
