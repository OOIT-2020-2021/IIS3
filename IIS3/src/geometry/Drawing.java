package geometry;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Drawing extends JPanel {

	public static void main(String[] args) {

		JFrame frame = new JFrame("Drawing");
		frame.setSize(800, 600);
		Drawing drawing = new Drawing();
		frame.getContentPane().add(drawing);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	
	public void paint(Graphics g) {
		
		Point p = new Point(50, 50, false, Color.BLUE);
		p.draw(g);
		
		Line l = new Line(new Point(80, 50), new Point(80, 230), false, Color.RED);
		l.draw(g);
		
		Circle c = new Circle(new Point(150, 60), 40, false, Color.BLUE, Color.GREEN);
		c.draw(g);
		
		Rectangle r = new Rectangle(new Point(200, 130), 50, 80, false, Color.BLACK, Color.RED);
		r.draw(g);
		
		Donut d = new Donut(new Point(330, 320), 60, 25, false, Color.GRAY, Color.MAGENTA);
		d.draw(g);
		
	}

}
