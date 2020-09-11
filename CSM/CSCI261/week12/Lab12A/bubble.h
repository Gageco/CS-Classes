#pragma once

#include <SFML/Graphics.hpp>
using namespace sf;

class Bubble {
public:
    void updatePosition(CircleShape &circle);
    CircleShape makeCircle();

private:
    CircleShape circle;
    double _posX = 320;
    double _posY = 320;
    double _delY = .3;
    double _delX = .3;
};