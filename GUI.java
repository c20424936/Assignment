package com_file.topicmodeler;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI extends JFrame implements ActionListener {
	int count = 0;
	JLabel label1;
	JButton button1, button2;
	JPanel panel1;
	JFileChooser file1,file2;
	
	
	public GUI(String title)  
	{
	super ();

	setVisible(true);
	setSize(500,500);
	setLayout(new FlowLayout());
	
	//Background and panel creation
	JPanel panel1 = new JPanel();
	add(panel1);
	
	panel1.setBackground(Color.RED);
		
	//button
	button1 = new JButton();
	panel1.add(button1);
	button1.setText("File 1 ");
	button1.setToolTipText("This is the First File");
	button1.addActionListener(this);
	
	//button
	button2 = new JButton();
	panel1.add(button2);
	button2.setText("File 2");
	button2.setToolTipText("This is the Second File");
	button2.addActionListener(this);

	 file1 = new JFileChooser();
	 file2 = new JFileChooser();
	 
	 
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == button1)
		{
			int returnValue1 = file1.showOpenDialog(null);
		}
		
		else if (e.getSource() == button2)
		{
			int returnValue2 = file2.showOpenDialog(null);
			
		}
		
		else
			System.out.print("I Finished");
	}
}


