package testCaseDetails;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import dmsMethod.CommonMethod;

public class TC005_LoginwithBlankUsername extends CommonMethod {
	
	@BeforeClass
	public void setData() {
		testCaseName = "TC005_LoginwithBlankUsername";
		testCaseDescription ="LoginFailcase";
		category = "Regrssion Testing";
		author= "Magesh";
	}
	@Test
	public void loginWithBlankUsername()	
	{
		startApp("chrome", "http://172.16.0.74/DMS_DOC/");
		WebElement eleUserName = locateElement("id", "username");
		type(eleUserName, " ");
		WebElement elePassword = locateElement("id","password");
		type(elePassword, "DMS123$s");
		WebElement eleLogin = locateElement("id","btnSubmit");
		click(eleLogin);
		closeBrowser();
	}
	
}
