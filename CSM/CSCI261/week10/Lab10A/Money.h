/* CSCI261 Lab 11A: Money Class
 *
 * Description: Header file for Money Class
 *
 * Author:
 *
 */
 
#pragma once
class Money {
    public:
        void setDollars(int m);
        int dollars;
        int cents;
        int getDollars();
        int getCents();
        void setCents(int m);
        Money(int dollars, int cents);
        Money();
};
