import java.awt.*;

class Pontos {
	
	public static void main(String[] args) {
		Point[] points = new Point[10];
		
		for (int i = 0; i < points.length; i++) {          
			points[i] = new Point((int) (Math.random()*10), (int) (Math.random()*10));
		}
		
		for (Point p: points) System.out.println(p);
	}
}