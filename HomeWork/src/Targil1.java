
public class Targil1 {
	
	public static void main(String[] args)
	{
		Circle c1 = new Circle(150,10,50,"black");
		c1.draw();
		Circle c2 = new Circle(200,10,50,"black");
		c2.draw();
		Circle c3 = new Circle(150,15,30,"white");
		c3.draw();
		Circle c4 = new Circle(220,15,30,"white");
		c4.draw();
		Circle c5 = new Circle(150,25,10,"black");
		c5.draw();
		Circle c6 = new Circle(240,25,10,"black");
		c6.draw();
		Triangle t = new Triangle(200, 80, 20, 20, "red");
		t.draw();
		
		
		for(int i=130; i<280; i+=10)
		{
			Square s = new Square(i, 130, 10, "yellow");
			s.draw();
		}
		
		c5.erase();
		Circle c7 = new Circle(152,32,10,"black");
		c7.draw();
		c7.erase();
		Circle c8 = new Circle(154,33,10,"black");
		c8.draw();
		c8.erase();
		Circle c9 = new Circle(156,34,10,"black");
		c9.draw();
		c9.erase();
		Circle c10 = new Circle(158,34,10,"black");
		c10.draw();
		c10.erase();
		Circle c11 = new Circle(160,33,10,"black");
		c11.draw();
		c11.erase();
		Circle c12 = new Circle(162,33,10,"black");
		c12.draw();
		c12.erase();
		Circle c13 = new Circle(164,33,10,"black");
		c13.draw();
		c13.erase();
		Circle c14 = new Circle(165,32,10,"black");
		c14.draw();
		c14.erase();
		Circle c15 = new Circle(165,31,10,"black");
		c15.draw();
		
		c6.erase();
		Circle c16 = new Circle(238,30,10,"black");
		c16.draw();
		c16.erase();
		Circle c17 = new Circle(236,32,10,"black");
		c17.draw();
		c17.erase();
		Circle c18 = new Circle(234,34,10,"black");
		c18.draw();
		c18.erase();
		Circle c19 = new Circle(228,34,10,"black");
		c19.draw();
	}
}
