#include <iostream>
using namespace std;

#include <SFML/Graphics.hpp>
using namespace sf;

#include <vector>
using namespace std;

#include "bubble.h"

int main() {
    int numOfBubbles = 5; //initial number of bubbles
    vector<Bubble> secondVect;

    //setting up the vector of bubbles
	vector<Bubble> bubbleVect; 
    Bubble circle00;
    Bubble circle01;
    Bubble circle02;
    Bubble circle03;
    Bubble circle04; 
    bubbleVect.push_back(circle00);
    bubbleVect.push_back(circle01);
    bubbleVect.push_back(circle02);
    bubbleVect.push_back(circle03);
    bubbleVect.push_back(circle04);

    //setting up the intial bubble info
    for (int i = 0; i < bubbleVect.size(); i++) {
        bubbleVect[i].initBubble();
    }
    
    //copying bubble info to second vect
    for (int i = 0; i < bubbleVect.size(); i++) {
        secondVect.push_back(bubbleVect[i]);
    }
    RenderWindow window(VideoMode(640, 640), "SFML Template");
    while (window.isOpen()) {
        window.setKeyRepeatEnabled(false);
        window.clear();

        //drawing and setting bubble positions
        for (int i = 0; i < secondVect.size(); i++) {
            secondVect[i].updatePosition();
            secondVect[i].drawCircle(window);
        }

        window.display();
        Event event;
        while (window.pollEvent(event)) {
            if (event.type == Event::Closed)
                window.close();

            if (event.type == Event::MouseButtonReleased && event.mouseButton.button == Mouse::Left) { //event button clicked (add bubble)
                Bubble userBubble;
                numOfBubbles += 1;
                Vector2i position = Mouse::getPosition(window);
                userBubble = bubbleVect[numOfBubbles % 5]; //copying over old bubble info
                userBubble.setPosition(position); //copying new position to the mouse position
                secondVect.push_back(userBubble);
            }

            if (event.key.code == Keyboard::D) { //event d pressed (remove bubble)
                if (event.type == Event::KeyReleased) {
                    if (numOfBubbles == 0) {
                        numOfBubbles = 0;
                    }
                    else {
                        secondVect.pop_back();
                        numOfBubbles -= 1;

                    }
                }
            }
        }
    }

    return EXIT_SUCCESS;
}
