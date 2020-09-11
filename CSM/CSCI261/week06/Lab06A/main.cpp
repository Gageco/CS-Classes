/*
Author: Gage Coprivnicar
Section: A
Week: 6
Homework: 1
*/
#include <iostream>
using namespace std;

int main() {
  //setting variables
  const int MATRIX_ROW = 4;
  const int MATRIX_COLUMN = 3;

  int largestMatrixSide;
  int i;
  int j;
  int k;
  int l;
  int numStorage;

  if (MATRIX_ROW >= MATRIX_COLUMN) {
    largestMatrixSide = MATRIX_ROW;
  }
  else {
    largestMatrixSide = MATRIX_COLUMN;
  }

  int finalMatrix[MATRIX_ROW][MATRIX_ROW];
  int theInverseMatrix[MATRIX_COLUMN][MATRIX_ROW];
  int theMatrix[MATRIX_ROW][MATRIX_COLUMN];// = {{5, 5, 5}, {1, 2, 3}, {10, 2, 4}, {2, 2, 2}};
  //{{a1, a2, a3}, {b1, b2, b3}, {c1, c2, c3}, {d1, d2, d3}}
  //{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}}
  // [ a1, a2, a3 ]
  // [ b1, b2, b3 ]
  // [ c1, c2, c3 ]
  // [ d1, d2, d3 ]

//user inputs junk
  for (i=0; i < MATRIX_ROW; i+=1) {
    for (j=0; j < MATRIX_COLUMN; j+=1) {
      cout << "Enter Row " << i+1 << " Column " << j+1 << ": ";
      cin >> theMatrix[i][j];
      //cout << theMatrix[i][j] << endl;
    }
  }
//kicking out the matrix as it was put in
cout << "The matrix you entered is:" << endl;
for (i=0; i < MATRIX_ROW; i+=1) {
  cout << "[ ";
  for (j=0; j < MATRIX_COLUMN; j+=1) {
    if (theMatrix[i][j] <= 9) {
      cout << " " << theMatrix[i][j] << " ";
    }
    else {
      cout << theMatrix[i][j] << " ";
    }
  }
  cout << "]" << endl;
}

//moving info from the matrix to the transpose matrix
for (i=0; i < MATRIX_ROW; i+=1) {
  for (j=0; j < MATRIX_COLUMN; j+=1) {
    theInverseMatrix[j][i] = theMatrix[i][j];
    //cout << "Inverse: " << theInverseMatrix[j][i] << endl << "Matrix: " << theMatrix[i][j] << endl;
  }
}
//kicking out the transpose matrix
cout << endl << "The transpose of the matrix you made is:" << endl;
for (i=0; i < MATRIX_COLUMN; i+=1) {
  cout << "[ ";
  for (j=0; j < MATRIX_ROW; j+=1) {
    if (theInverseMatrix[i][j] <= 9) {
      cout << " " << theInverseMatrix[i][j] << " ";
    }
    else {
      cout << theInverseMatrix[i][j] << " ";
    }
  }
  cout << "]" << endl;
}


cout << endl;
// [ a1, a2, a3 ] theMatrix
// [ b1, b2, b3 ]
// [ c1, c2, c3 ]
// [ d1, d2, d3 ]
// *
// [ a1, b1, c1, d1 ] theInverseMatrix
// [ a2, b2, c2, d2 ]
// [ a3, b3, c3, d3 ]
// =
// [a1a1 + a2a2 + a3a3, a1b1 + a2b2 + a3b3, a1c1 + a2c2 + a3c3, a1d1 + a2d2 + a3d3 ]
// [b1a1 + b2a2 + b3a3, b1b1 + b2b2 + b3b3, b1c1 + b2c2 + b3c3, b1d1 + b2d2 + b3d3 ]
// [c1a1 + c2a2 + c3a3, c1b1 + c2b2 + c3b3, c1c1 + c2c2 + c3c3, c1d1 + c2d2 + c3d3 ]
// [d1a1 + d2a2 + d3a3, d1b1 + d2b2 + d3b3, d1c1 + d2c2 + d3c3, d1d1 + d2d2 + d3d3 ]

//figuring out how to do the multiplication thing
cout << "The product of the matrix is:" << endl;
for (k=0; k < MATRIX_ROW ; k+=1){
  cout << "[ ";
  for (i=0; i < MATRIX_ROW; i+=1) { //for theMatrix
    for (j=0; j < MATRIX_COLUMN; j+=1) { //for theMatrix
      numStorage = numStorage + (theMatrix[k][j] * theInverseMatrix[j][i]);
      //cout << theMatrix[k][j]  *  theInverseMatrix[j][i] << " + ";
      //cout << "=" << numStorage;
    }
    cout << numStorage;
    numStorage = 0;
    cout << " ";
  }
  cout << " ]" << endl;
}




}
