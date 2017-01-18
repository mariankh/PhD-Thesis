import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;


public class CalculateMechanicNoise {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

			int data_count = 0;
			int stop_count = 0;
			int an_count = 0 ; 
			int wordNet_count =0;
			File stop_words_file = new File("stopwords");
			File dataset = new File("t1_token");
			Vector<String>  stopwords = loadWords(stop_words_file);
			Vector<String>  data = loadWords(dataset);
			
			data_count=data.size();
			
			Vector<String>  data_no_stop = removeStopWords(data,stopwords);
			stop_count = data_count - data_no_stop.size();
			
			
			Vector<String> data_in_wordNet = inWordNet(data);
			
			wordNet_count = data_in_wordNet.size();
			
			Vector<String> data_no_wordNet = noWordNet(data);
			
			int pan= getPanc(data_no_wordNet);
			
			System.out.println(" data count " + data_count);
			System.out.println(" stop count " + stop_count);
			System.out.println(" wordNet count " + wordNet_count);
			System.out.println(" pan count " + pan);
			System.out.println(" other count " + (data_no_wordNet.size() -pan));
			
	}
	
	private static int getPanc(Vector<String> data) {
		int pan =0;
	
		for (String s: data){
			if(!Character.isLetter(s.charAt(0)) ){
				pan++;
				System.out.println(s);
			}
			//else
				//System.out.println(s);
		}
		
				
				
		return pan;
	}

	private static Vector<String> inWordNet(Vector<String> data) {
		WordNetTest.configureJWordNet();
		
		Vector<String> newvector = new Vector<String>();
		for(String s: data){
			if(WordNetTest.isonWordNet(s)){
				newvector.add(s);
			}
				
		}
		return newvector;
		
	}
	
	private static Vector<String> noWordNet(Vector<String> data) {
		WordNetTest.configureJWordNet();
		
		Vector<String> newvector = new Vector<String>();
		for(String s: data){
			if(!WordNetTest.isonWordNet(s)){
				newvector.add(s);
			}
				
		}
		return newvector;
		
	}
	
	private static Vector<String> removeStopWords(Vector<String> data,
			Vector<String> stopwords) {
		// TODO Auto-generated method stub
		int stopword_count = 0;
		Vector<String> newvector = new Vector<String>();
		for(String d : data){
			if(stopwords.contains(d))
			{
				stopword_count++;
			}
			else {
				newvector.add(d);
			}
			
		}
	
		return newvector;
	}



		//read file into vector
		public static Vector<String> loadWords(File file) throws IOException{
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
