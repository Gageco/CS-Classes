#include <iostream>
#include <string>
#include <time.h>
#include <stdlib.h>
#include <vector>
#include <Windows.h>
#include <fstream>
using namespace std;

#include <SFML/Graphics.hpp>
using namespace sf;

#include "classes.h"

void Coin::updateWindow(RenderWindow& window, int tradesLeft) const { //basic stuff that updates the window and the sfml stuff
    string textToShow = "Total Value : $" + to_string((int)moneyMade[moneyMade.size() - 1]) + "\n" + "Trades left: " + to_string(tradesLeft);
    
    Font myFont;
    myFont.loadFromFile("data/arial.ttf");
    Text text;
    text.setFont(myFont);
    text.setPosition(50, 50);
    text.setCharacterSize(15);
    text.setString(textToShow);

    if (tradesLeft <= 0) {
        textToShow += "\n The Program has made you $" + to_string((int)moneyMade[moneyMade.size() - 1] - (int)maxFunds);
        text.setString(textToShow);
    }

    window.draw(text);

    for (int i = (moneyMade.size() - 215); i < moneyMade.size(); i++) {
        RectangleShape rect;
        rect.setSize(Vector2f((float)3, (float)moneyMade[i]/8));
        rect.setOrigin(3*(i-214), 640);
        rect.setRotation(180);

        if (moneyMade[i] > moneyMade[i - 1]) {
            rect.setFillColor(Color::Green);
        }
        if (moneyMade[i] <= moneyMade[i-1]) {
            rect.setFillColor(Color::Red);
        }

        window.draw(rect);
    }
}

void Coin::logActions() { //logs the stuff to the file
    ofstream logFile("log.txt", ios::app);
    logFile.close();
    
    //logs stuff to the file
    logFile.open("log.txt", ios::app);
    if (logFile.fail()) {
        cout << "Something went wrong when logging the info requested, skipping" << endl;
    }
    else {
        logFile << time(NULL) << ": ";
        logFile << lastAction << endl;
    }
}

void Coin::defineTypeOfCoin() { //gives user ability to choose what coin they want to trade
    bool keepRepeatingLoop = true;
    int userTrading;
    while (keepRepeatingLoop) {
        cout << "Would you like to trade 0: BTC or 1: ETH?: ";
        cin >> userTrading;
        switch (userTrading) {
        case 0:
            coinType = "btc";
            keepRepeatingLoop = false;
            break;
        case 1:
            coinType = "eth";
            keepRepeatingLoop = false;
            break;
        default:
            cout << "Sorry not a valid option, try again" << endl;
            keepRepeatingLoop = true;
        }
    }
    lastAction = "Trading with " + coinType;
    logActions();
}

void Coin::getNewPrice() {
    if (trading) {
        ; //json junk
    }

    if (!trading) {
        priceVect.push_back(generateNumbers());
    }
}

void Coin::displayInformation() { //if necessary this displays the information that is generated to check values
    //showing priceVect
    cout << "priceVect: " << endl;
    for (int i = 0; i < priceVect.size(); i++) {
        cout << priceVect[i] << ", ";
    }
    cout << endl;
    cout << "usableMoney: " << usableMoney << endl;
    cout << "amountOfCoin: " << amountOfCoin << endl;
    cout << "maxFunds: " << maxFunds << endl;
}

void Coin::stoppingTheProgram(RenderWindow& window) { //this is the final thing that runs after the number of trades is over
    lastAction = "The program has made you $" + to_string(moneyMade[moneyMade.size() - 1] - maxFunds) + " with an initial investment of $" + to_string(maxFunds) + ". That is a " + to_string((moneyMade[moneyMade.size() - 1] - maxFunds) / maxFunds) + "% increase!";
    logActions();
    updateWindow(window, 0);
    updateWindow(window, 0);
    updateWindow(window, 0);
    updateWindow(window, 0);
    Sleep(5500);

}

void Coin::init() {
    if (trading) {
        ; //this would be the way to get json and stuff but i dont know how to use cURL and JSON
    }
    if (!trading) {
        for (int i = 0; i < 13; i++) { //adds twelve random numbers to vector
            priceVect.push_back(generateNumbers());
        }
    }
    for (int i = 0; i < 215; i++) {
        moneyMade.push_back(0);
    }
    moneyMade.push_back(maxFunds);
}

void Coin::defineAmountOfFunds() {
    cout << "How much are you trading with today? (Recommended 100-300): ";
    cin >> maxFunds;
    usableMoney = maxFunds;
    lastAction = "Trading with $" + to_string(maxFunds);
    logActions();
    
}

//MISC FUCNTIONS
int Coin::generateNumbers() {
    return rand() % 10 + 40; //should return numbsers between 40 and 50
}
void Coin::defineTypeOfTrading() {
    bool keepRepeatingLoop = true;
    int userTrading;
   /* while (keepRepeatingLoop){
        cout << "Would you like to trade with 0:real numbers or 1:generated numbers?: ";
        cin >> userTrading;
        switch (userTrading) {
        case 0:
            trading = true;
            keepRepeatingLoop = false;
            lastAction = "Trading using real numbers";
            break;
        case 1:
            trading = false;
            keepRepeatingLoop = false;
            lastAction = "Trading using generated numbers";
            break;
        default:
            cout << "Sorry not a valid option, try again" << endl;
            keepRepeatingLoop = true;
        }
    }
    logActions();*/
    //so i spent like 3hrs trying to figure curl and json and stuff but couldnt trading with real numbers is out of the question.
    //an explanation
    cout << "This program generates numbers and based on these numbers it will either buy or sell a certain number of times. It buys low and sells high and attempts to make you money. This information is then displayed and logged." << endl << endl;
}

void Coin::percentChange(int& trades) { //this is the thing that starts and kicks off the deciding whether to buy or sell or hold
    int vectorSize = priceVect.size();
    int timeInterval = 12; //amount of time to look at, in this case twelve, five min segments totalling an hour
    int lowerEndX = vectorSize - timeInterval;
    double nowPrice;
    double lastPrice;
    double percentChangeInPrice;

    for (int i = lowerEndX; i < vectorSize; i++) {
        nowPrice = priceVect[vectorSize - 1];
        lastPrice = priceVect[i];

        percentChangeInPrice = double(double(nowPrice) - double(lastPrice)) / double(nowPrice);

        if (percentChangeInPrice >= .008) { //.8% up sell
            sell();
            break;
        }
        if (percentChangeInPrice <= -.007) { //.7down buy
            trades -= 1;
            buy();
            break;
        }
    }

}

//BUYING FUNCTIONS
void Coin::buy() { //this would also have the json stuff but i dont know how to oce again
    double toBuy = howMuchToBuy();
    amountOfCoin += toBuy;
}

double Coin::howMuchToBuy() {
    double moneyBuy;
    double coinBuy;
    
    if ((usableMoney >= maxFunds*(double(.05)))) {
        moneyBuy = .2*usableMoney;
        coinBuy = moneyBuy / priceVect[priceVect.size() - 1];
        cout << "Buying " << coinBuy << " " << coinType << " for $" << moneyBuy << " at " << priceVect[priceVect.size() - 1] << " per" << endl;
        lastAction = "Buying " + to_string(coinBuy) + " " + coinType + " for $" + to_string(moneyBuy) + " at " + to_string(priceVect[priceVect.size() - 1]) + " per coin";
        usableMoney -= moneyBuy;
        return coinBuy;
    }
    else {
        cout << "Not enough funds to buy " << coinType << " with" << endl;
        lastAction = "Not enough funds to buy " + coinType + " with";
        return 0;
    }
}

//SELLING FUNCTIONS
void Coin::sell() { //basic sell function
    double toSell;
        toSell = howMuchToSell();
        if (toSell == 0) {
            cout << "Not selling at profit" << endl;
            lastAction = "Not selling at profit";
        }
        else {
            cout << "Selling " << toSell << " " << coinType << endl;
            lastAction = "Selling " + to_string(toSell) + coinType;
            double usdSellPrice = priceVect[priceVect.size() - 1] * toSell;
            usableMoney += usdSellPrice;
            moneyMade.push_back(usableMoney);
        }
}


double Coin::howMuchToSell() { //sells all the coin
    double coinSell = 0;
    double toReturn;
    vector<double> tempVect;
    if (priceVect[priceVect.size() - 1] > averageBuyingPrice*1.005) {
        toReturn = amountOfCoin;
        amountOfCoin = 0; //because its selling it all
        return toReturn;
    }
    else {
        return 0;
    }
}
