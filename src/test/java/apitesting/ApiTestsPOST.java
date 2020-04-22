package apitesting;
import org.testng.annotations.Test;
import org.testng.Assert;
import java.util.HashMap;
import reusablefunctions.ReusableFunctions;

public class ApiTestsPOST {
	private HashMap<String,Object> hmapheaders = new HashMap<String,Object>();
	private HashMap<String,Object> hmapparams = new HashMap<String,Object>();
	public ReusableFunctions objReusableFunctions = new ReusableFunctions();

	// Test Case to validate the POST request. 
	@Test
	public void postCreateNewDeckOfCardsTest01() {	
		hmapheaders.put("Content-Type" , "application/json");
		hmapparams.put("jokers_enabled","false");
		objReusableFunctions.setHmapHeaders(hmapheaders);
		objReusableFunctions.setHmapParams(hmapparams);
		objReusableFunctions.setIntExpectedStatusCode(200);
		objReusableFunctions.setStrUrl("/new");
		boolean responseresult = objReusableFunctions.postCreateNewDeckOfCards();
		Assert.assertEquals(responseresult, true);		

	}

	// Negative Case : Check if the wrong URL is appropriately handled by the server.
	@Test
	public void postCreateNewDeckOfCardsTest02() {	
		hmapheaders.put("Content-Type" , "application/json");
		hmapparams.put("jokers_enabled","false");
		objReusableFunctions.setHmapHeaders(hmapheaders);
		objReusableFunctions.setHmapParams(hmapparams);
		objReusableFunctions.setIntExpectedStatusCode(503);
		objReusableFunctions.setStrUrl("ew");
		boolean responseresult = objReusableFunctions.postCreateNewDeckOfCards();
		Assert.assertEquals(responseresult, false);		

	}

}
