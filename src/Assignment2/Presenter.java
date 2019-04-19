package Assignment2;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public abstract class Presenter extends java.applet.Applet implements ActionListener
{
	
	JFrame frame = new JFrame();
	JTextArea textArea = new JTextArea("",10,1);
	
	JButton	prevButton;
	JButton nextButton;
	
	/**
	 * Default SerialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	public abstract Component CreateCenterComponent();
	
	public void ShowText(String t) 
	{
		textArea.setText(t);
		textArea.repaint();
	}
	
	public JFrame getFrame() { return frame; }
	
	public abstract void WestButtonPressed();
	
	public abstract void EastButtonPressed();
	
	
}