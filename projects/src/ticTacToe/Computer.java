package ticTacToe;
public class Computer {

	private String sign, enemySign;
	private Board board;
	
	public Computer(String sign, String enemySign, Board board) {
		this.sign = sign;
		this.enemySign = enemySign;
		this.board = board;
	}
	
	public void turn(int turn) {
		if(blockOrWin(sign))
			return;
		else if(blockOrWin(enemySign))
			return;

		move(turn);
	}
	
	private boolean blockOrWin(String s) {
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
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
	
	private boolean move(int turn, String sign) {
		boolean result = false;
		
		if(turn < 9) {
			for(int i=0; i<3 && !result; i++) {
				for(int j=0; j<3 && ! result; j++) {
					if(board.board[i][j] != Board.DEFAULT_SIGN) {
						board.changeBoard(i, j, sign);
						
						if(sign == this.sign && board.checkBoard(sign)) {
							board.eraseSign(i, j);
							return true;
						}
						
						result = move(turn++, sign.equals(this.sign) ? enemySign : sign);
						board.eraseSign(i, j);
					}
				}
			}
		}
		
		return result;
	}
}
