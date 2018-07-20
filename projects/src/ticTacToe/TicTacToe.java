package ticTacToe;
import java.util.Scanner;

public class TicTacToe {

	private static Board board; 
	public static int turns = 1;
	private static String sign = "O";
	
	private static Scanner in = new Scanner(System.in);
	
	/**
	 * Player versus Player game mode
	 */
	public static void PVP() {
		while(true)
		{
			if(sign == "X")
				sign = "O";
			else
				sign = "X";
			
			System.out.println("<---------------------------->");
			System.out.println("turn " + turns);
			System.out.println(sign + "'s turn");
			System.out.println("");
			System.out.println("Enter row and column number");
			board.printBoard();
			
			board.changeBoard(in.nextInt()-1, in.nextInt()-1, sign);
			
			if(board.checkBoard(sign))
				break;
				
			turns++;
			
			if(turns > 9)
				break;
		}
	}
	
	public static void PVC() {
		Computer computer = new Computer("O", "X", board);
		
		while(true)
		{
			if(sign == "X")
				sign = "O";
			else
				sign = "X";
			
			System.out.println("<---------------------------->");
			System.out.println("turn " + turns);
			System.out.println(sign + "'s turn");
			System.out.println("");
			System.out.println("Enter row and column number");
			board.printBoard();
			
			if(sign == "X")
				board.changeBoard(in.nextInt()-1, in.nextInt()-1, sign);
			else
				computer.turn();
			
			if(board.checkBoard(sign))
				break;
				
			turns++;
			
			if(turns > 9)
				break;
		}
	}
	
	public static void main(String[] args) {
		board = new Board();
		
		System.out.println("Enter preffered game mode(1/2)");
		if(in.nextInt() == 1)
			PVP();
		else
			PVC();
		
		System.out.println("");
		board.printBoard();
		System.out.println("");
		
		if(turns > 9)
			System.out.println("TIE");
		else
			System.out.println(sign + " WON");
	}

}
