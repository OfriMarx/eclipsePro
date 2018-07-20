package ticTacToe;
public class Computer {

	private String sign, enemySign;
	private Board board;
	
	public Computer(String sign, String enemySign, Board board) {
		this.sign = sign;
		this.enemySign = enemySign;
		this.board = board;
	}
	
	public int turn() {
		if(blockOrWin(sign))
			return 0;
		else if(blockOrWin(enemySign))
			return 0;
		
		move();
		
		return 0;
	}
	
	private int move() {
		if(board.board[1][1] == "-")
		{
			board.changeBoard(1, 1, sign);
			return 0;
		}
		
		for(int i=0; i<3; i++)
		{
			for(int j=0; j<3; j++)
			{
				if(board.board[i][j] == "-" && (Math.abs(i-j) == 2 || Math.abs(i-j) == 0))
				{
					board.changeBoard(i, j, sign);
					return 0;
				}
			}
		}
		randomMove();
		return 0;
	}
	
	private void randomMove() {
		int n1 = (int)(Math.random() * 3), n2 = (int)(Math.random() * 3);
		
		while(board.board[n1][n2] != "-")
		{
			n1 = (int)(Math.random() * 3);
			n2 = (int)(Math.random() * 3);
		}
		board.changeBoard(n1, n2, sign);
	}
	
	private boolean blockOrWin(String s) {
		for(int i=0; i<3; i++)
		{
			for(int j=0; j<3; j++)
			{
				if(board.board[i][j] != "-")
					continue;
										
				board.changeBoard(i, j, s);
				if(board.checkBoard(s))
				{
					board.eraseSign(i, j);
					board.changeBoard(i, j, sign);
					return true;
				}
				else
					board.eraseSign(i, j);
			}
		}
		
		return false;
	}
}
