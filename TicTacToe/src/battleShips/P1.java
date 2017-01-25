package battleShips;

public class P1 {
	private int row;
	private int col;
	private String sign;
	private boolean win;
	
	
	P1(String s)
	{
		this.sign = s;
		this.win = false;
	}
	
	public void setWin()
	{
		this.win = true;
	}
	
	public void setRow(int r)
	{
		this.row = r;
	}
	
	public void setCol(int c)
	{
		this.col = c;
	}
	
	public int getRow()
	{
		return this.row;
	}
	
	public int getCol()
	{
		return this.col;
	}
	
	public String getSign()
	{
		return this.sign;
	}
	
	public boolean getWin()
	{
		return this.win;
	}
}
