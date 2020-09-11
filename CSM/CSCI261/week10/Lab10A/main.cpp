/* CSCI261 Lab 11A: Money Class
 *
 * Author: Tracy Camp
 *
 * Purpose: give students practice to (1) define classes with
 * public member variables and (2) define and implement constructors.
 *
 * YOU SHOULD NOT MODIFY THIS CODE.
 *
 * Copyright 2017 Dr. Jeffrey Paone

Permission is hereby granted, free of charge, to any person
obtaining a copy of this software and associated documentation
files (the "Software"), to deal in the Software without
restriction, including without limitation the rights to use,
copy, modify, merge, publish, distribute, sublicense, and/or
sell copies of the Software, and to permit persons to whom the
Software is furnished to do so, subject to the following
conditions:

The above copyright notice and this permission notice shall be
included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES
OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
OTHER DEALINGS IN THE SOFTWARE.
 */
/*
Author: Gage Coprivnicar
Section: A
Week: 10
Homework: Lab10A
*/
#include <iostream>
#include "Money.h"

using namespace std;

int main() {

    cout << "Who doesn't love money?" << endl << endl;

    Money myMoney;
    myMoney.setDollars(999);
    myMoney.setCents(99);
    cout << "I have $" << myMoney.getDollars() << ".";
    cout << myMoney.getCents() << endl;

    Money yourMoney(987, 65); // dollars and cents
    cout << "You have $" << yourMoney.getDollars();
    cout << "." << yourMoney.getCents() << endl;
    cout << endl;

    cout << "I have $" << (myMoney.getDollars() - yourMoney.getDollars()) << ".";
    cout << (myMoney.getCents() - yourMoney.getCents()) << " more money than you!" << endl;

    return 0;

}
