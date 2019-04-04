import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.event.*;
import javax.swing.*;

public class CircleIcon implements Icon
{
	private int size; 
	Color color;
	
	public static void main(String[] args)
	{
		CircleIcon test = new CircleIcon(20);
		test.setColor(Color.RED);
		JLabel circle = new JLabel(test);
		JFrame frame = new JFrame();
		JButton redButton = new JButton("Red");
		JButton blueButton = new JButton("Blue");
		JButton greenButton = new JButton("Green");
		
		redButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				test.setColor(Color.RED);
				circle.repaint();
			}
		});
		blueButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				test.setColor(Color.BLUE);
				circle.repaint();
			}
		});
		greenButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				test.setColor(Color.GREEN);
				circle.repaint();
			}
		});
		
		frame.setLayout(new FlowLayout());
		frame.add(redButton);
		frame.add(blueButton);
		frame.add(greenButton);
		frame.add(circle);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);;
		frame.pack();
		frame.setVisible(true);
	}
	public void setColor(Color col)
	{
		color = col;
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
		g2.setColor(color);
		g2.fill(circle);
		
	}
}
