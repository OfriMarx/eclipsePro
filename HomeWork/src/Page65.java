import java.util.*;
public class Page65 {
	
	public static Scanner rd = new Scanner(System.in);
	public static void main(String[] args) {

		double fahr; /*fahrenheit in short*/
		System.out.println("enter in fahrenheit:");
		fahr = rd.nextDouble();
		System.out.println("Celsius: " + (((fahr-32)*5)/9));
	}

}
