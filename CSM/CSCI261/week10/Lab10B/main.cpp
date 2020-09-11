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
#include "triangles.h"

using namespace std;


int main() {

    //declaration of vars
    int triValues[3];
    double varD;
    double _side01rea;
    int userInput;
    char repeat = 't';

    while (repeat == 't') {
        cout << endl << endl << endl << "Hello, please selection an option: " << endl;
        cout << "2. Print Measurements" << endl << "3. Check Triangle Feasibility" << endl;
        cout << "4. Classify Triangle" << endl << "5. Print Triangle Perimeter" << endl << "6. Print Triangle Area" << endl << "7. Exit" << endl;
        cout << "Enter Choice Here: ";
        cin >> userInput;
        cout << endl;

        Triangle userTriangle(2, 3, 4);
        switch (userInput) {
        case 2: 
            userTriangle.optionTwo();//INPUT 2. Print Measurements
            break;
        case 3: 
            userTriangle.validate();//INPUT 3. Check Triangle Feasibility
            break;
        case 4: 
            userTriangle.optionFour(); //INPUT 4. Classify Triangle
            break;
        case 5: 
            userTriangle.optionFive(); //INPUT 5. Print Triangle Perimeter
            break;
        case 6: 
            userTriangle.optionSix();//INPUT 6. Print Triangle Area
            break;
        case 7: 
            repeat = 'f';
            break;
        default:
            cout << "That doesnt seem to be a valid option, please try again" << endl;
            break;
        }
    }
    return 0;
}
