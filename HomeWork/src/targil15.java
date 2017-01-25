import java.util.*;
public class targil15 {
	
	public static Scanner rd = new Scanner(System.in);
	public static void main(String[] args) {

		double dhour, nhour, shour, pay;
		System.out.println("enter number of hours in day, night and shabat:");
		dhour = rd.nextDouble();
		nhour = rd.nextDouble();
		shour = rd.nextDouble();

		System.out.println("enter money:");
		pay = rd.nextDouble();
		
		System.out.println((pay*dhour) + ((pay*1.5)*nhour) + ((pay*2)*shour));
	}

}
