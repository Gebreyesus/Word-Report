
package gebru.project1;

/**
* @ Author: Beteab G. Gebru
* Class: Compilers I
* Project title: Word analysis on a word file
*/
import java.util.*; //INCLUDING ALL LIBRARIES UNDER 
import java.io.*; 
import java.io.Console;
import  java.util.Arrays;
import java.io.IOException;

public class Gebru_wordCounter 
{
	
	//will store a mapping of word to its count in text
	public static Map<String, Integer> wordMap = new HashMap<String, Integer>();
	
	
	
	static void wordAnalyser(File file)
	{
		
	}
		
	
	
	
	
	
	
	
	
	
    /**
     *
	 * @param args- the command line argument provided by user(the name of the file to be analysed
     */
	
	public static void main(String[] args)
	 {
      string file = args[0] + "";
      File a = new File(file);
      //Scanner in = new Scanner(a);

      wholeFile(a);  
	  }
  
  
  
  
  
  
  
  
  
  
  
  
  
    public static void main()//String[] fileName)
	{
		string fileName ;
		System.out.println("Enter name of file");
		fileName = System.in
		File file = new File("sample.txt");
		
		
		try(Scanner sc = new Scanner(new FileInputStream(file)))
		{
    			int count=0;
    			while(sc.hasNext())
			{
        			sc.next();
        			count++;
			}
	 	   System.out.println("Number of words: " + count);
       	}
    }   
}
