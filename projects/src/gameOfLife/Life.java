package gameOfLife;

public class Life {

	public static int SIZE = 40;
	private static String[][] cells = new String[SIZE+2][SIZE+2];
	private static String[][] previousGen = new String[SIZE+2][SIZE+2];
	private static int genNum = 1;
	
	public static String[][] fill_arr(String [][] arr, String shape)
	{
		for(int i=0; i<SIZE+2; i++)
		{
			for(int k=0; k<SIZE+2; k++)
				arr[i][k] = "0";
		}
		
		return arr;
	}
	
	public static void print_arr(String[][] arr, int gen)
	{
		System.out.println("gen " + gen);
		
		for(int i=1; i<SIZE+1; i++)
		{
			for(int k=1; k<SIZE+1; k++)
			{
				if(k==SIZE)
					if(arr[i][k] == "1")
						System.out.println("* ");
					else
						System.out.println("- ");
				else
					if(arr[i][k] == "1")
						System.out.print("* ");
					else
						System.out.print("- ");
			}
			if(i==SIZE)
				System.out.println(" ");
		}
	}
	
	public static int numOfNeighbors(int x, int y, String[][] old_arr)
	{
		int count = 0;
		for(int i=-1; i<2; i++)
		{
			for(int k=-1; k<2; k++)
			{
				if(i == 0 && k == 0)
					continue;
				if(old_arr[x+i][y+k] == "1")
					count++;
			}
		}
		
		return count;
	}
	
	public static String[][] next_gen(String[][] old_arr)
	{
		genNum++;
		int count = 0;
		String[][] new_arr = new String[SIZE+2][SIZE+2];
		
		for(int i=0; i<SIZE+2; i++)
		{
			for(int k=0; k<SIZE+2; k++)
			{
				new_arr[i][k] = old_arr[i][k];
				previousGen[i][k] = old_arr[i][k];
			}
		}
		
		for(int i=1; i<SIZE+1; i++)
		{
			for(int k=1; k<SIZE+1; k++)
			{
				count = numOfNeighbors(i, k, old_arr);
				
				if(old_arr[i][k] == "1")
				{
					
					if(count > 3)
						new_arr[i][k] = "0";
					else if(count < 2)
						new_arr[i][k] = "0";
					
				}
				else if(count == 3)
					new_arr[i][k] = "1";
				
			}
		}
		
		Board.setIsPrevious(false);
		return new_arr;
	}
	
	public static String[][] getCells()
	{
		return cells;
	}
	
	public static void setCells(String[][] newCells)
	{
		cells = newCells;
	}
	
	public static int getGenNum()
	{
		return genNum;
	}
	
	public static void setGenNum(int newGenNum)
	{
		genNum = newGenNum;
	}
	
	public static String[][] getPreviousGen()
	{
		return previousGen;
	}
	
	public static void main(String[] args) {
		
		cells = fill_arr(cells, "X");
		new Board();
		Board.cellsToBoard();
		Board.setText();
	}
}
