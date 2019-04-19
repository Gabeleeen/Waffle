import java.awt.FlowLayout;
import java.awt.event.*;
import javax.swing.*;

public class UltimateSignalTester 
{
	static boolean sampleState = false;
	public static void main(String[] args) 
	{
		Signal theSignal = new Signal();
		theSignal.addObserver(new StarObserver());
		theSignal.addObserver(new SignalWindow());
		JFrame frame = new JFrame();
		JButton button = new JButton("Switch to Sinus");
		JTextField text = new JTextField("Default sample");
		frame.setLayout(new FlowLayout());
		frame.add(button);
		button.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(sampleState == false)
				{
					theSignal.setSample(new Sinus(0,0.5));
					sampleState = true;
					button.setText("Switch to Default");
					text.setText("Sinus sample");
				}
				else
				{
					theSignal.setSample(new DefaultSampler());
					sampleState = false;
					button.setText("Switch to Sinus");
					text.setText("Default sample");
				}
			}
		});
		frame.add(text);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);;
		frame.pack();
		frame.setVisible(true);
		
		
	}
}
