import java.util.*;
public class targil16 {

	public static Scanner rd = new Scanner(System.in);
	public static void main(String[] args) {
		
		int age;
		System.out.println("enter your age:");
		age = rd.nextInt();
		
		System.out.println("you live: " + (age*365) + " days, " + (age*365*24) + " hours and " + (age*365*24*60) + " seconds");
	}

}
