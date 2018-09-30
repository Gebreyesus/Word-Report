    package words;
    import java.util.*; //INCLUDING ALL LIBRARIES UNDER ....
    import java.io.*;
    
    
    /**
     * the class Words represents a Class file in the system 
     * @ Author: Beteab G. Gebru
     * Class: Compilers I
     * Project title: Word analysis on a word file
     */
    public class Words 
    {
        //Global functions
        public static int totNumofWords = 0;//counts total num of words     

//--------------------------------------------------------------------------------------------Write output to file
      //create a text file object which you will write the output to
//        File output1 = new File("output1.txt");
//        //check whether the file's name already exists in the current directory
//        if(output1.exists())
//        {
//            System.out.println("File already exists");
//            System.exit(0);
//        }
//        PrintWriter pw = new PrintWriter(output1);
//        pw.println("The sum is " + sum);
//        pw.close();
//--------------------------------------------------------------------------------------------convert to array and return sorted
        public static ArrayList convertHashMapTOArray(HashMap Words)
        {  
            // Placed the Hasmap in an array and having it sorted alphabetically  
            ArrayList listOfWords = new ArrayList(Words.keySet()); 
            Collections.sort(listOfWords);
            return listOfWords;
        }
//-------------------------------------------------------------------------------------Write the word report into text file
        //create a text file to which output will be written
        public static void writeToTextFile(HashMap wordMap) throws FileNotFoundException
        {  
            File output = new File("WordReport.txt");
            
            if(output.exists())
            {//if output filename exists ask before overwriting the file
             
             Scanner userInput = new Scanner( System.in );
             System.out.println("File already exists");
             System.out.println("press THE number 1 to overwrite the file");
             String Input = userInput.next();
             
             if (!"1".equals(Input))//if user doesn't enter 1
              {
                System.out.println("Remove/Rename the file in directory with same name try again");
                System.exit(0); //exit program
              }
                else //green light to overwrite -> overwiting existing file
                    {
                        PrintWriter outWriter = new PrintWriter(output); String temp=".. ";
                        
//                        for (int x=0;x<wordMap.size();x++) //write sorted array to file
//                            {
//                             temp = wordMap.get()   ;
//                                pw.println(temp + "         count--->"+wordMap.);
//                            }
//                        for (HashMap.Entry <String, Integer> entry : wordMap.entrySet()) 
//                        {
//                            outWriter.println(entry.getKey() + "\t=>\t" + entry.getValue());
//                        }
                        outWriter.close();
                    }
            }
            else 
            { // create and write to file;
                PrintWriter outWriter = new PrintWriter(output);
                outWriter.close();
            }
            //outWriter.close();
            System.exit(0);
    }
//------------------------------------------------------------------------------------       
        //public static ArrayList checkforErrors()
        //{            
            //    return Words;
        //}
//---------------------------------------------------------------------------------------function to create hash map 
        /**
         * 
         * printer represents a function that outputs the data in the hashmap by formatting it
         *@ param Words : takes in the hashmap of words to print them out
         *
         */
        public static HashMap createHashMapofWords(File FileName)throws FileNotFoundException 
        {
            Scanner Cursor = null;
            //--->check for filename existence in the directory
            try 
            {
                Cursor = new Scanner(FileName); //file(Sample.txt) is opened to be read        
            }
            catch(FileNotFoundException exception)
            {
                System.out.println("The file " + FileName.getPath() + " was not found.");
            }
        
            HashMap<String, Integer> wordMap = new HashMap();  // Map of (key)word --> # of occurrences(count)

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
            Cursor.close();//closing file 

            return wordMap;
        }
//--------------------------------------------------------------------------------------------Printer function
        /**
         * 
         * printer represents a function that formats and outputs the data in the hashmap 
         *@ param Words : takes in the hashmap of words to print them out
         *
         */
         static void printer(HashMap Words)
        {
            //putting the words into an arraylist and sorting them
            ArrayList listOfWords = new ArrayList(Words.keySet());
            Collections.sort(listOfWords);//and having it sorted alphabetically 
            
            for (int i = 0; i < listOfWords.size(); i++) 
            {
                String key = (String)listOfWords.get(i);
                Integer count = (Integer)Words.get(key);
                System.out.println(key + " --> " + count);
            }
        }  
//------------------------------------------------------------------------------------------------------------MAIN()         
        /**
        *@ param args -command line argument which would be the name of the document to be ream
        *
        *Here lies the main program
        */
        public static void main(String[] args) throws FileNotFoundException 
        {
            File Filename = new File("Sample.txt");//(args[0]);
            
            //send the filename to the hasmap function
            HashMap wordMap = createHashMapofWords(Filename);
            writeToTextFile(wordMap);

    //        for (int arrayListIndex=0; arrayListIndex<listOfWords.size();arrayListIndex++)
    //        {
    //            listOfWords[arrayListIndex];
    //            for (int wordNum = 0; wordNum < wordMap.size(); wordNum++)
    //            {
    //                String word = wordMap.get(listOfWords[arrayListIndex].);
    //                word = word.replaceAll("[.,:;()?!\" \t\n\r\']+", "");
    //                lettersPerWord[wordNum] = word.length();
    //                totalLetters = word.length();
    //            }
    //        }
             //we can call the printer if we wanted to display the words  
             printer(wordMap);
             System.out.println(" Total number of words on the text are --> " + totNumofWords );
        }

    }

