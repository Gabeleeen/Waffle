package Assignment2;


import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
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
		
		imageLab.setIcon(new ImageIcon(fileName));
		ShowText(imageNames.get(index));
	}
	
	public void Initialize()
	{
		
		imageLab = (JLabel) CreateCenterComponent();
		frame.setLayout(new BorderLayout());
		
		//Initialization for the buttons
		prevButton = new JButton("Previous Image");
		frame.add(prevButton);
		prevButton.addActionListener(this);
		frame.add(prevButton, new BorderLayout().WEST);
		nextButton = new JButton("Next Image");
		frame.add(nextButton);
		nextButton.addActionListener(this);
		frame.add(nextButton,new BorderLayout().EAST);
		
		
		frame.add(textArea, new BorderLayout().NORTH);
		frame.add(imageLab, new BorderLayout().CENTER);
		frame.setPreferredSize(new Dimension(700,700));
		frame.pack();
		frame.setVisible(true);
	}
	
	@Override
	public Component CreateCenterComponent() 
	{
		JLabel l = new JLabel();
		l.setPreferredSize(new Dimension(150,100));
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
		for(String s : args)
			imageNames.add(s);
		
		iPres = new ImagePresenter();
		iPres.Initialize();
		iPres.ShowImage(imageNames.get(0));
	}
	
}
