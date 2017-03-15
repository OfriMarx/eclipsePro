
import java.util.*;
public class superman {
	static Scanner in= new Scanner(System.in);
	public static void main(String[] args)
	{
		//String color=in.next();
// program for t4
		
	Canvas canvas = Canvas.getCanvas();
	
	Square k = new Square (100,77,31,"red"); // kape

	Circle h = new Circle (100,50,30,"pink"); //head
	h.draw();
Square s = new Square (103,78,25,"blue"); //shirt1
s.draw();
Square s2 = new Square (103,94,25,"blue"); //shirt2
s2.draw();
Triangle sm = new Triangle (115,96,17,-10,"red"); // triangle
sm.draw();
Triangle sm2 = new Triangle (115,93,13,-6,"yellow"); // triangle
sm2.draw();



Line ll = new Line (103,118,103,150,"blue"); //leg left
ll.draw();
Line ll2 = new Line (104,118,104,150,"blue"); //leg left2
ll2.draw();
Line ll3 = new Line (105,118,105,150,"blue"); //leg left3
ll3.draw();
Line ll4 = new Line (106,118,106,150,"blue"); //leg left4
ll4.draw();


Line lr = new Line (127,118,127,150,"blue"); //leg right
lr.draw();
Line lr2 = new Line (126,118,126,150,"blue"); //leg right2
lr2.draw();
Line lr3 = new Line (125,118,125,150,"blue"); //leg right3
lr3.draw();
Line lr4 = new Line (124,118,124,150,"blue"); //leg right4
lr4.draw();

Triangle ha = new Triangle (115,50,30,6,"black"); // hair
ha.draw();
Line g = new Line (120,52,115,58,"black"); // 3
g.draw();

Triangle uw = new Triangle (115,118,25,-15,"red"); //underwear
uw.draw();



Circle e2= new Circle (105,60,7,"white"); //left eye
e2.draw();
Circle e = new Circle (106,60,5,"black"); //left eye
e.draw();
	
Circle er= new Circle (121,60,7,"white"); //right eye
er.draw();
Circle er2 = new Circle (120,60,5,"black"); //right eye
er2.draw();
	
}}
