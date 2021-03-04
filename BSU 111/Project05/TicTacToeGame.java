import java.awt.Point;

public class TicTacToeGame implements TicTacToe {
	
	private final int BOARDHEIGHT = 3;
	private final int BOARDWIDTH = 3;
	private int[][] board = new int[3][3];
	//board 2D int array has a few parameters I am defining now
	//if int = 0, no one has chosen that square
	//if int = 1, user has chosen that square
	//if int = 2, computer has chosen that squared
	
	private Point[] pointIndex = new Point[9];
	private int pointIndexCount;
	private GameState winner; 
	private BoardChoice lastPlayer;
	private int numMoves;
	
	public TicTacToeGame() {
		this.numMoves = 0;
		board = new int[BOARDWIDTH][BOARDHEIGHT];
//		noWinner = false;
		pointIndex = new Point[9];
		pointIndexCount = 0;
		winner = GameState.IN_PROGRESS;

		//Resets all ints in board to 0, the default
		for (int i = 0; i < BOARDWIDTH; i++) {
			for (int j = 0; j < BOARDHEIGHT; j++) {
				board[i][j] = 0;
			}
		}
	}
	
	@Override
	public void newGame() {
		board = new int[BOARDWIDTH][BOARDHEIGHT];
		this.numMoves = 0;
//		noWinner = false;
		pointIndex = new Point[9];
		pointIndexCount = 0;
		winner = GameState.IN_PROGRESS;

		//Resets all ints in board to 0, the default
		for (int i = 0; i < BOARDWIDTH; i++) {
			for (int j = 0; j < BOARDHEIGHT; j++) {
				board[i][j] = 0;
			}
		}
	}

	@Override
	public boolean choose(BoardChoice player, int row, int col) {
		this.numMoves++;
	//first i am checking if the game is valid
		//if game is over return false
//		System.out.println("GameState: " + getGameState());// + "    Row: " + row +"    Col: " + col + "    ID: " + board[row][col]);

		
		//No winner yet
		if (getGameState() != GameState.IN_PROGRESS) {
			return false;
		}
//		System.out.println("71 noWinner: " + noWinner + "    winner: " + winner);

		//if the square is occupied return false
		if (board[row][col] != 0) {
			return false;
		}
		//check who the last player was, and if it is the same person now, return false;
		if (player == lastPlayer) {
			return false;
		}
		
		//set the last player
		lastPlayer = player;
		
		//set the last point for getMoveIndex
		pointIndex[pointIndexCount] = new Point(row, col);
		pointIndexCount++;

	//from here everything looks good so keep going

		//check if the box checked is one that can be chosen
		
		//Check which player selected the box and modify board
		if (player == BoardChoice.X) {
			board[row][col] = 1;
		} 
		else if (player == TicTacToe.BoardChoice.O) {
			board[row][col] = 2;
		} else {
			System.out.println("Not a valid choice in TicTacToeGame, line 58");
		}
		gameOver();
		return true;
	}

	@Override
	public boolean gameOver() {
		

//		   1     2     3
//		*-----*-----*-----*
//		|     |     |     |
//		| 0,0 | 1,0 | 2,0 | top
//		|     |     |     |
//		*-----*-----*-----*
//		|     |     |     |
//		| 0,1 | 1,1 | 2,1 | mid
//		|     |     |     |
//		*-----*-----*-----*
//		|     |     |     |
//		| 0,2 | 1,2 | 2,2 | bot
//		|     |     |     |
//		*-----*-----*-----*
		
	//check all possible rows of 3 lol, i was thinking it could do it in a for loop but then i figured why?
		
	//The logic here is backwards, rows are columns and the columns are rows, it still works but just backwards
		//Check top row
		if (board[0][0] == board[1][0] && board[0][0] == board[2][0] && board[0][0] != 0) {
			this.winner = translate(0,0);
			
//			System.out.println("========Butts===============\nTranslated " + board[0][0] + " to " + this.winner);
//			System.out.println(" winner: " + winner);

			
			return true;
		} 
		//check mid row
		if (board[0][1] == board[1][1] && board[0][1] == board[2][1] && board[0][1] != 0) {
			this.winner = translate(0,1);
			System.out.println("=======================\\nTranslated " + board[0][1] + " to " +winner);

			return true;
		}
		//check bot row
		if (board[0][2] == board[1][2] && board[0][2] == board[2][2] && board[0][2] != 0) {
			this.winner = translate(0,2);
//			System.out.println("=======================\\nTranslated " + board[0][2] + " to " + winner);

			return true;
		}
		//check col 1
		if (board[0][0] == board[0][1] && board[0][0] == board[0][2] && board[0][0] != 0) {
			this.winner = translate(0,0);
//			System.out.println("=======================\\nTranslated " + board[0][0] + " to " + winner);

			return true;
		}
		//check col 2
		if (board[1][0] == board[1][1] && board[1][0] == board[1][2] && board[1][0] != 0) {
			this.winner = translate(1,0);
//			System.out.println("=======================\\nTranslated " + board[1][0] + " to " + winner);
			
			return true;
		}
		//check col 3
		if (board[2][0] == board[2][1] && board[2][0] == board[2][2] && board[2][0] != 0) {
			this.winner = translate(2,0);
//			System.out.println("=======================\\nTranslated " + board[2][0] + " to " + winner);
			
			return true;
		}
		//check diagonal top left -> bottom right
		if (board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[0][0] != 0) {
			this.winner = translate(0,0);
//			System.out.println("=======================\\nTranslated " + board[0][0] + " to " + winner);
			
			return true;
		}
		//check diagonal top right -> bottom left
		if (board[2][0] == board[1][1] && board[2][0] == board[0][2] && board[2][0] != 0) {
			this.winner = translate(2,0);
//			System.out.println("=======================\\nTranslated " + board[2][0] + " to " + winner);
			
			return true;
		}

		//check if all squares are filled

		if (numMoves == 9) {
			this.winner = GameState.TIE;
			return true;
		}


		//If you are here all squares have been filled up, game is over
//		noWinner = true;
		return false;
		
	}

	@Override
	public GameState getGameState() {
//		System.out.println( "    winner: " + winner);
		//if there is no winner, all squares filled
		return winner;
	}

	@Override
	public BoardChoice[][] getGameGrid() {
		return translate();
	}

	@Override
	public Point[] getMoves() {
//		System.out.println(pointIndex[0].toString() + ", Size: " + pointIndex.length);
		
		Point[] passingPointIndex = new Point[pointIndexCount];
		for (int i = 0; i < passingPointIndex.length; i++) {
			passingPointIndex[i] = pointIndex[i];
		}
//		System.out.println(passingPointIndex[0].toString() + ", Size: " + passingPointIndex.length);
		return passingPointIndex;
	}
	
	private BoardChoice[][] translate() {
		BoardChoice[][] dumbBoard = new BoardChoice[BOARDWIDTH][BOARDHEIGHT];
		
		//translate from my int board array to the BoardChoice array. I don't like the BoardChoice array to many letters 
		//if int = 0, OPEN
		//if int = 1, X
		//if int = 2, O
		for (int i = 0; i < BOARDWIDTH; i++) {
			for (int j = 0; j < BOARDHEIGHT; j++) {
				if (board[i][j] == 0) {
					dumbBoard[i][j] = BoardChoice.OPEN;
				} else if (board[i][j] == 1) {
					dumbBoard[i][j] = BoardChoice.X;
				} else if (board[i][j] == 2) {
					dumbBoard[i][j] = BoardChoice.O;
				}
			}
		}
		
		return dumbBoard;
	}
	
	private GameState translate(int i, int j) {		
		//translate from my int board array to the BoardChoice array. I don't like the BoardChoice array to many letters 
		//if int = 0, OPEN
		//if int = 1, X
		//if int = 2, O
		if (board[i][j] == 0) {
			
			return GameState.IN_PROGRESS;
		}  
		if (board[i][j] == 1) {
			return GameState.X_WON;
		} 
		if (board[i][j] == 2) {
			return GameState.O_WON;
		}
		System.out.println("Error In TicTacToeGame Line 108, all choices should be accounted for");
		return null;

		
	}

}

