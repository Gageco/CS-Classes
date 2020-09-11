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

int main() {
    int month;
    int day;
    int year;

    cout << "Month: ";
    cin >> month;
    cout << "Day: ";
    cin >> day;
    cout << "year: ";
    cin >> year;

    Date date1;
    Date date2;

    date1.setDate();
    date2.setDate(month, day, year);

    cout << "date1: " << date1.getDate() << endl;
    cout << "date2: " << date2.getDate() << endl;

    if (date2.isEarlierDate(date1)) {
        cout << "date2 is earlier that date1" << endl;
    }
    else {
        cout << "date2 is later or the same as date1" << endl;
    }

    int i;
    cin >> i;
    return 0;
}