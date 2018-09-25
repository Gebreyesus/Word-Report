
package gebru.project1;

/**
* @ Author: Beteab G. Gebru
* Class: Compilers I
* Project title: Word analysis on a word file
*/

public class Gebru_wordCounter 
{
    /**
     * @param fileName- the command line argument provided by user(the name of the file to be analysed
     */
    public static void main(String[] fileName) 
	{
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
