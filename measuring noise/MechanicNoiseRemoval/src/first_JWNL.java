import java.io.*;

import net.didion.jwnl.*;
import net.didion.jwnl.data.IndexWord;
import net.didion.jwnl.data.IndexWordSet;
import net.didion.jwnl.data.POS;
import net.didion.jwnl.data.Synset;
import net.didion.jwnl.dictionary.Dictionary;

import java.util.HashSet;
import java.util.Set;
import java.util.List;
/**
*
* @author Prudhvi
*/
public class first_JWNL {
   
    //public String getsyns(String inputword) throws JWNLException, IOException
    public static void main(String args) throws JWNLException, IOException
    {
         JWNL.initialize(new FileInputStream("file_properties.xml"));
         Dictionary wordnet = Dictionary.getInstance();
        
         //IndexWord s = wordnet.
         IndexWordSet set = wordnet.lookupAllIndexWords("ele");
         // Turn it into an array of IndexWords
         
        
         Set<String> synonyms = new HashSet<String>();
         //IndexWord indexWord = wordnet.lookupIndexWord(POS.NOUN, "wife");
        //IndexWord indexWord = wordnet.lookupIndexWord(p, "director");
         //Synset[] synSets = indexWord.getSenses();
        
    }
}