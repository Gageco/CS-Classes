#include <iostream>
using namespace std;

#include <SFML/Graphics.hpp>
using namespace sf;

#include "bubble.h"

 CircleShape Bubble::makeCircle() {
     CircleShape circle;
     
     circle.setRadius(25);
     updatePosition(circle);
     return circle;
} 

void Bubble::updatePosition(CircleShape &circle) {
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
