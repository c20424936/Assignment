# OOP Assignment - 1. Topic Modeller
***********************************************************************
# Classes:
FileRead:
This Class contains the code to compare 2 files using HashMaps and ArrayLists


GUI:Contains the code to display and input values to compare the files

***********************************************************************
# Funtionality:

Button 1: File Chooser 1


This button functions as the first file chooser,allowing the user to pick the first file that will be compared. Using the showOpenDialog fucntion, this opens a directory from which the user can select a .txt file. The name of the file will then be passed into readfile and opened when button3 is pressed.

Button 2: File Chooser 2


This button functions identically to the first file chooser,allowing the user to pick the second file that will be compared. Using the showOpenDialog fucntion, this opens a directory from which the user can select a .txt file. The name of the file is stored in a string and then passed into readfile and opened when button4 is pressed.


Button 3: Choose top N value 


When pressed, button3 selects top N amount of elements to later compare in both files using a JTextfield, which converts the input to an integer using parseInt. 

Button 4: Compare the files


When button4 is pressed, it takes the 2 strings of the filenames and the top N values and passes it to the readfile method in the FileRead class. This runs 2 times, once per file. When the methods is first ran, the file is opened and creates an arraylist "stoplist" containing all stop words. This list of stop words is then compared to the contents of the first file and if there is no match the word is added to the arraylist "list". This arraylist is then added to a HashMap "WordList" that puts the word and its frequency into the hashmap. This HashMap is then added to a new hashmap which oreders the wordlist and limits it to the top N values given in the GUI. This then prints the word and the frequency of the word in the terminal. If the code has only been ran once the contents of WordList will be placed into the HashMap "TempList" and clear Wordlist. The code is then ran again with the second file. The words are filtered again and added to the wordlist and printed into the terminal.However now the WordList will be compared to the "TempList", containing words from file1. This will add to a counter of common words that will be used to calculate the percentage of duplicate words and compare the 2 files. This value is then shown using a JOptionPane.showMessageDialog() along with a message to show the commonality of the files. 


Button 5: Adding Stop Words


This button takes the input of the JTextfield stopword and adds it to the stop words list. This will not count the word entered.


*****************************************************************************************************
# What I would add/change
If I had extra time i would change the readfile and GUI to allow the top N words to be printed in a table in the GUI or as a JOptionPane.showMessageDialog() when a new button is pressed. I would also add the percistance optional feature to improve the overall funtionality of the assignment.

*****************************************************************************************************
# Layout of the GUI:
![image](https://user-images.githubusercontent.com/103035902/163566266-b3ac639f-7c51-4dd9-b409-6bb2a849e432.png)

*****************************************************************************************************
# Video displaying the code
https://youtu.be/jF8_Ih-xMLc

*****************************************************************************************************
# GitHub Repositiory Link:
https://github.com/c20424936/Assignment.git
