package nothing;

import java.util.Scanner;

public class tlatSifrati {

	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		long num = sc.nextInt(), sum=0, digit=0, big=0;
		
		while(num > 0)
		{
			big = Math.max(big, num%10);
			
			if(num%10>3)
				sum+=num%10;
			
			num /= 10;
			digit++;
		}
		
		System.out.println(big);
		System.out.println(sum);
		System.out.println(digit);
	}

}
