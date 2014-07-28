/**
* Program input's text file does word count and then outputs text file
* @author  http://www.mikestratton.net
* @version 1.0
* @since   7/27/2014
***********************************************
***************REFERENCES**********************
***********************************************
http://faculty.washington.edu/stepp/courses/2004autumn/tcss143/lectures/files/2004-11-10/WordCount.java
https://www.youtube.com/watch?v=WEZRc0GoP3E
*/

import java.util.*;
import java.io.*;

public class wordCountNLP
{  
    public static void main(String[] args) throws FileNotFoundException 
   {
      HashMap map = new HashMap();  
      Scanner console = new Scanner(System.in);           
      System.out.println("File to be read: ");
      String inputFile = console.next();
      File file = new File(inputFile);
      Scanner in = new Scanner(file);
      
      while (in.hasNext()) {
         String word = in.next(); 
            
            if(map.containsKey(word)) {
               Integer count = (Integer)map.get(word);
               map.put(word, new Integer(count.intValue() + 1));
            }           
            else {
               map.put(word, new Integer(1));
            }
       }
       
      Scanner output = new Scanner(System.in);           
      System.out.println("Please select output file name: ");
      String outputFile = output.next();
      

         ArrayList arraylist = new ArrayList(map.keySet());
         Collections.sort(arraylist);     

            String fileName = outputFile;
            
            try {
               PrintWriter outputStream = new PrintWriter(fileName);
               for (int i = 0; i < arraylist.size(); i++) 
               {
                  String key = (String)arraylist.get(i);
                  Integer count = (Integer)map.get(key);
               
               outputStream.println(key + ";" + count);
               }   
               outputStream.close();
               System.out.println("Execution complete");
            } 
               catch (FileNotFoundException e){
                  e.printStackTrace(); 
               }              
    }  
}
