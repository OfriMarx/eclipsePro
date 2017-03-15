package loops;

import java.util.Scanner;

public class Targil1468 {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner rd = new Scanner(System.in);
		int weight, weight2;
		
		for(int i=0; i<34; i++)
		{
			System.out.println("Enter name:");
			String name = rd.next();
			System.out.println("Enter weight:");
			weight = rd.nextInt();
			System.out.println("Enter target:");
			weight2 = rd.nextInt();
			int weight3 = weight - weight2;
			
			System.out.println(name + ": " + weight3 + " to target");
			if(weight3 > 12*weight/100)
				System.out.println(name + ": not healthy");
		}

	}

}
