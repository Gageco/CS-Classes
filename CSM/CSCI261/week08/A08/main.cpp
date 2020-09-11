/*
Author: Gage Coprivnicar
Section: A
Week: 8
Homework: Assignment 08
*/

#include <iostream>
#include <fstream>
#include "Header.h"

using namespace std;

//main
int main() {
	const int LENGTH = 26;
	int alphabetArray[LENGTH];

	getCharacters(alphabetArray);
	kickingOutTheResults(alphabetArray);
	letterFrequency(alphabetArray);
}
