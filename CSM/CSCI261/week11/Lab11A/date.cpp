/*
Author: Gage Coprivnicar
Section: A
Week: 11
Homework: LabA
*/

#include <iostream>
#include <string>
using namespace std;

#include "date.h"

//PUBLIC FUNCTIONS
void Date::setDate(int m, int d, int y) {
    setMonth(m);
    setDay(d);
    setYear(y);
    cout << "The date 8.1.76 is significant because it is the day that CO joined the Union" << endl;
}
void Date::setDate() {
    setMonth(12);
    setDay(30);
    setYear(1950);
    cout << "The dat 12.30.1950 is significant because 1B. Stroustrup, creator of C++ was born" << endl;
}

string Date::getDate() {
    string returnString;
    int month1 = _month;
    int day1 = _day;
    int year1 = _year;
    returnString = to_string(month1) + "/" + to_string(day1) + "/" + to_string(year1);
    return returnString;

 }

bool Date::isEarlierDate(Date otherDate) {
    int shouldBeEarlier;
    int shouldBeLater;
    
    shouldBeEarlier = _day + _month + _year;
    shouldBeLater = otherDate._day + otherDate._month + otherDate._year;
    
    if (shouldBeEarlier < shouldBeLater) {
        return true;
    }
    else {
        return false;
    }
}

//PRIVATE FUNCTIONS
void Date::setMonth(int m) {
    if (m <= 12 && m >= 1) {
        _month = m;
    }
    else {
        cout << "Not a valid _month, defaulting to 12" << endl;
        _month = 12;
    }
}

void Date::setDay(int d) {
    if (d <= 30 && d >= 1) {
        _day = d;
    }
    else {
        cout << "Not a valid _day, defaulting to 30";
        _day = 30;
    }
}

void Date::setYear(int y) {
    if (y >= 0) {
        _year = y;
    }
    else {
        cout << "Not a valid _year, defaulting to 1950";
        _year = 1950;
    }
}