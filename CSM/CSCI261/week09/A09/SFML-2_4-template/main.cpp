/*
Author: Gage Coprivnicar
Section: A
Week: 
Homework: Assignment 09
*/
#include"Header.h"
#include <string>

#include <iostream>
using namespace std;

#include <SFML/Graphics.hpp>
using namespace sf;

string charToString(char c) {
    string s;
    s.push_back(c);
    return s;
}


int main() {

    /***** PLACE YOUR FILE PROCESSING CODE HERE *****/
    const int LENGTH = 26;
    int alphabetArray[LENGTH];

    getCharacters(alphabetArray);
    kickingOutTheResults(alphabetArray);
    letterFrequency(alphabetArray);
    /***** END OF FILE PROCESSING *****/
    

    // creates the window object with an 640x640 resolution window
    RenderWindow window(VideoMode(640, 640), "SFML Template");

    // Draw loop: Each iteration of this loop draws a single frame
    while (window.isOpen()) {

        // Erase the screen with black (because space)
        window.clear();

        /***** PLACE YOUR DRAWING CODE HERE *****/
        const int WINDOW_HEIGHT = 640;
        int barHeight;
        int barLocation;
        char myChar;
        Font myFont;
        string textColor = "";
        myFont.loadFromFile("data/arial.ttf");
        for (int i = 0; i < LENGTH; i++) {

            RectangleShape bar;
            Text text;
            barHeight = (alphabetArray[i])/(WINDOW_HEIGHT/15);
            barLocation = 24 * (i+1);
            bar.setSize(Vector2f((float)24, (float)barHeight));
            bar.setPosition(Vector2f((float)barLocation, (float)0));
            bar.setOrigin(0, WINDOW_HEIGHT);
            bar.setRotation(180);
            if (false) {
                cout << "TEST";
            }
            else if (i + 97 == 101) {
                bar.setFillColor(Color::Green);
            }
            else if (i + 97 == 122) {
                bar.setFillColor(Color::Yellow);
            }
            else {
                bar.setFillColor(Color::White);
            }

            text.setPosition(Vector2f((float)barLocation-20, (float)WINDOW_HEIGHT-20));
            text.setString(charToString((char)(i + 97)));
            text.setCharacterSize(15);
            text.setFillColor(Color::Blue);
            text.setFont(myFont);

            
            
            
            window.draw(bar);
            window.draw(text);
        }



        /***** END OF DRAWING	*****/

        // Apply all the draws to the screen
        window.display();

        Event event;
        while (window.pollEvent(event)) {
            if (event.type == Event::Closed)
                window.close();
        }
    }

    return EXIT_SUCCESS;
}
