/* CSCI261 Lab 11A: Money Class
 *
 * Description: Implementation file for Money Class
 *
 * Author:

Author: Gage Coprivnicar
Section: A
Week: 10
Homework: Lab10A

 *
 */
 
#include "Money.h"
Money::Money() {

}
Money::Money(int d, int c) {
    dollars = d;
    cents = c;
}

void Money::setDollars(int m) {
    dollars = m;
}

int Money::getDollars() {
    return dollars;
}

void Money::setCents(int m) {
    cents = m;
}

int Money::getCents() {
    return cents;
}