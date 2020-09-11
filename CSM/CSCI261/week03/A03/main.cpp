/*
Author: Gage Coprivnicar
Section: A
Week: 3
Homework 3
*/
#include <iostream>
#include <cstdlib>
#include <ctime>
#include <ios>
#include <iomanip>
#include <string>
using namespace std;

int main() {
  char userInput;
  char compInput;
  int compInt;
  int winner = 3; //1 is computer 0 is user 2 is if tie and 3 is something is wrong
  string winItem;
  string loseItem;

  srand(time(0));

  cout << "Welcome one and all to a round of Rock, Paper, Scissors, Lizard, Spock! (Enter p, r, s, l, or k)" << endl << "User Input: ";
  cin >> userInput;

  compInt = rand() % 5;
//defining computers through
  if (compInt == 0) {
    compInput = 'r';
  }
  if (compInt == 1) {
    compInput = 'p';
  }
  if (compInt == 2) {
    compInput = 's';
  }
  if (compInt == 3) {
    compInput = 'l';
  }
  if (compInt == 4) {
    compInput = 'k';
  }

//start defining what can beat what in a situation
if (userInput == 'r') { //rock
  if (compInput == 'p') { //paper > rock
    winner = 1;
    winItem = "paper";
    loseItem = "rock";
  }
  else if (compInput == 'k') { //spock > rock
    winner = 1;
    winItem = "spock";
    loseItem = "rock";
  }
  else if (compInput == 'l') { // rock > lizard
    winner = 0;
    winItem = "rock";
    loseItem = "lizard";
  }
  else if (compInput == 's') { // rock > scissors
    winner = 0;
    winItem = "rock";
    loseItem = "scissors";
  }
  else {
    winner = 2;
  }
}

if (userInput == 'p') { //paper
  if (compInput == 's') {//scissors > paper
    winner = 1;
    winItem = "scissors";
    loseItem = "paper";
  }
  else if (compInput == 'l') {//lizard > paper
    winner = 1;
    winItem = "lizard";
    loseItem = "paper";
  }
  else if (compInput == 'r') { //paper > rock
    winner = 0;
    winItem = "paper";
    loseItem = "rock";
  }
  else if (compInput == 'k') { //paper > spock
    winner = 0;
    winItem = "paper";
    loseItem = "spock";
  }
  else {
    winner = 2;
  }
}

if (userInput == 's') { //scissors
  if (compInput == 'k') { //spock > scissors
    winner = 1;
    winItem = "spock";
    loseItem = "scissors";
  }
  else if (compInput == 'r') { //rock > scissors
    winner = 1;
    winItem = "rock";
    loseItem = "scissors";
  }
  else if (compInput == 'p') { //scissors > paper
    winner = 0;
    winItem = "scissors";
    loseItem = "paper";
  }
  else if (compInput == 'l') { //scissors > lizard
    winner = 0;
    winItem = "scissors";
    loseItem = "lizard";
  }
  else {
    winner = 2;
  }
}

if (userInput == 'l') { //lizard
  if (compInput == 'r') {//rock > lizard
    winner = 1;
    winItem = "rock";
    loseItem = "lizard";
  }
  else if (compInput == 's') {//scissors > lizzard
    winner = 1;
    winItem = "scissors";
    loseItem = "lizard";
  }
  else if (compInput == 'p') { //lizard > paper
    winner = 0;
    winItem = "lizard";
    loseItem = "paper";
  }
  else if (compInput == 'k') { //lizard > spock
    winner =0;
    winItem = "lizard";
    loseItem = "spock";
  }
  else {
    winner = 2;
  }
}

if (userInput == 'k') { //spock
  if (compInput == 'l') {//lizard > spock
    winner = 1;
    winItem = "lizard";
    loseItem = "spock";
  }
  else if (compInput == 'p') {//paper > spock
    winner = 1;
    winItem = "paper";
    loseItem = "spock";
  }
  else if (compInput == 'r') { //spock > paper
    winner = 0;
    winItem = "spock";
    loseItem = "paper";
  }
  else if (compInput == 's') { //spock > scissors
    winner = 0;
    winItem = "spock";
    loseItem = "scissors";
  }

  else {
    winner = 2;
  }
}

cout << "Computer: " << compInput << endl;
if (winner == 0) {
  cout << winItem << " beats " << loseItem << ". You win!" << endl;
}
else if (winner == 1) {
  cout << winItem << " beats " << loseItem << ". The computer wins, sorry :(." << endl;
}
else if (winner == 2) {
  cout << "Looks like there was a tie! Try again." << endl;
}
else if (winner == 3) {
  cout << "Looks like thats an invalid input, try again" << endl;;
}

  return 0;
}
