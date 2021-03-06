

import java.io.FileInputStream;
import net.didion.jwnl.JWNL;
import net.didion.jwnl.JWNLException;
import net.didion.jwnl.data.IndexWord;
import net.didion.jwnl.data.POS;
import net.didion.jwnl.data.Synset;
import net.didion.jwnl.data.Pointer;
import net.didion.jwnl.data.PointerType;
import net.didion.jwnl.data.Word;
import net.didion.jwnl.dictionary.Dictionary;

/*
Example code from Wicked Cool Java (No Starch Press)
Copyright (C) 2005 Brian D. Eubanks

This library is free software; you can redistribute it and/or
modify it under the terms of the GNU Lesser General Public
License as published by the Free Software Foundation; either
version 2.1 of the License, or (at your option) any later version.

This library is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
Lesser General Public License for more details.

You should have received a copy of the GNU Lesser General Public
License along with this library; if not, write to the Free Software
Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA

Note: The LGPL licence can be found online at http://www.gnu.org

*/
/**
 * This class looks up word senses in JWordnet, and finds holonyms.
 */
public class WordNetTest {
	
	static boolean isonWordNet(String token){

		Dictionary dictionary = Dictionary.getInstance();
		IndexWord word;
		Synset[] senses = null;
		try {
			word = dictionary.lookupIndexWord(POS.NOUN,token);
			
			
		} catch (JWNLException e) {
			// TODO Auto-generated catch block
			
			return false;
		}
		
		try {
			if(word!=null)
			senses = word.getSenses();
			
		} catch (JWNLException e) {
			return false;
		}
		if(senses!=null)
		if(senses.length <1){
			return false;
		}
		if(senses == null)
			return false;
		
		//System.out.println(senses[0]);
	return true;
	}
	
	
	static boolean MultipleSenses(String token){
		
		Dictionary dictionary = Dictionary.getInstance();
		IndexWord word;
		Synset[] senses = null;
		try {
			word = dictionary.lookupIndexWord(POS.NOUN,token);
			
			
		} catch (JWNLException e) {
			// TODO Auto-generated catch block
			
			return false;
		}
		
		try {
			if(word!=null)
			senses = word.getSenses();
			
		} catch (JWNLException e) {
			return false;
		}
		if(senses!=null)
		if(senses.length <2){
			return false;
		}
		if(senses == null)
			return false;
		
		//System.out.println(senses[0]);
	return true;
	}
	

	public static void main(String[] args) throws JWNLException {
		configureJWordNet();
		System.out.println(isonWordNet("ANIMAL"));		
		configureJWordNet();
		Dictionary dictionary = Dictionary.getInstance();
		IndexWord word = dictionary.lookupIndexWord(POS.NOUN, "stop");
		
		Synset[] senses = word.getSenses();
		if(senses.length>1)
			System.out.println("multiple senses" +senses.length);
	/*	for (int i=0; i<senses.length; i++) {
		  Synset sense = senses[i];
		  System.out.println((i+1) + ". " + sense.getGloss());
		  Pointer[] holo = sense.getPointers(PointerType.PART_HOLONYM);
		  for (int j=0; j<holo.length; j++) {
		    Synset synset = (Synset) (holo[j].getTarget());
		    Word synsetWord = synset.getWord(0);
		    System.out.print("  -part-of-> " + synsetWord.getLemma());
		    System.out.println(" = " + synset.getGloss());
		  }
		}*/
	}
	
	public static void configureJWordNet() {
		// WARNING: This still does not work in Java 5!!!
		try {
			// initialize JWNL (this must be done before JWNL can be used)
			// See the JWordnet documentation for details on the properties file
			JWNL.initialize(new FileInputStream("file_properties.xml"));
		} catch (Exception ex) {
			ex.printStackTrace();
			System.exit(-1);
		}
	}
	
}