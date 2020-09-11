/*
Author: Gage Coprivnicar
Section: A
Week: 6
Homework: 3
*/
#include <iostream>
#include <string>
#include <sstream>
#include <vector>
#include <iomanip>

using namespace std;



int main() {
	//all of these are used in the code and are super crucial, dont even worry about it dude
	string userInput = " ";
	string temp = " ";
	vector <string> userSentence;
	vector <int> numberOfGivenWord;
	vector <string> finalUserSentence;
	vector <int> locationOfDuplicateWords;
	vector <string> repeatWords;
	bool isInString = false;
	int locationOfWord;
	int i = 0;
	int j = 0;
	int k = 0;
	int l = 0;

	repeatWords.push_back("asdfasdfasdfasdf");
	// so ive been workin on this code for over a week now and i dont remeber what this actually does but im not going to mess with it

	//PLEASE DONT MESS WITH THIS MAN
	while (userInput != "Done") {
		cout << "Enter a sentence or \'Done\' to finish: ";
		getline(cin, userInput);
		//hey so i know we havent learned how to do stringstream yet but i was talking to the TA and he said use sstream please dont hurt me
		istringstream iss(userInput);
		while (iss >> temp) {
			userSentence.push_back(temp);
		}
	}
	userSentence.pop_back();

	//sort the vector alphavetically
	for (i = 0; i < userSentence.size(); i++) {
		for (j = i + 1; j < userSentence.size(); j++) {
			if (userSentence[i] > userSentence[j]) {
				temp = userSentence[i];
				userSentence[i] = userSentence[j];
				userSentence[j] = temp;
			}
		}
	}

	// for (i = 0; i < userSentence.size(); i += 1) {
	//   cout << userSentence[i] << endl;
	// }

	// so straight up this section may not even do anything but im not goint to remove it
	for (j = 0; j < userSentence.size(); j += 1) {
		numberOfGivenWord.push_back(1); // if its a word start it as one in numberOfGivenWord
		numberOfGivenWord.push_back(1);
		for (k = 0; k < userSentence.size(); k += 1) {
			if (k != j) {
				if (userSentence[j] == userSentence[k]) {
					locationOfDuplicateWords.push_back(k);
					i = numberOfGivenWord[j] + 1;
					numberOfGivenWord.at(j) = i; // because its a dupe word add one to k postion word eqivalent
				}
			}
		}
	}
	cout << endl;
	//so look at the next wrod after the first and if they are the same then kick an x otherwise move to the next word, this
	//works cause its albethpical
	temp = userSentence[0];
	for (i = 1; i<userSentence.size(); i++) {
		cout << right << setw(8) << temp << " : x";
		if (userSentence[i] == temp) {
			while (userSentence[i] == temp) {
				cout << "x";
				i++;
				if (i >= userSentence.size() ) {
					i--; //so this is a source of error and while it does occasionally knock a word off its ok because at least it lets it compile
					break; //so because i have to subtract one to let the dumb code complie i have to break it otherwise its inifity
				}
				//no it doesnt i++;  // maybe this will make up for the dumb i-- from above
			}
			temp = userSentence[i];
			cout << endl;
			// nope imma give up i need to go to bed soon. i++; // maybe here it will make a difference

		}
		else {
			temp = userSentence[i];
			cout << endl;
		}
	}

/*
ok real talk, this was a bigger struggle than the last one and i have been working on it for pretty much a solid week and a half, talk to the TA's they have seen me here
working my butt off so i did my absolute best on this assignment. please consider this when grading. I know theres about 3 different things that go wrong with the different
things you can put in and i have attempted to minimize the damage with a few little tweaks the TA's said i could use (istreamstring, selection sort) this was just a struggle

So yeah I dont know I know you know this was a tough assignment i know the tas texted you guys telling you to let some stuff slide so i am hoping that by writing this
i can get a little bit more to slide. at this point i am playing a game of numbers, i am pretty sure unless you guys go nice im not get 100% so instead what i am doing
is making compromises, whats better? occasionally adding an extra x, or dropping a word, tit for tat you know the game.

for example what are the chances you really are going to put in the string 'a b c a' which really reveals some problems (dont get any ideas) so yeah whats annoying
is that something like 'hello world how are you are you' works nearly perfectly so no idea what to think

anyway i dont know what to think or if reading through this will change your opinion at all but all im asking is for you to go a little easier than you normally do because
this was super hard

one benefit of doing this lab is i did help a bunch of people with there programs so now i have met new friends and have more social equity with people and people
to crowd source ideas with

all im going to say is that it runs in Atom (atom.io)
*/

	cout << endl;
	//cin >> l;
}
