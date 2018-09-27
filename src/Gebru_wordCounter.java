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
        //File inputText = new File(args[0]); 
        //String fileName = args[0];
        Scanner Cursor = new Scanner(new FileInputStream(args[0]));//new File(fileName)); 
       
//        if(inputText.exists() && inputText.isFile() &&  inputText.canRead())
//        {
//         //scanner object is instantiated with name Cursor
//         Cursor =  inputText; //file is opened to be read
//         //Cursor.useDelimiter(", *");
//        }
       // else return ;
        HashMap wordMap = new HashMap();  // Map of word --> # of occurrences
        int totNumofWords = 0;
        
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
        System.out.println(" Total number of words on the text are --> " + totNumofWords );
    }

    
 
}

