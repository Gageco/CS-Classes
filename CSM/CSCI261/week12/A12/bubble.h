#pragma once

#include <SFML/Graphics.hpp>
using namespace sf;

#include <vector>
using namespace std;

class Bubble {
public:
	void initBubble();
    void setPosition(Vector2i vect);
    void updatePosition();
    void drawCircle(RenderWindow &window);

private:
    CircleShape circle;
    double _posX;
    double _posY;
	double _delX;
	double _delY;
};