package testCaseDetails;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import dmsMethod.CommonMethod;

public class TC002_LoginFailwithUserneme extends CommonMethod {

		
		@BeforeClass
		public void setData() {
			testCaseName = "TC002_LoginFailwithUserneme";
			testCaseDescription ="LoginFailcase";
			category = "Functional Testing";
			author= "Kumar";
		}
		@Test
		public void LoginFailwithUserneme() {	
		startApp("chrome", "http://172.16.0.74/DMS_DOC/");
		WebElement eleUserName = locateElement("id","username");
		type(eleUserName, "isolvess");
		getText(eleUserName, "isolves");
		WebElement elePassword = locateElement("id","password");
		type(elePassword, "iSolve123$");
		WebElement eleLogin = locateElement("id","btnSubmit");
		click(eleLogin);
		closeBrowser();		
		WebElement eleverify = locateElement("LinkText","Error");
		verifyPartialText(eleUserName, "isolve");
	}		
}







