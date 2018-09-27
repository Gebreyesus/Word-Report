package words;
import java.util.*; //INCLUDING ALL LIBRARIES UNDER 
import java.io.*;
/**
* @ Author: Beteab G. Gebru
* Class: Compilers I
* Project title: Word analysis on a word file
*/
public class Words 
{
    
    /**
    *@ param Words : takes in the hashmap of words and number of showing in the text
    *
    */
     static void printer(HashMap Words)
      {
        //putting the words into an arraylist to make it suitable for sorting
        ArrayList listOfWords = new ArrayList(Words.keySet());
        ///and having it sorted alphabetically 
        Collections.sort(listOfWords);
        
        for (int i = 0; i < listOfWords.size(); i++) 
        {
              String key = (String)listOfWords.get(i);
              Integer count = (Integer)Words.get(key);
              System.out.println(key + " --> " + count);
        }
      }  
    /**
    *@ param args -command line argument which would be the name of the document to be ream
    *
    *Here lies the main program
    */
    public static void main(String[] args) throws FileNotFoundException 
    {
        HashMap wordMap = new HashMap();  // Map of word --> # of occurrences
        int totNumofWords = 0;//counts total num of words
        //scanner object is instantiated with name Cursor
        Scanner Cursor = new Scanner(new File("Sample.txt")); //file(Sample.txt) is opened to be read

        while (Cursor.hasNext()) //keep reading until cursor has reached end of document
        {
            String Word = Cursor.next();//capturing the next word in text
            if(wordMap.containsKey(Word)) //if this is another instance of the word we have encountered
             {
                // if word instance exists --> increment the number of appearances +1
                Integer count = (Integer)wordMap.get(Word);
                wordMap.put(Word, new Integer(count.intValue() + 1));
             } 
            else//New word at last -> add to the Map and make occurence=1  
                wordMap.put(Word, new Integer(1));
        totNumofWords++;            
        }
        //we can call the printer if we wanted to display the words  
        //printer(wordMap);
         System.out.println(" Total number of words on the text are --> " + totNumofWords );
    }
    
   
}

