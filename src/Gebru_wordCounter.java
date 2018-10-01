package words;
import java.util.*; //INCLUDING ALL LIBRARIES UNDER ....
import java.io.*;
import java.awt.*;
import java.util.regex.Pattern;
//import java.util.Map.Entry;

/**
 * the class Words represents a Class file in the system 
 * @ Author: Beteab G. Gebru
 * Class: Compilers I
 * Project title: Word analysis on a word file
 */
public class Words 
{
//Global functions and variables here  
    
//-----------------------------------------------------------get rid of non words using regex delimiters    
    public static String formatWords(String Word)
    {            
        String localWord = Word.toUpperCase();//to avoid case being an issue
        
        if (localWord.matches("[0-99999]+") || localWord.length() <= 1)//ignoring pure numbers
            localWord="Null";
        else if (Pattern.matches("[a-zA-Z]+", Word)==false)         
                localWord="Null";
        // System.out.println("   Word---"+localWord);     //for debugging
        return localWord;
    }
//-----------------------------------------------------------function to create hash map 
    /**
     * 
     * printer represents a function that outputs the data in the hashmap by formatting it
     * @param FileName receives name of file to read
     *@return HashMap  : returns hashmap of all the words in text
     *@throws FileNotFoundException
     */
    public static HashMap createHashMapofWords(File FileName)throws FileNotFoundException
    {
        HashMap<String, Integer> wordMap = new HashMap();  // Map of (key)word --> # of occurrences(count)
        Scanner Cursor = new Scanner(FileName).useDelimiter("[.,:;()?!\"\\s--]+");;
           
       if(FileName.canRead())//continues if there is a readable filename
        {
            while (Cursor.hasNext()) //keep reading until cursor has reached end of document
            {
                String Word = Cursor.next();//capturing the next word in text
                Word=formatWords(Word);//filter out single words;
                
                if(Word !="Null" && wordMap.containsKey(Word)) //if this is another instance of the word we have encountered
                {
                    // if word instance exists --> increment the number of appearances +1
                    Integer count = (Integer)wordMap.get(Word);
                    wordMap.put(Word, new Integer(count.intValue() + 1));
                } 
                else  
                    //if (Word !=" Null")
                    wordMap.put(Word, new Integer(1));//New word at last -> add to the Map and make occurence=1            
            }
            Cursor.close();//closing file 
        }
        Cursor.close();
        return wordMap;
    }
//---------------------------------------------------------Write the word report into text file
    //create a text file to which output will be written
    public static void writeToTextFile(HashMap wordMap, ArrayList listOfWords ) throws FileNotFoundException
    {  
        File output = new File("WordReport.txt");
        if(output.exists())//if filename exists -> ask user about overwriting it
            {
                Scanner userInput = new Scanner( System.in );
                System.out.println("File already exists");
                System.out.println("Enter the NUMBER '1' to overwrite the file");
                System.out.println("----------------------------------------");
                String Input = userInput.next();
                if (!"1".equals(Input))//if user doesn't enter 1
                    {
                        System.out.println("Remove/Rename the file in directory with same name try again");
                        
                    }
                    else//green light to overwrite given by user
                        {
                            PrintWriter outWriter = new PrintWriter(output);                                 
                            outWriter.println("Words -------------------------Count of Appearance In text");
                            int x=0;
                            Iterator<String> Parser = listOfWords.iterator();
                            while(Parser.hasNext())
                            {   
                                String Word = Parser.next();//Next Word 
                                String Appearance = wordMap.get(Word).toString();//count in text
                                    outWriter.print(x+" : "+Word);
                                    for(int n=0;n<(30 - Word.length());n++)
                                            outWriter.print("-");
                                    outWriter.print(" -> " + Appearance);                     
                                    x++;//Counts Number of words
                                    outWriter.println();//new line per word
                            }
                            outWriter.close();
                        }
            }
            else 
                { // create and write to the said filename;
                    PrintWriter outWriter = new PrintWriter(output);
                    outWriter.close();
                }
    }

//-----------------------------------------------------------Printer function
    /**
     * 
     * printer represents a function in the system that displays the hashmap 
     *@param Words : takes in the hashmap of words to print them out
     *@param listOfWord : ArrayList of the hash keys(words) in sorted order
     * 
     */
    static void printer(HashMap Words, ArrayList listOfWords )
    {
        System.out.println("----------------------------------------");
        for (int i = 0; i < listOfWords.size(); i++) 
        {
            String key = (String)listOfWords.get(i);//parse the sorted Arraylist of words
            Integer count = (Integer)Words.get(key);//pick the count of the word specified from hashmap(O(n)=1)
            System.out.println(key + "---------- " + count);//Displaying the word-count pairs per line
        }
        System.out.println("----------------------------------------");
        //System.out.println(" arraylist size --> "+listOfWords.size());
        //System.out.println(" Hasmap size size --> "+Words.size());
    }  
//---------------------------------------------------------------------MAIN()         
    /**
    *@param args[1] -command line argument[1] which would be name of sample document
    *
    *Here lies the main program
    */
    public static void main(String[] args) throws FileNotFoundException 
    { 
        File Filename = new File("Sample.txt");//args[1]);     
        //pass file name to the method and get mapping of words to count of appearance 
        HashMap wordMap = createHashMapofWords(Filename);
        //creating sorted arraylist of the words
        ArrayList listOfWords = new ArrayList(wordMap.keySet());
        //and having it sorted alphabetically using collections.arraylist.sort 
        Collections.sort(listOfWords);
        //print to cosole
        //printer(wordMap,listOfWords);
        writeToTextFile(wordMap, listOfWords);

     
         //System.out.println("--------------END --------------------------");
    }

}

