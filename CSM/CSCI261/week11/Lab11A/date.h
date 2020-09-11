#pragma once
#include<string>
/*
Author: Gage Coprivnicar
Section: A
Week: 11
Homework: LabA
*/
class Date {
public:
    void setDate();
    void setDate(int m, int d, int y);
    string getDate();
    bool isEarlierDate(Date otherDate);

private:
    void setMonth(int m);
    void setDay(int d);
    void setYear(int y);
    int _month;
    int _day;
    int _year;
};