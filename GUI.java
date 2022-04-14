package com_file.topicmodeler;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class GUI extends FileRead implements ActionListener 
{
	JLabel label1;
	JButton button1, button2,button3,button4,button5;
	JPanel p1 , p2 ,p3,p4;
	JTextField Userinput,StopWord;
	String Name;
	JFileChooser newfile;
	String File1, File2 ;
	JFrame frame1;
	int i;
	
	public GUI(String title)  
	{
		//Background creation
		frame1 = new JFrame ("Reading Files");
		frame1.setVisible(true);
		frame1.setSize(500,500);
		frame1.getContentPane().setBackground(new Color(5, 65, 90));
		
		//Panel creation
		p1 = new JPanel();
		frame1.add(p1);
		p1.setBackground(Color.RED);
		
		p2 = new JPanel();
		frame1.add(p2);
		p2.setBackground(Color.BLACK);
		
		p3 = new JPanel();
		frame1.add(p3);
		p3.setBackground(Color.BLUE);
		
		p4 = new JPanel();
		frame1.add(p4);
		p4.setBackground(Color.YELLOW);
		
		//Layout of the background
		FlowLayout layout = new FlowLayout();
		frame1.setLayout(layout);
	
		
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
	
		//User Input
		Userinput = new JTextField("Enter value of words to compare in files");
		p2.add(Userinput);
		Userinput.addActionListener(this);
		
		//Add Stop words
		StopWord = new JTextField("Enter single stop word to add to file");
		p3.add(StopWord);
		StopWord.addActionListener(this);
		
		//
		button4 = new JButton();
		p2.add(button4);
		button4.setText("Get n number of words to compare");
		button4.setToolTipText("This will compare the files selected");
		button4.addActionListener(this);
		
		button5 = new JButton();
		p3.add(button5);
		button5.setText("Add stop words");
		button5.setToolTipText("This will add the stop word");
		button5.addActionListener(this);
		
		//Button to compare files
		button3 = new JButton();
		p4.add(button3);
		button3.setText("Compare Files");
		button3.setToolTipText("This will compare the files selected");
		button3.addActionListener(this);
				 
		//File Creation
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
				//Returns the name of the file selected to File2
			    if (newfile.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
				    {
				       File2 = newfile.getSelectedFile().getName();
				    }
			}
				
			else if(e.getSource() == button3)
			{
				
				readfile(File1,i);
				readfile(File2,i);
				
				
				
				if(L == 1)
					{
						//Calculate the percentage
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
					}
				else if(e.getSource() == button4)
					{
						
						i = Integer.parseInt(Userinput.getText());
						
					}
				else if(e.getSource() == button5)
					{
						String k = StopWord.getText();
						stoplist.add(k);
					}
				}
	}	
}