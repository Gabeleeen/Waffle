package Assignment2;


import java.awt.Component;
import java.awt.Dimension;
import javax.swing.*;


public abstract class ImagePresenter extends Presenter
{
	/**
	 * Default SerialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	//private ArrayList<String> imageNames = new ArrayList<String>();
	
	//private int index = 0;
	
	JLabel jLab = (JLabel) CreateCenterComponent();
	
	
	public void ShowImage(String fileName)
	{
		if(!frame.isVisible())
			frame.setVisible(true);
		
		//jLab = (JLabel) CreateCenterComponent();
		jLab.setIcon(new ImageIcon(fileName));
		
	}
	
	@Override
	public Component CreateCenterComponent() 
	{
		JLabel l = new JLabel();
		l.setPreferredSize(new Dimension(1400,700));
		return l;
	}
	
	
}
