/*
Author: Gage Coprivnicar
Section: A
Week: 
Homework: Assignment 09
*/

#include <iostream>
using namespace std;

#include <SFML/Graphics.hpp>
using namespace sf;

int main() {

    /***** PLACE YOUR FILE PROCESSING CODE HERE *****/

    /***** END OF FILE PROCESSING *****/

    // creates the window object with an 640x640 resolution window
    RenderWindow window(VideoMode(640, 640), "SFML Template");

    // Draw loop: Each iteration of this loop draws a single frame
    while (window.isOpen()) {

        // Erase the screen with black (because space)
        window.clear();

        /***** PLACE YOUR DRAWING CODE HERE *****/
        Font myFont;
        if (!myFont.loadFromFile("data\\arial.ttf"))
            return -1;
        Text label;
        label.setFont(myFont);
        label.setString("Press WASD");
        label.setPosition(250, 520);
       
        CircleShape circle;
        circle.setFillColor(Color::Red);
        circle.setRadius(100);

        RectangleShape rect00;
        rect00.setFillColor(Color::Yellow);
        rect00.setPosition(0, 100);
        rect00.setSize(Vector2f(50, 100));

        RectangleShape rect;
        rect.setFillColor(Color::Blue);
        rect.setPosition(100, 0);
        rect.setSize(Vector2f(100, 50));
        

        while (window.isOpen()) {
            Event event;
            
            for (int x = 0; x < 100; x++) {
                rect.move(0, .0001);
                rect00.move(.0001, 0);
            }

            
            while(window.pollEvent(event)) {
                

                if (event.type == Event::Closed)
                    window.close();
                if (Keyboard::isKeyPressed(Keyboard::W))
                    circle.move(0,5);
                if (Keyboard::isKeyPressed(Keyboard::A))
                    circle.move(-5, 0);
                if (Keyboard::isKeyPressed(Keyboard::S))
                    circle.move(0, -5);
                if (Keyboard::isKeyPressed(Keyboard::D))
                    circle.move(5, 0);

                
            }
               
            window.clear();
            window.draw(circle);
            window.draw(label);
            window.draw(rect);
            window.draw(rect00);
            window.display();
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
