package com_file.topicmodeler;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


public class GUI extends FileRead implements ActionListener {
	JLabel label1;
	JButton button1, button2,button3,button4;
	JPanel p1;
	JTextField Userinput;
	String Name;
	JFileChooser newfile;
	String File1, File2 ;

	
	public GUI(String title)  
	{
		JFrame frame1 = new JFrame ("Reading Files");
	
		frame1.setVisible(true);
		frame1.setSize(300,300);
		
		
		//Background and panel creation
		p1 = new JPanel();
		frame1.add(p1);
		
		SpringLayout layout = new SpringLayout();
		p1.setLayout(layout);
		
		p1.setBackground(Color.GRAY);

		
		//File 1
		button1 = new JButton();
		p1.add(button1);
		button1.setText("File 1");
		button1.setToolTipText("This is the First File");
		button1.addActionListener(this);
		
		//File 2
		button2 = new JButton();
		p1.add(button2);
		button2.setText("File 2");
		button2.setToolTipText("This is the Second File");
		button2.addActionListener(this);
	
		//File 3
		button3 = new JButton();
		p1.add(button3);
		button3.setText("Compare Files");
		button3.setToolTipText("This will compare the files selected");
		button3.addActionListener(this);

		 
		Userinput = new JTextField("Enter value of words to compare in files");
		p1.add(Userinput);
		Userinput.addActionListener(this);
		 
		newfile = new JFileChooser();
		newfile.addActionListener(this);
		 
		layout.putConstraint(SpringLayout.NORTH,button1,25, SpringLayout.WEST, p1);
		layout.putConstraint(SpringLayout.NORTH,button2,65, SpringLayout.NORTH, p1);
		layout.putConstraint(SpringLayout.VERTICAL_CENTER,Userinput,0, SpringLayout.VERTICAL_CENTER, p1);
		layout.putConstraint(SpringLayout.VERTICAL_CENTER,button3,35, SpringLayout.VERTICAL_CENTER, p1);
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
				//Returns the name of the file selected to File2
			    if (newfile.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
				    {
				       File2 = newfile.getSelectedFile().getName();
				    }
			}
		
			else if(e.getSource() == button3)
			{
				
				int i = Integer.parseInt(Userinput.getText());
				readfile(File1,i);
				readfile(File2,i);
				
				if(L == 1)
					{
				
						double P = 0;
				
						P = (counter*100/TempList.size());
												
						if (P <= 24)
						{
							JOptionPane.showMessageDialog(button3,"\nThese files have " + P +"% in common");
							
						}
						
						else if (P < 50 && P >= 25) 
						{
							JOptionPane.showMessageDialog(button3,"\nThese files have " + P +"% in common");
						} 
						
						else if (P >= 50 && P <= 99) 
							
						{
							JOptionPane.showMessageDialog(button3,"\nThese files have " + P +"% in common\nThese files are very similar but not identical");
							
						} 
						
						else if (P == 100) 
						{
							JOptionPane.showMessageDialog(button3,"\nThese files have " + P +"% in common\nThese files identical");
							
						}
						counter = 0;
						
						
					}	
				}
			}
			
		}

		




