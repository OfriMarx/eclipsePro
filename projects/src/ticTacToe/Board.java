package ticTacToe;
import java.util.Scanner;

public class Board {

	private static Scanner in = new Scanner(System.in);
	
	public String[][] board = new String[3][3]; 
	
	public Board() {
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++)
				board[i][j] = "-";
		}
	}
	
	/**
	 * Returns false if out of range and true otherwise
	 */
	private boolean checkRange(int r, int c) {
		if(r > 2 || r < 0 || c > 2 || c < 0)
			return false;
		else
			return true;
	}
	
	/**
	 * Prints the board
	 */
	public void printBoard() {
		for(int i=0; i<3; i++)
		{
			for(int j=0; j<3; j++)
				System.out.print(board[i][j] + " ");
			
			System.out.println("");
		}
	}
	
	/**
	 * Changes a given location in the board to a given String
	 */
	public void changeBoard(int r, int c, String sign) {
		while(!checkRange(r, c) || !board[r][c].equals("-")) {
			System.out.println("Place taken or out of range. Enter a different location");
			r = in.nextInt()-1;
			c = in.nextInt()-1;
		}
		
		board[r][c] = sign;
	}
	
	public void eraseSign(int r, int c) {
		board[r][c] = "-";
	}
	
	/**
	 * Checks if the game has ended
	 */
	public boolean checkBoard(String sign) {
		String str;
		
		for(int i=0; i<3; i++) {
			str = "";
			for(int j=0; j<3; j++)
				str += board[i][j];
			
			if(str.equals(sign + sign + sign))
				return true;
		}
		
		for(int i=0; i<3; i++) {
			str = "";
			for(int j=0; j<3; j++)
				str += board[j][i];
			
			if(str.equals(sign + sign + sign))
				return true;
		}
		
		str = "";
		for(int i=0; i<3; i++)
			str += board[i][i];
		
		if(str.equals(sign + sign + sign))
			return true;
		
		str = "";
		for(int i=0; i<3; i++)
			str += board[i][2-i];
		
		if(str.equals(sign + sign + sign))
			return true;
		
		return false;
	}

}
