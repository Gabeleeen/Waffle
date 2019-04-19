package Assignment2;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class SlideShow extends ImagePresenter
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ArrayList<String> imageNames = new ArrayList<String>();
	int index = 0;
	
	public void Init()
	{
		SetUpButtons();
		frame.setLayout(new GridLayout(0,1,10,10));
		frame.add(prevButton);
		frame.add(nextButton);
		frame.add(textArea);
		frame.add(jLab);
		frame.setPreferredSize(new Dimension(200,150));
		frame.pack();
		frame.setVisible(true);
	}
	
	@Override
	public void WestButtonPressed()
	{
		if(index <= 0)
			index = imageNames.size()-1;
		else
			index--;
		
		jLab.setIcon(new ImageIcon(imageNames.get(index)));
		jLab.repaint();
	}
	
	@Override
	public void EastButtonPressed()
	{
		if(index >= imageNames.size())
			index = 0;
		else
			index++;
		
		jLab.setIcon(new ImageIcon(imageNames.get(index)));
		jLab.repaint();
		
	}

	

	
	public static void main(String[] args)
	{
		Presenter slideShow = new SlideShow();
		((SlideShow) slideShow).Init();
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		System.out.println("REEE");
		// TODO Auto-generated method stub
		
	}
}
