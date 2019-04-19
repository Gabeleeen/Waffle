package Assignment2;


import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.*;


public class ImagePresenter extends Presenter
{
	/**
	 * Default SerialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	private static ArrayList<String> imageNames = new ArrayList<String>();
	static ImagePresenter iPres;
	
	private int index = 0;
	
	JLabel imageLab;
	JLabel buttons = new JLabel();
	
	
	public void ShowImage(String fileName)
	{
		if(!frame.isVisible())
			frame.setVisible(true);
		
		//jLab = (JLabel) CreateCenterComponent();
		imageLab.setIcon(new ImageIcon(fileName));
		//frame.add(imageLab, new BorderLayout().CENTER);
	}
	
	public void Initialize()
	{
		
		imageLab = (JLabel) CreateCenterComponent();
		frame.setLayout(new BorderLayout());
		
		//Initialization for the buttons
		prevButton = new JButton("Previous Image");
		frame.add(prevButton);
		prevButton.addActionListener(this);
		buttons.add(prevButton);
		nextButton = new JButton("Next Image");
		frame.add(nextButton);
		nextButton.addActionListener(this);
		buttons.add(nextButton);
		frame.add(buttons, new BorderLayout().EAST);
		
		
		//frame.add(textArea);
		frame.add(imageLab, new BorderLayout().CENTER);
		frame.setPreferredSize(new Dimension(500,500));
		frame.pack();
		frame.setVisible(true);
	}
	
	@Override
	public Component CreateCenterComponent() 
	{
		JLabel l = new JLabel();
		l.setPreferredSize(new Dimension(1400,700));
		return l;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == prevButton)
			WestButtonPressed();
		else if(e.getSource() == nextButton)
			EastButtonPressed();
		
		frame.repaint();
	}

	@Override
	public void WestButtonPressed() 
	{
		if(index <= 0)
			index = imageNames.size()-1;
		else
			index--;
		
		ShowImage(imageNames.get(index));
	}

	@Override
	public void EastButtonPressed() 
	{
		if(index >= imageNames.size()-1)
			index = 0;
		else
			index++;
		
		ShowImage(imageNames.get(index));
	}
	
	
	public static void main(String[] args)
	{
		imageNames.add("Chili.jpg");
		imageNames.add("Duck.jpg");
		imageNames.add("Panda.jpg");
		
		iPres = new ImagePresenter();
		iPres.Initialize();
		iPres.ShowImage(imageNames.get(0));
	}
	
}
