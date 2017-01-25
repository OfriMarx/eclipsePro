package battleShips;
import java.util.*;

public class Main {

	public static Scanner rd = new Scanner(System.in);
	public static void main(String[] args) {
		
		P1 p1 = new P1("X");
		P1 p2 = new P1("O");
		String[][] place = new String[3][3];
		
		for (int r=0;r<3;r++)
			for (int c=0;c<3;c++)
				place[r][c] = "0";
		
		while(true)
		{
			place = board(p1, place);
			boardCheck(place, p1);
			if (p1.getWin())
			{
				System.out.println("");
				System.out.println("P1 wins");
				break;
			}
				
			place = board(p2, place);
			boardCheck(place, p2);
			if (p2.getWin())
			{
				System.out.println("");
				System.out.println("P2 wins");
				break;
			}
		}
		
	}
	
	public static String[][] board(P1 p, String[][] arr)
	{
		p.setRow(rd.nextInt());
		p.setCol(rd.nextInt());
		
		String brd1 = "";
		String brd2 = "";
		String brd3 = "";
		
		int ro = p.getRow();
		int co = p.getCol();
		
		if (ro > 3 || ro < 1 || co > 3 || co < 1 || arr[ro-1][co-1] != "0")
		{
			System.out.println("nope");
			arr = board(p, arr);
		}
		else
		{
			for (int r=0; r<3; r++)
			{
				
				if (r == (ro-1) && arr[r][co-1] == "0")
				{
					
					switch (co)
					{
					case 1: co = 1;
						brd1 = brd1 + p.getSign() + " ";
						brd2 += "- ";
						brd3 += "- ";
						arr[r][0] = p.getSign();
						break;
					case 2: co = 2;
						brd1 += "- ";
						brd2 = brd2 + p.getSign() + " ";
						brd3 += "- ";
						arr[r][1] = p.getSign();
						break;
					case 3: co = 3;
						brd1 += "- ";
						brd2 += "- ";
						brd3 = brd3 + p.getSign() + " ";
						arr[r][2] = p.getSign();
						break;
					}
				}
				
				else
				{		
					brd1 += "- ";
					brd2 += "- ";
					brd3 += "- ";
				}
				if (arr[r][0] != "0")
				{
					brd1 = brd1.substring(0, brd1.length()-2);
					brd1 = brd1 + arr[r][0] + " ";
				}
				
				if (arr[r][1] != "0")
				{
					brd2 = brd2.substring(0, brd2.length()-2);
					brd2 = brd2 + arr[r][1] + " ";
				}
				
				if (arr[r][2] != "0")
				{
					brd3 = brd3.substring(0, brd3.length()-2);
					brd3 = brd3 + arr[r][2] + " ";
				}
				
			}
		}
		
		
		System.out.println(brd1);
		System.out.println(brd2);
		System.out.println(brd3);
		
		return arr;
	}
	
	public static void boardCheck(String[][] arr, P1 p)
	{
		int[] list = {0,0,0,0,0,0,0,0,0};
		
		for(int r=0;r<3;r++)
		{
			for(int c=0;c<3;c++)
			{
				if (arr[r][c] == p.getSign())
				{
					list[3*r+c] = 1;
				}
			}
		}
		
		if (list[0]==1 && list[1]==1 && list[2]==1)
			p.setWin();
		else if (list[3]==1 && list[4]==1 && list[5]==1)
			p.setWin();
		else if (list[6]==1 && list[7]==1 && list[8]==1)
			p.setWin();
		else if (list[0]==1 && list[3]==1 && list[6]==1)
			p.setWin();
		else if (list[1]==1 && list[4]==1 && list[7]==1)
			p.setWin();
		else if (list[2]==1 && list[5]==1 && list[8]==1)
			p.setWin();
		else if (list[0]==1 && list[4]==1 && list[8]==1)
			p.setWin();
		else if (list[2]==1 && list[4]==1 && list[6]==1)
			p.setWin();
	}
}
