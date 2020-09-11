/*
Author: Gage Coprivnicar
Section: A
Week: 8
Homework: Lab08B
*/

#include <iostream>
#include <fstream>

using namespace std;

int main() {
char c;
char outputChar;

ifstream secretMessage("secretMessage.txt");
ofstream decipheredMessage("decipheredMessage.txt");
decipheredMessage.close();

while (secretMessage.get(c)) {
  if (c == 126) {
    //cout << " ";
    outputChar = 32; //space
  }

  else if (c == 10) {
    //cout << endl;
    outputChar = 10; // endl
  }

  else {
    //cout << char(c+1);
    outputChar = char(c+1); //character+1
  }

  decipheredMessage.open("decipheredMessage.txt", ios::app);
  if (decipheredMessage.fail()) {
    cout << "Something happened, a bit complicated to explain, dont worry about it, just rerun" << endl;
  }
  decipheredMessage << outputChar;
  decipheredMessage.close();

}





}
