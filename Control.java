package com_file.topicmodeler;

public class Control {

	public static void main(String[] args) 
	{
		FileRead file1 = new FileRead();
		FileRead file2 = new FileRead();
		
		file1.readfile("example.txt",10);
		System.out.println("\n");
		file2.readfile("Cover.txt",9);
		
	}
	
	
}
