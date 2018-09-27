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
    public static void main(String[] args) throws FileNotFoundException 
    {
        HashMap wordMap = new HashMap();  // Map of word --> # of occurrences

        //scanner object is instantiated with name Cursor
        Scanner Cursor = new Scanner(new File("Sample.txt")); //file is opened to be read

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
            
        }
        // now print out every word in the book, along with its count,
        // in alphabetical order
        ArrayList arraylist = new ArrayList(wordMap.keySet());
        Collections.sort(arraylist);

        for (int i = 0; i < arraylist.size(); i++) 
        {
          String key = (String)arraylist.get(i);
          Integer count = (Integer)wordMap.get(key);
          System.out.println(key + " --> " + count);
        }
    }

    static void wordAnalyser(File file)
    {

    }

    static void buildWordMap(String anotherWord)
    {

    }     
}

