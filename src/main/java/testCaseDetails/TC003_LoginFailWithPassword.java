package testCaseDetails;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import dmsMethod.CommonMethod;

public class TC003_LoginFailWithPassword extends CommonMethod {
	
	@BeforeClass
	public void setData() {
		testCaseName = "TC003_LoginFailWithPassword";
		testCaseDescription ="LoginFailcase";
		category = "Functional Testing";
		author= "Arun";
	}
	@Test
	public void loginFailWithPassword()	
	{
		startApp("chrome", "http://172.16.0.74/DMS_DOC/");
		WebElement eleUserName = locateElement("id", "username");
		type(eleUserName, "isolves");
		WebElement elePassword = locateElement("id","password");
		type(elePassword, "DMS123$s");
		WebElement eleLogin = locateElement("id","btnSubmit");
		click(eleLogin);
		closeBrowser();
	}
}
