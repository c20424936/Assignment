package com_file.topicmodeler;

public class Control {

	public static void main(String[] args) 
	{
		GUI stuff = new GUI("First Gui");
	
		FileRead file1 = new FileRead();
		FileRead file2 = new FileRead();
		
		file1.readfile("Example.txt",10);
		System.out.println("\n");
		file2.readfile("UntilDawn.txt",10);
		
	}
	
	
}
