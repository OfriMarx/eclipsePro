import java.util.*;
public class MICIO {

	public static Scanner redear= new Scanner(System.in);
	public static void main(String[] args) {
		 Circle c16= new Circle(10,10,10,"blue");
		 c16.draw();
		 for(int i=1; i<=50; i++)
		 {
			 c16.move(10,0);
			 c16.draw();
		 }
		 
		 Square s27=  new Square(0,280,10,"magenta");
		 s27.draw();
		 for(int i=1; i<=80; i++)
		 {
			 s27.move(10,0);
			 s27.draw();
		 }
	
		 
		 Circle c19= new Circle(40,40,40,"yellow");
		 c19.draw();
		 
		Square s7=  new Square(20,260,30,"black");
		 s7.draw();
		 Square s8=  new Square(20,250,30,"black");
		 s8.draw();
		 Square s9=  new Square(20,240,30,"black");
		 s9.draw();
		 Square s10=  new Square(20,230,30,"black");
		 s10.draw();
		 Square s11=  new Square(20,220,30,"black");
		 s11.draw();
		 Square s12=  new Square(20,210,30,"black");
		 s12.draw();
		 Square s13=  new Square(20,200,30,"black");
		 s13.draw();
		 Square s14=  new Square(20,190,30,"black");
		 s14.draw();
		 Square s15=  new Square(20,180,30,"black");
		 s15.draw();
		 Square s16=  new Square(20,170,30,"black");
		 s16.draw();
		 Square s17=  new Square(20,160,30,"black");
		 s17.draw();
		 Square s18=  new Square(20,150,30,"black");
		 s18.draw();
		 Square s19=  new Square(20,140,30,"black");
		 s19.draw();
		 Square s20=  new Square(20,130,30,"black");
		 s20.draw();
		 Circle c1= new Circle(48,100,50,"black");
		 c1.draw();
		 Circle c2= new Circle(53,105,40,"white");
		 c2.draw();
		 Circle head = new Circle(310,130,40,"black");
		 Circle hair = new Circle(300,100,60,"yellow");
		 Triangle bodyt =new Triangle(330,160,50,40,"blue");
		 bodyt.draw();
		 hair.draw();
		 head.draw();
		 Square bodyb=new Square(305,200,50,"blue");
		 bodyb.draw();
		 Line e= new Line(325,200,325,230,"yellow");
			e.draw();
			Line e22= new Line(335,200,335,230,"yellow");
			e22.draw();
		 Line left=new Line (315,195,240,150,"black");
		 left.draw();
		 Line right=new Line (350,200,270,160,"black");
		 right.draw();
		 Square s21=  new Square(335,250,20,"black");
		 s21.draw();
		 Square s22=  new Square(335,265,20,"black");
		 s22.draw();
		 Square s23=  new Square(305,250,20,"black");
		 s23.draw();
		 Square s24=  new Square(305,265,20,"black");
		 s24.draw();
		 Circle ball = new Circle(225,130,25,"red");
		 ball.draw();
		 for(int i=1; i<5;i++)
		 {
			 ball.erase();
			 ball.move(-i*10, -i*10);
			 ball.draw();
		 }
		 for(int i=1; i<5;i++)
		 {
			 ball.erase();
			 ball.move(-i*7, i*6);
			 ball.draw();
		 }
		 for(int i=1; i<5;i++)
		 {
			 ball.erase();
			 ball.move(0, i*6);
			 ball.draw();
		 }
		 ball.draw();
		 Circle c13= new Circle(48,100,50,"black");
		 c1.draw();
		 Circle c12= new Circle(53,105,40,"white");
		 c2.draw();
		 Circle ball1 = new Circle(225,130,25,"red");
		 ball.draw();
		 for(int i=1; i<10;i++)
		 {
			 ball.erase();
			 ball.move(i*4, i*0);
			 ball.draw();
		 }
		 Circle ball11 = new Circle(225,130,25,"red");
		 ball.draw();
		 for(int i=1; i<5;i++)
		 {
			 ball.erase();
			 ball.move(-i*10, -i*10);
			 ball.draw();
		 }
		 for(int i=1; i<5;i++)
		 {
			 ball.erase();
			 ball.move(-i*7, i*6);
			 ball.draw();
		 }
		 for(int i=1; i<5;i++)
		 {
			 ball.erase();
			 ball.move(0, i*6);
			 ball.draw();
		 }
		 Circle c14= new Circle(48,100,50,"black");
		 c1.draw();
		 Circle c15= new Circle(53,105,40,"white");
		 c2.draw();
		 //Square s27=  new Square(0,280,10,"black");
		 //s27.draw();
		 //for(int i=1; i<=299; i++)
		 //{
			 //s27.move(0,-10);
			 //s27.draw();
		 //}
	
	
		 
	
		 
	
		 }		 
	}

