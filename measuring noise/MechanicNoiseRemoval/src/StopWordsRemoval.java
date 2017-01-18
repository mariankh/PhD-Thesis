import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;


public class StopWordsRemoval {

	//read file into vector
	public Vector<String> loadStopWords(File file) throws IOException{
		Vector<String> stopwords = new Vector<String>();
		  FileReader inputFile = new FileReader(file);
          BufferedReader bufferReader = new BufferedReader(inputFile);
          String line;
          while ((line = bufferReader.readLine()) != null)   {
        	  stopwords.add(line);
          }
		
		
		
		return stopwords;
		
		
	}
	
}
