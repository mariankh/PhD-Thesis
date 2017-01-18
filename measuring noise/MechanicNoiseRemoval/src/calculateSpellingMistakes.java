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

import org.xeustechnologies.googleapi.spelling.Configuration;
import org.xeustechnologies.googleapi.spelling.Language;
import org.xeustechnologies.googleapi.spelling.SpellChecker;
import org.xeustechnologies.googleapi.spelling.SpellCorrection;
import org.xeustechnologies.googleapi.spelling.SpellRequest;
import org.xeustechnologies.googleapi.spelling.SpellResponse;


public class calculateSpellingMistakes {

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
		int from=0;
		int to=100;
		int c=0;
		int reviews=0;
		int numberofreviewswithspellings=0;
		while ((text = br.readLine()) != null) {
			reviews++;
					//text=text.replaceAll("[^a-zA-Z ]", "");
					JazzySpellChecker jazzy = new JazzySpellChecker();
					jazzy.initialize();
					ArrayList<String>  mistakes = null;
			    	mistakes=jazzy.getMisspelledWords(text);
			    	if(mistakes.size()>0){
			    		numberofreviewswithspellings++;
			    	}
			    	all_mistakes.addAll(mistakes);
			    	Set<String> uniqueWords = new HashSet<String>(mistakes);
			    	//=uniqueWords.size();
			    	unique_list.addAll(uniqueWords);
			    	c+=getNumberofWords(text);
			    	textcount++;
			    	jazzy.initialize();
			    	int count=jazzy.countWords(text);
			    	
			    	wordscount+=count;
			    	
			    	
		}
		
		
		//System.out.println("all mistakes" + all_mistakes);
		//System.out.println("all mistakes" + uniqueWords_m);
		System.out.println("all mistakes=" + all_mistakes.size());
		System.out.println("words with mistakes =" + unique_list.size());
		System.out.println("all words=" + wordscount);
		System.out.println("all reviews with atleast mistake=" + numberofreviewswithspellings);
		System.out.println("all reviews=" + reviews);
		
	
		
		
		
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