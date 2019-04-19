package Assignment2;

import java.awt.Dimension;
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
		frame.add(prevButton);
		frame.add(nextButton);
		frame.add(textArea);
		frame.add(jLab);
		frame.setPreferredSize(new Dimension(500,500));
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
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
