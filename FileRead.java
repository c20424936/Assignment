package com_file.topicmodeler;


import java.io.*;
import java.util.*;


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
				
					
					WordList.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).limit(n).forEach(x ->
		                {
		                	System.out.println(x.getKey() + " = "+ x.getValue());
		                	
		                });					
				}
				

		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}



/*
References

lines 74-78 was found online via stackoverflow (https://stackoverflow.com/questions/43922882/how-to-print-hashmap-elements-from-max-to-min) 
*/