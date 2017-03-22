
public class TesrGr {
	public static void main(String[] args)
	{

	Square  b=new Square(160,160,40,"green");
	//b.changeColor("magenta");
	b.draw();
	Triangle r = new Triangle(Canvas.getCanvas().getSize().width/2,140,40,20, "red");
	r.draw();
	Circle c= new Circle(250,20,100,"yellow");
	c.draw();
	c.erase();
	c.draw();
	c.erase();
	c=new Circle(210,20,100,"yellow");
	c.draw();
	c.erase();
	c=new Circle(200,20,100,"yellow");
	c.draw();
	c.erase();
	c=new Circle(190,20,100,"yellow");
	c.draw();
	c.erase();
	c=new Circle(180,20,100,"yellow");
	c.draw();
	c.erase();
	c=new Circle(160,20,100,"yellow");
	c.draw();
	c.erase();
	c=new Circle(140,20,100,"yellow");
	c.draw();
	c.erase();
	c=new Circle(100,20,100,"yellow");
	c.draw();
}
}