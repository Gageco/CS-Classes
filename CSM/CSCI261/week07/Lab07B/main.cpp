/*
Author: Gage Coprivnicar
Section: A
Week: 7
Homework: 2
*/
#include <iostream>

using namespace std;

//defining variables
const int LENGTH_OF_USERINPUT = 5;
int userInput[LENGTH_OF_USERINPUT];
int sortVariable01;
int sortVariable02;

//Takes two inputs, returns nothing, compares and swaps the values of the inputs
void SwapDice(int &sortVariable01, int &sortVariable02) { //works
	int temp;

	temp = sortVariable01;
	sortVariable01 = sortVariable02;
	sortVariable02 = temp;

}

//take five inputs, returns nothing, sort numbers lowers to higest (selection sort)
void SortDice(int userInput[LENGTH_OF_USERINPUT]) { //works
	int temp;

	for (int i = 0; i < LENGTH_OF_USERINPUT; i++) {
		for (int j = 0; j < LENGTH_OF_USERINPUT; j++) {
			if (userInput[i] < userInput[j]) {
				SwapDice(userInput[i], userInput[j]);
			}
		}
	}
}

int main() {
	for (int i = 0; i < LENGTH_OF_USERINPUT; i++) {
		cout << "Value for Die0" << i + 1 << ": ";
		cin >> userInput[i];
	}

	SortDice(userInput);
	cout << endl;

	 for (int i = 0; i < LENGTH_OF_USERINPUT; i++) {
	     cout << "Value for Die0" << i+1 << ": " << userInput[i] << endl;
	 }

	/*
	So it seems to me that this code doesnt actually need to output anything so everyting works and feel free to try it i just
	dont know what to output.
	*/
	 int i;
	 cin >> i;
	return 0;
}
