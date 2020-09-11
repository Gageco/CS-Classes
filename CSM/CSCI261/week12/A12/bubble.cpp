#include <iostream>
#include <ctime>
#include <random>
#include <cmath>
using namespace std;

#include <SFML/Graphics.hpp>
using namespace sf;

#include "bubble.h"

void Bubble::drawCircle(RenderWindow &window) {
    window.draw(circle);
}

void Bubble::setPosition(Vector2i vect) {
    srand(time(0));

    //user x and y
    _posX = vect.x;
    _posY = vect.y;

}

void Bubble::initBubble() {
	//Setting initial position
	_posX = rand() % 301 + 100;
	_posY = rand() % 301 + 100;
	circle.setPosition(_posX, _posY);

	//setting randomcolor
	circle.setFillColor(Color(rand() % 255, rand() % 255, rand() % 255));

	//setting radius
	circle.setRadius(rand() % 51 + 10);

	//setting delX
	_delX = static_cast <float> (rand()) / (static_cast <float> (RAND_MAX / .75));
	
	//setting delY
	_delY = static_cast <float> (rand()) / (static_cast <float> (RAND_MAX / .50));
}
 

void Bubble::updatePosition() {

	if (_posY <= 1) {
		_delY = abs(_delY);
	}

	if (_posY >= 615) {
		_delY = -_delY;
	}
	
	if (_posX <= 5) {
		_delX = abs(_delX);
	}

	if (_posX >= 600) {
		_delX = -_delX;
	}

	_posX += _delX;
	_posY += _delY;
	circle.setPosition(_posX, _posY);
}
