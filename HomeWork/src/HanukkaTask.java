import java.util.*;
public class HanukkaTask
{
	public static Scanner in = new Scanner(System.in);

	public static void main(String[]args)
	{
		
		Square s1 = new Square (390,35,50,"green");
		s1.draw();
		Square s2 = new Square (300,35,50,"green");
		s2.draw();
		Square s3 = new Square (210,35,50,"green");
		s3.draw();
		Square s4 = new Square (120,35,50,"green");
		s4.draw();
		Square s5 = new Square (30,35,50,"green");
		s5.draw();
		
		Square s6 = new Square (407,20,15,"red");
		s6.draw();
		Square s7 = new Square (318,20,15,"magenta");
		s7.draw();
		Square s8 = new Square (230,20,15,"red");
		s8.draw();
		Square s9 = new Square (137,20,15,"magenta");
		s9.draw();
		Square s10 = new Square (47,20,15,"red");
		s10.draw();
		
		Triangle t1 = new Triangle (415,130,50,-45, "blue" );
		t1.draw();
		Triangle t2 = new Triangle (326,130,50,-45, "blue" );
		t2.draw();
		Triangle t3 = new Triangle (235,130,50,-45, "blue" );
		t3.draw();
		Triangle t4 = new Triangle (145,130,50,-45, "blue" );
		t4.draw();
		Triangle t5 = new Triangle (55,130,50,-45, "blue" );
		t5.draw();
		
		Line l1 = new Line (398,45,398,70, "black" );
		l1.draw();
		Line l2 = new Line (398,45,427,45, "black" );
		l2.draw();
		Line l3 = new Line (427,45,427,70, "black" );
		l3.draw();
		
		
		Line l4 = new Line (338,45,338,70, "black" );
		l4.draw();
		Line l5 = new Line (338,70,312,70, "black" );
		l5.draw();
		
		Line l6 = new Line (240,45,240,70, "black" );
		l6.draw();
		
		
		Line l7 = new Line (160,45,160,70, "black" );
		l7.draw();
		Line l8 = new Line (160,70,135,70, "black" );
		l8.draw();
		Line l9 = new Line (160,45,135,45, "black" );
		l9.draw();
		
		Line l10 = new Line (67,45,67,70, "black" );
		l10.draw();
		Line l11 = new Line (67,45,45,45, "black" );
		l11.draw();
		Line l12 = new Line (50,53,50,70, "black" );
		l12.draw();
		
		Circle c1 = new Circle (300,175,65, "yellow" );
		c1.draw();
		Circle c2 = new Circle (200,175,65, "yellow" );
		c2.draw();
		Circle c3 = new Circle (100,175,65, "yellow" );
		c3.draw();
		
		Circle c4 = new Circle (319,200,20, "red" );
		c4.draw();
		Circle c5 = new Circle (219,200,20, "red" );
		c5.draw();
		Circle c6 = new Circle (119,200,20, "red" );
		c6.draw();
		
		Line l13 = new Line (365,270,315,270, "black" );
		l13.draw();
		Line l14 = new Line (365,270,365,233, "black" );
		l14.draw();
		Line l15 = new Line (338,270,338,233, "black" );
		l15.draw();	
		Line l16 = new Line (315,270,315,233, "black" );
		l16.draw();	
		
		Line l17 = new Line (265,270,215,270, "black" );
		l17.draw();
		Line l18 = new Line (265,270,265,233, "black" );
		l18.draw();
		Line l19 = new Line (265,233,220,258, "black" );
		l19.draw();
		Line l20 = new Line (240,245,240,233, "black" );
		l20.draw();
		
		Line l21 = new Line (165,233,123,233, "black" );
		l21.draw();
		Line l22 = new Line (165,233,165,270, "black" );
		l22.draw();
		Line l23 = new Line (123,233,123,270, "black" );
		l23.draw();
		
		Canvas can = Canvas.getCanvas();
		can.wait(1500);
		
		c2.erase();
		c3.erase();
		c5.erase();
		c6.erase();
		l13.erase();
		l14.erase();
		l15.erase();
		l16.erase();
		l17.erase();
		l18.erase();
		l19.erase();
		l22.erase();
		l20.erase();
		l21.erase();
		l23.erase();
		
		Circle c7 = new Circle (330,175,27, "white" );
		c7.draw();
		Circle c8 = new Circle (345,187,27, "white" );
		c8.draw();
		Circle c9 = new Circle (354,194,27, "white" );
		c9.draw();
		
		
	}
}
 