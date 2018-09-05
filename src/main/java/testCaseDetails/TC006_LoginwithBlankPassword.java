package testCaseDetails;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import dmsMethod.CommonMethod;

public class TC006_LoginwithBlankPassword extends CommonMethod{
	
	@BeforeClass
	public void setData() {
		testCaseName = "TC006_LoginwithBlankPassword";
		testCaseDescription ="LoginFailcase";
		category = "Regrssion Testing";
		author= "Magesh";
	}
	@Test
	public void loginWithBlankPassword()	
	{
		startApp("chrome", "http://172.16.0.74/DMS_DOC/");
		WebElement eleUserName = locateElement("id", "username");
		type(eleUserName, "isolve");
		WebElement elePassword = locateElement("id","password");
		type(elePassword, " ");
		WebElement eleLogin = locateElement("id","btnSubmit");
		click(eleLogin);
		closeBrowser();
		
	}

}
