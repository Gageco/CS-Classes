#pragma once
class Triangle {
public:
    Triangle();
    Triangle(int a, int b, int c);
    void optionOne();
    void optionTwo();
    void validate();
    void optionFour();
    float optionFive();
    float optionSix();

private:
    float _side01;
    float _side02;
    float _side03;
    bool isTriangle;
};