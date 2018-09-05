package testCaseDetails;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import dmsMethod.CommonMethod;

public class TC001_DmsLogin extends CommonMethod  {
    
	@BeforeClass
	public void setData() {
		testCaseName = "TC001_LoginPass";
		testCaseDescription ="LoginPass";
		category = "Functional Testing";
		author= "Kumar";
	}
	@Test
	public void LoginPass() {
		startApp("chrome", "http://172.16.0.74/DMS_DOC/");
		WebElement eleUserName = locateElement("id", "username");
		type(eleUserName, "isolve");
		
		WebElement elePassword = locateElement("id","password");
		type(elePassword, "iSolve123$");
		WebElement eleLogin = locateElement("id","btnSubmit");
		click(eleLogin);
		WebElement eleLogout = locateElement("xpath","//*[@data-toggle='modal']");
		click(eleLogout);
		WebElement eleLogoutt = locateElement("xpath","//*[text='Logout']");		
		click(eleLogoutt);
		closeBrowser();
	}
	@AfterSuite
	public void Close()
	{
		closeAllBrowsers();
	}
	
}
	
	
	
	
	
	
	
	
	
	
	