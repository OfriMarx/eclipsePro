package nothing;

import java.util.Scanner;

public class tlatSifrati {

	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		long num = sc.nextInt(), sum=0;
		
		for(int i=10; i<=Math.pow(10, Long.toString(num).length()); i*=10)
		{
			if(num%i/(i/10)>3)
				sum += 1;
				
		}
		
		System.out.println(sum);
	}

}
