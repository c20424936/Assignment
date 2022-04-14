package com_file.topicmodeler;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class GUI extends JFrame implements ActionListener {
	JLabel label1;
	JButton button1, button2,button3,button4;
	JPanel panel1,p2;
	JTextField Userinput;
	String Name;
	JFileChooser newfile;
	String File1, File2 ;
	
	
	public GUI(String title)  
	{
		super ();
	
		setVisible(true);
		setSize(500,500);
		setLayout(new FlowLayout());
		
		//Background and panel creation
		panel1 = new JPanel();
		add(panel1);
		
		p2 = new JPanel();
		add(p2);
		
		
		
		panel1.setBackground(Color.RED);
			
		//File 1
		button1 = new JButton();
		panel1.add(button1);
		button1.setText("File 1");
		button1.setToolTipText("This is the First File");
		button1.addActionListener(this);
		
		//File 2
		button2 = new JButton();
		panel1.add(button2);
		button2.setText("File 2");
		button2.setToolTipText("This is the Second File");
		button2.addActionListener(this);
	
		//File 3
		button3 = new JButton();
		p2.add(button3);
		button3.setText("Compare Files");
		button3.setToolTipText("This will compare the files selected");
		button3.addActionListener(this);

		 
		Userinput = new JTextField("Enter value of words to compare in files");
		p2.add(Userinput);
		Userinput.addActionListener(this);
		 
		newfile = new JFileChooser();
		newfile.addActionListener(this);
		 
		
		}
		
		@Override
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource() == button1)
			{
				
				if (newfile.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) 
				    {
				        File1= newfile.getSelectedFile().getName();
				    }
			}
			
			else if (e.getSource() == button2)
			{
				//Opens the directory
				int returnVal1 = newfile.showOpenDialog(null);
				//Returns the name of the file selected to File2
			    if (returnVal1 == JFileChooser.APPROVE_OPTION)
				    {
				       File2 = newfile.getSelectedFile().getName();
				    }
			}
			/*else if (e.getSource() == )
			else if (e.getSource() == f1)
			{
				int k = Integer.parseInt(f1.getText());
			}
			*/
			
			else if(e.getSource() == button3)
			{
				int i = Integer.parseInt(Userinput.getText());
				
				FileRead.readfile(File1,i);
				FileRead.readfile(File2,i);
			}
		}
}



