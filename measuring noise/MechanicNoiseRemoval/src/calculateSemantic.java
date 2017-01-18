import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;



public class calculateSemantic {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		
		int all_guessed=0;
		BufferedReader br = new BufferedReader(new FileReader("reviews.txt"));
		String text;
		int textcount=1;
		int wordscount=0;
		
		int mistakessize= 0;
		int wordswithmistakes=0;
		Set<String> unique_list = new HashSet<String>();
		ArrayList<String>  all_mistakes = new ArrayList<String> ();
		int wordnet=0;
		int multiple=0;
		int count=0;
		WordNetTest.configureJWordNet();
		while ((text = br.readLine()) != null) {
		
					//text=text.replaceAll("[^a-zA-Z ]", "");

				String []parts = text.split(" ");
		        for( String w : parts)
		        {
		        	if(WordNetTest.isonWordNet(w)) wordnet++;
		        	if(WordNetTest.MultipleSenses(w)) multiple++;
		       		count++;        
		        }
			    	
			    	
		}
		
		
		//System.out.println("all mistakes" + all_mistakes);
		//System.out.println("all mistakes" + uniqueWords_m);
		System.out.println("nouns in wordnet =" + wordnet);
		System.out.println(" nouns with multiple senses =" + multiple);
		System.out.println("all words=" + count);
		
	
		
		
		
	}
	
	static int getNumberofWords(String line) throws FileNotFoundException{
		int count=0;
		
		String []parts = line.split(" ");
        for( String w : parts)
        {
   
       		count++;        
        }
        
	//	System.out.println(count);
		return count;
		
		
	}
	
}
