#include <iostream>
using namespace std;

#include <SFML/Graphics.hpp>
using namespace sf;

#include "bubble.h"

int main() {
    RenderWindow window(VideoMode(640, 640), "SFML Template");


    Bubble bubble00;
    CircleShape circle;

    while (window.isOpen()) {
        window.clear();
       
        circle = bubble00.makeCircle();
        window.draw(circle);


        window.display();
        Event event;
        while (window.pollEvent(event)) {
            if (event.type == Event::Closed)
                window.close();
        }
    }

    return EXIT_SUCCESS;
}
