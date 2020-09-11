#include <iostream>
#include <fstream>

using namespace std;


void kickingOutTheResults(int array[]) {
	ofstream decipheredMessage("output.txt");
    decipheredMessage.close();
	for (int i = 0; i < 26; i++) {
		decipheredMessage.open("output.txt", ios::app);
		cout << char(i + 97) << " : " << array[i] << endl;
		decipheredMessage << char(i + 97) << " : " << array[i] << endl;
        decipheredMessage.close();
	}
    
}

//find the number of each character in the books
void getCharacters(int array[]) {
	int alphabetIntegerEquivalent;
	char c;

	for (int i = 0; i < 26; i++) {
		array[i] = 0; //removing all junk values
	}

	ifstream aliceStream("alice.txt"); // initializing the text to be read

	if (aliceStream.fail()) {
		cout << "Fatal Error: Could not load 'alice.txt'" << endl;
	}

									   //per character string transformation
	while (aliceStream.get(c)) {
		c = tolower(c);
		//cout << int(c);
		if (int(c) >= 97 && int(c) <= 122) { // making sure its acutally a letter
			alphabetIntegerEquivalent = (int)c - 97; //so i can get the letters position in the alphabet`
			array[alphabetIntegerEquivalent] += 1;
		}
	}
}

//kicking out the largest and smallest number
void letterFrequency(int array[]) {
    ofstream decipheredMessage("output.txt", ios::app);
    decipheredMessage.close();
	int largest; // for array use
	int largestLoc = 0; // location of largest number
	int smallest; // for array use
	int smallestLoc = 0; // location of smallest numbers

	largest = array[0];
	for (int i = 1; i < 26; i++) {
		if (largest < array[i]) {
			largestLoc = i;
			largest = array[i];
		}
	}

	smallest = array[0];
	for (int i = 1; i < 26; i++) {
		if (smallest > array[i]) {
			smallestLoc = i;
			smallest = array[i];
		}
	}
	decipheredMessage.open("output.txt", ios::app);
	cout << endl;
	decipheredMessage << endl;
	cout << "The most common letter is: " << char(largestLoc + 97) << endl;
	decipheredMessage << "The most common letter is: " << char(largestLoc + 97) << endl;
	cout << "The most uncommon letter is: " << char(smallestLoc + 97) << endl;
	decipheredMessage << "The most uncommon letter is: " << char(smallestLoc + 97) << endl;
    decipheredMessage.close();
}
