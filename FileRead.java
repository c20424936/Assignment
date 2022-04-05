package com_file.topicmodeler;


import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.*;
import java.util.Set;

public class FileRead {
	
	public void readfile(String filename, int n) 
	{
		
        HashMap<String,Integer> WordList = new HashMap<>();
		ArrayList<String> list = new ArrayList<String>();

		int WordCount[];
		
		
	try(LineNumberReader r = new LineNumberReader(new FileReader (filename))) 
		{
				String line = " ";
				
				
				while((line = r.readLine()) != null) 
				{
			            //Adding all words generated     
					for(String word : line.toLowerCase().split(" "))	
			            {    
			                list.add(word);  
			            } 
				}
				
				Set<String> number = new HashSet<String>(list);
				WordCount= new int[list.size()];
				int i= 0;
				for (String key : number) 
				{
					
					WordList.put(key,Collections.frequency(list, key));
					WordCount[i] = Collections.frequency(list, key); 
					i++;
				}
				
				
					int temp;
					int size = WordCount.length;
					int small = -1;
					
					for( i = 0; i < size-1; i++)   
						{  
						small = i;
						
						for (int j = i ; j <= size-1; j++)
			      		{
			        		if (WordCount[j] > WordCount[small])
			        		{
			           			small = j;
			        		}
			        		//swap values
			      		}
			        		temp = WordCount[i];
			        		WordCount[i] = WordCount[small];
			        		WordCount[small] = temp; 
								
						}
					for (i = 0; i < size; i++) 
			      	{     
			      		System.out.println(WordCount[i]);  
			   		}
					WordList.entrySet().stream()
	                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
	                .forEach(x -> {
	                     System.out.println(x.getKey() + ","+ x.getValue());
	                });
					
				}
				
				
			
				

		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
