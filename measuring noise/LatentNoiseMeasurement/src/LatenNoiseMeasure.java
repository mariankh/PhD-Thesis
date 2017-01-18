import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlSubmitInput;
import com.gargoylesoftware.htmlunit.html.HtmlTextArea;


public class LatenNoiseMeasure {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws MalformedURLException 
	 * @throws FailingHttpStatusCodeException 
	 */
	
	   static HtmlSubmitInput button = null;
	  static HtmlTextArea  textField = null;
	public static void main(String[] args) throws FailingHttpStatusCodeException, MalformedURLException, IOException {
		// TODO Auto-generated method stub
	
		final WebClient webClient = new WebClient(BrowserVersion.FIREFOX_31);      
	
        webClient.getCookieManager().setCookiesEnabled(true);
        webClient.getOptions().setJavaScriptEnabled(true); webClient.getOptions().setThrowExceptionOnScriptError(false);
        int deceptive=0;
        int notdeceptive=0;
     try{    HtmlPage page1 =  (HtmlPage) webClient.getPage("http://reviewskeptic.com");
     
     
    // System.out.println(page1.asXml());

         // Get the form that we are dealing with and within that form, 
         // find the submit button and the field that we want to change.
         HtmlForm form = (HtmlForm) page1.getForms().get(0);

         button = (HtmlSubmitInput) form.getInputByValue("Test It");
          textField = form.getTextAreaByName("review_text");
 
         BufferedReader br = new BufferedReader(new FileReader("reviews.txt"));
         String text="";
         while ((text = br.readLine()) != null) {
        	 
         
         if(isDeceptive(text)){
        	 deceptive++;
         	}
         else notdeceptive++;

         }

      //   page1.executeJavaScript("javascript:submitForm(document.getElementById('localLogin'), 'submit');");
     }
     catch (Exception e) {
    	 System.out.println("exception" + e);
        }
		    
     
System.out.println("deceptive:" + deceptive);       
 
System.out.println("not deceptive:" + notdeceptive);    
      
	
       
	}
	

	   

	private static boolean isDeceptive(String string) throws IOException, InterruptedException {
		 // Change the value of the text field
		
        textField.setTextContent(string);
        
        // Now submit the form by clicking the button and get back the second page.
//   HtmlPage page2 = (HtmlPage) 
        //button.click();
      //  webClient.waitForBackgroundJavaScript(1000);
        Thread.sleep(1000);
    HtmlPage page2 =   (HtmlPage) button.click();
       if( page2.asXml().contains(" Deceptive")) {
		return true;
       }
       return false;
	}
}