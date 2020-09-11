#pragma once
class Riddle {
public:
    string getRiddle(int num);
    bool checkRiddleAns(string ans);
    void intro();
    string getPrize();
private:
    void riddle1();
    void riddle2();
    void riddle3();
    string _riddleAns;
    string _riddlePrize;
    string _riddleQues;

};