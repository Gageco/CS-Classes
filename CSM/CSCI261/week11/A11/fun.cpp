/*
Author: Gage Coprivnicar
Section: A
Week: 11
Homework: Assigment11
*/
#include <iostream>
#include <string>
using namespace std;
#include "fun.h"

void Riddle::intro() {
    cout << "Welcome to " << endl << "****The Online Trivia Game****" << endl << endl << "Just put in the answers to the three questions and if you get it right win a prize!!!" << endl << "HINT: USE LOWERCASE" << endl << endl;
}

string Riddle::getRiddle(int num) {
    switch (num) {
    case 1:
        riddle1();
        break;
    case 2:
        riddle2();
        break;
    case 3:
        riddle3();
        break;
    default:
        break;
    }
    return _riddleQues;
}

string Riddle::getPrize() {
    return _riddlePrize;
}

void Riddle::riddle1() { //riddle 1
    _riddleAns = "google";
    _riddlePrize = "a bear";
    _riddleQues = "What is the most popular search engine in the US?";
}

void Riddle::riddle2() {//riddle 2
    _riddleAns = "wikipedia";
    _riddlePrize = "a dictionary";
    _riddleQues = "What is a online database of lots of info, but teachers dont like because anyone can edit it?";
}

void Riddle::riddle3() { //riddle 3
    _riddleAns = "mines.edu";
    _riddlePrize = "a good college education";
    _riddleQues = "what is the base domain for CSM?";
}

bool Riddle::checkRiddleAns(string ans) {
    if (_riddleAns == ans) {
        return true;
    }
    else {
        return false;
    }
}