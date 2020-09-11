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

int main() {
    string userGuess;
    
    Riddle riddle;
    riddle.intro();
    for (int i = 1; i < 4; i++) {
        cout << "Heres your riddle: " << riddle.getRiddle(i) << endl;
        cout << "Whats your guess?: ";
        getline(cin, userGuess);
        if (riddle.checkRiddleAns(userGuess)) {//returns if true
            cout << "You got it, Nice job! Your prize is: " << riddle.getPrize() << endl;
        }
        else {
            cout << "Sorry thats incorrect. You missed out on: " << riddle.getPrize() << endl;
        }

        if (i == 3) {// once it goes through all the riddles
            cout << "Thanks for playing!" << endl;
        }

        else {
            cout << "Heres the next question!" << endl << endl;
        }
    }
    return 0;
//WOO COMPLIED AND RAN CORRECTLY FIRST TRY!
}