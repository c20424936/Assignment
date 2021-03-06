package com_file.topicmodeler;


import java.io.*;
import java.util.*;

public class FileRead {
	
	static int L = 0;
	static int counter = 0;
	static HashMap<String,Integer> TempList = new HashMap<String,Integer>();
	static ArrayList<String> stoplist = new ArrayList<String>();
	static HashMap<String,Integer> WordList = new HashMap<>();
	
	public static void readfile(String file, int n) 
		{
		 ArrayList<String> list = new ArrayList<String>();			
		 try(LineNumberReader lr = new LineNumberReader(new FileReader (file)))
				{
			 
					LineNumberReader blr = new LineNumberReader(new FileReader ("stops.txt"));
		
					String line = " ";
					String stop_word = " ";
					
					
					while((stop_word = blr.readLine()) != null) 
					{
						//Adding all stop words generated     
						for(String stopword : stop_word.toLowerCase().split(" "))	
				            {    
									stoplist.add(stopword);
				            }
				    }
					
					while((line = lr.readLine()) != null) 
						{
					            //Adding all words generated     
						for(String word : line.toLowerCase().split(" "))
							{    
								if(stoplist.contains(word))
									{
										//nothing will be added to the list if it is contained in the stop words text file
									}
								
								else
									{
										list.add(word);
									} 
							}
						}
						
					Set<String> number = new HashSet<String>(list);
					
									
					for (String key : number) 
						{
							WordList.put(key,Collections.frequency(list, key));
						}
						
						
						WordList.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
						.limit(n)
						.forEach(x ->
								{
									System.out.println(x.getKey() + " = "+ x.getValue());
								}
								);
						
				                
						
						for (String key : WordList.keySet())
							{
							
							 if (TempList.containsKey(key)) 
					          	{ 
								 
					            	if (TempList.containsValue(WordList.get(key))) 
						            { 
					            		counter++;
					            		
						            }
					            		
					            }
							}
							if (L == 0)
							{
								TempList.putAll(WordList);
								L++;
								WordList.clear();
							}
						
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
lines 71-76 was found online via stackoverflow (https://stackoverflow.com/questions/43922882/how-to-print-hashmap-elements-from-max-to-min) 
*/ 