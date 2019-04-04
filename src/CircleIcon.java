import java.awt.*;
import java.awt.geom.Ellipse2D;

import javax.swing.*;

public class CircleIcon implements Icon
{
	private int size; 
	
	public static void main(String[] args)
	{
		CircleIcon test = new CircleIcon(20);
		
		
		JFrame frame = new JFrame();
		JButton redButton = new JButton("Red");
		JButton blueButton = new JButton("Blue");
		JButton greenButton = new JButton("Green");
		
		frame.setLayout(new FlowLayout());
		frame.add(redButton);
		frame.add(blueButton);
		frame.add(greenButton);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);;
		frame.pack();
		frame.setVisible(true);
	}
	public CircleIcon(int size)
	{
		this.size = size;
	}
	
	public int getIconHeight() 
	{
		return size;
	}
	
	public int getIconWidth() 
	{
		return size;
	}
	
	public void paintIcon(Component c, Graphics g, int x, int y) 
	{
		Graphics2D g2 = (Graphics2D) g;
		Ellipse2D.Double circle = new Ellipse2D.Double(x,y,size,size);
		g2.setColor(Color.RED);
		g2.fill(circle);
		
	}
}
