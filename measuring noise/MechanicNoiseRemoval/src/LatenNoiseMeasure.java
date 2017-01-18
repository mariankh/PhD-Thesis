import java.io.IOException;
import java.net.MalformedURLException;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlSubmitInput;
import com.gargoylesoftware.htmlunit.html.HtmlTextInput;


public class LatenNoiseMeasure {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws MalformedURLException 
	 * @throws FailingHttpStatusCodeException 
	 */
	
	public static void main(String[] args) throws FailingHttpStatusCodeException, MalformedURLException, IOException {
		// TODO Auto-generated method stub
	
		final WebClient webClient = new WebClient(BrowserVersion.FIREFOX_3_6);         
   //     webClient.setJavaScriptEnabled(true);
        webClient.getCookieManager().setCookiesEnabled(true);


     try{   final HtmlPage page1 =  webClient.getPage("http://reviewskeptic.com");
     
     
     System.out.println(page1.getForms());

         // Get the form that we are dealing with and within that form, 
         // find the submit button and the field that we want to change.
         final HtmlForm form = page1.getForms().get(0);

         final HtmlSubmitInput button = form.getInputByName("submit");
         final HtmlTextInput textField = form.getInputByName("review_text");

         // Change the value of the text field
         textField.setValueAttribute("root");

         // Now submit the form by clicking the button and get back the second page.
         final HtmlPage page2 = button.click();
         System.out.println(page2.asText());
     
     
     }
     catch (Exception e) {
    	 System.out.println("exception" + e);
        }
		    
	}
	

	    

	
	

}
