/*
Author: Gage Coprivnicar
Section: A
Week: 10
Homework: Lab10B
*/
#include <iostream>
#include <cmath>
#include <algorithm>
#include <ctime>
using namespace std;
#include "triangles.h"


Triangle::Triangle() {
    _side01 = 1;
    _side02 = 1;
    _side03 = 1;
}

Triangle::Triangle(int a, int b, int c) {
    _side01 = a;
    _side02 = b;
    _side03 = c;
}

void Triangle::optionOne() {
    cout << endl << "Hello, please put in 3 different values to determine what type of triangle they make." << endl;
    cout << "Point 1: ";
    cin >> _side01;
    cout << "Point 2: ";
    cin >> _side02;
    cout << "Point 3: ";
    cin >> _side03;
}

void Triangle::optionTwo() {
    if (_side02>_side01)
        swap(_side02, _side01);
    if (_side02>_side03)
        swap(_side02, _side03);
    if (_side03>_side01)
        swap(_side03, _side01);
    if (_side03>_side02)
        swap(_side03, _side02);
    if (_side01>_side03)
        swap(_side01, _side03);

    cout << endl << "Your Measurements were as follows:" << endl << "First Point: " << _side01 << endl;
    cout << "Second Point: " << _side02 << endl << "Third Point: " << _side03 << endl;
}

void Triangle::validate() {
    if ((_side01 <= 0) || (_side02 <= 0) || (_side03 <= 0)) {
        cout << "Uh oh it looks like those sides dont make a triange. Give it another try!" << endl;
        isTriangle = false;
    }
    if (_side03 >= (_side01 + _side02)) {
        cout << "Uh oh it looks like those sides dont make a triange. Give it another try!" << endl;
        isTriangle = false;
    }
    else {
        cout << "Looks like valid points" << endl;
        isTriangle = true;
    }
}

void Triangle::optionFour() {
    const double TOLERANCE = 0.0001;
    //eliminate negatives and zeros as well as any invalid triangles
    if (isTriangle == false) {
        cout << "Uh oh it looks like those points dont make a triange. Give it another try!" << endl;
    }
    else {
        //right tri
        if (fabs(pow(_side01, 2) + pow(_side02, 2) - pow(_side03, 2)) <= TOLERANCE) {
            cout << "The triangle with the sides entered is a right triangle!" << endl;
        }
        //acute tri
        if (pow(_side01, 2) + pow(_side02, 2) > pow(_side03, 2)) {
            cout << "The triange with the sides entered is an acute triange!" << endl;
        }
        //obtuse tri
        if (pow(_side01, 2) + pow(_side02, 2) < pow(_side03, 2)) {
            cout << "The triange with the sides entered is an obtuse triange!" << endl;
        }
    }
}

float Triangle::optionFive() {
    cout << "The perimeter of the triangle is: " << (_side01 + _side02 + _side03) << " units." << endl;
    return (_side01 + _side02 + _side03);
}

float Triangle::optionSix() {
    float varD;
    float triArea;
    cout << "1: " << _side01 << endl << "2: " << _side02 << endl << "3: " << _side03 << endl;
    varD = ((float)_side01 + (float)_side02 + (float)_side03) / (float)2;
    cout << varD << endl;
    triArea = sqrt((varD*(varD - (float)_side01)*(varD - (float)_side02)*(varD - (float)_side03)));
    cout << "The area of the triange is: " << triArea << " units." << endl;
    return triArea;
}