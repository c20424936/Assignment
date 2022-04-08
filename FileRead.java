package com_file.topicmodeler;


import java.io.*;
import java.util.*;

public class FileRead {
	
		static int L = 0;
		static HashMap<String,Integer> TempList = new HashMap<>();
		
		public void readfile(String filename, int n) 
		{
			HashMap<String,Integer> WordList = new HashMap<>();
			
			ArrayList<String> list = new ArrayList<String>();
			ArrayList<String> stoplist = new ArrayList<String>();
			int counter = 0;
			
		try(LineNumberReader lr = new LineNumberReader(new FileReader (filename)))
			{
				@SuppressWarnings("resource")
				LineNumberReader blr = new LineNumberReader(new FileReader ("stops.txt"));
	
				String line = " ";
				String stop_word = " ";
				
				
				while((stop_word = blr.readLine()) != null) 
				{
			            //Adding all words generated     
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
				int WordCount[];
				WordCount= new int[list.size()];
				int i= 0;
					
				for (String key : number) 
					{
						WordList.put(key,Collections.frequency(list, key));
						WordCount[i] = Collections.frequency(list, key); 
						i++;
					}
					
					
					WordList.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
					.limit(n)
					.forEach(x ->
							{
			                	System.out.println(x.getKey() + " = "+ x.getValue());
			                });
			                
						
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
						
						
					if (L == 1)
						{
							double P = 0;
							
							P = (counter*100/WordList.size());
							System.out.print(P + "%");
							
							if (P <= 24)
							{
								System.out.print("\nThese files have nothing in common");
							}
							
							else if (P < 50 && P >= 25) 
							{
								System.out.print("\nThese files are not very similar");
							} 
							
							else if (P >= 50 && P <= 99) 
								
							{
								System.out.print("\nThese files are very similar but not identical");
							} 
							
							else if (P == 100) 
							{
								System.out.print("\nThese files identical");
							}
								
						}
						
						if (L == 0) 
						{
							TempList.putAll(WordList);
							L = 1;
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