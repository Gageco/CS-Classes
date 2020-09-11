/*
Author  : Sunsheng Liu, Gage Coprivnicar
Section : A
Week : 2
Lab02a
*/
#include <iostream>
#include <cmath>
using namespace std;

int main() {

	double const R = 3;
	double I;
	double V;

//velocity
	float veloV;
	float veloD;
	float veloTime;

	cout << "Enter the V(voltage) : ";
	cin >> V;
	I = V / R;
	cout << "I= V / R = " << I << endl;

//Physic - Velocity
	cout << "Velocity Equation" << endl << "Distance (m): ";
	cin >> velo_d;
	cout << "Time (sec): ";
	cin >> veloTime;
	velo_v = velo_d / veloTime;
	cout << "Thank you. Using the equation \"v = d/t\" the velocity is " << velo_v << " m/s." << endl << endl;
	return 0;
}
