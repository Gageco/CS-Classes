#include <iostream>
#include <string>
#include <time.h>
#include <stdlib.h>
#include <vector>
#include <Windows.h>
using namespace std;

#include <SFML/Graphics.hpp>
using namespace sf;


#include "classes.h"

int main() {
    Coin start;
    int trades;

    //i can probably consolidate these
    start.defineTypeOfTrading();
    start.defineAmountOfFunds();
    start.defineTypeOfCoin();
    start.init();
    cout << "How many times would you like to trade? (Recommended 200-400): ";
    cin >> trades;
    srand(time(NULL));
    
    RenderWindow window(VideoMode(640, 640), "SFML Template");
    while (window.isOpen()) {

        window.clear();
        start.percentChange(trades); //buys and sells according to price
        //start.displayInformation();//a temp thing to show the information the program is using and generating
        start.getNewPrice(); //gets the most recent price 
        start.logActions(); //logs anything done by the program,

        start.updateWindow(window, trades);
        window.display();
        if (trades <= 0) {
            start.stoppingTheProgram(window);
            return EXIT_SUCCESS;
        }
        Sleep(200); //default is 500000 for five mins, for 3secs use 3000
        Event event;
        while (window.pollEvent(event)) {
            if (event.type == Event::Closed)
                window.close();
        }
    }

    return EXIT_SUCCESS;
}
