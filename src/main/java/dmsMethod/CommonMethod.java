package dmsMethod;

import static org.testng.Assert.assertTrue;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import DmsTestingReport.ReportDms;

public class CommonMethod extends ReportDms implements WebMethods {

	public int i = 1;
	public RemoteWebDriver driver;
	
	public void startApp(String browser, String url) {
		try {
			if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				driver = new ChromeDriver();
			} else if (browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
				driver = new FirefoxDriver();
			}
			driver.get(url);
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			System.out.println("The Browser " + browser + " Launched Successfully");
		} catch (WebDriverException e) {
			System.err.println("The Browser " + browser + " not Launched");
		} finally {
			takeSnap();
		}

	}
	public boolean PageTitle(String titile) {
		return true;
	}

	public WebElement locateElement(String locator, String locValue) {
		try {
			switch (locator) {
			case "id":
				return driver.findElementById(locValue);
			case "name":
				return driver.findElementByName(locValue);
			case "ClassName":
				return driver.findElementByClassName(locValue);
			case "LinkText":
				return driver.findElementByLinkText(locValue);
			case "PartialLinkText":
				return driver.findElementByPartialLinkText(locValue);
			case "CssSelector":
				return driver.findElementByCssSelector(locValue);
			case "TagName":
				return driver.findElementByTagName(locValue);
			case "xpath":
				return driver.findElementByXPath(locValue);
			}
		} catch (NoSuchElementException e) {
			// System.err.println("The Element is not found");
			reportStep("The Element is not found", "fail");
		} catch (Exception e) {
			// System.err.println("Unknow Exception ");
			reportStep("Unknow Exception ", "fail");
		}
		return null;
	}

	public WebElement locateElement(String locValue) {
		// TODO Auto-generated method stub
		return null;
	}

	public void type(WebElement ele, String data) {
		try {
			ele.sendKeys(data);
			// System.out.println("The data " + data + " is Entered Successfully");
			reportStep("Enter value " + data + "is succssfully", "pass");
		} catch (WebDriverException e) {
			ele.sendKeys(data);
			// System.out.println("The data " + data + " is Not Entered");
			reportStep("Enter value " + data + "is worng ", "fail");
		
		} finally {
			takeSnap();
		}
	}

	public void clickWithNoSnap(WebElement ele) {
		try {
			ele.click();
			// System.out.println("The Element " + ele + " Clicked Successfully");
			reportStep("Element Clicked Successfully", "pass");
		} catch (Exception e) {
			// System.err.println("The Element " + ele + "is not Clicked");
			reportStep("Element not Clicked", "fail");
		}
	}

	public void click(WebElement ele) {
		try {
			ele.click();
			// System.out.println("The Element " + ele + " Clicked Successfully");
			reportStep("Element Clicked " + ele + " Entered Successfully", "pass");
		} catch (WebDriverException e) {
			// System.err.println("The Element " + ele + "is not Clicked");
			reportStep("Element not Clicked", "fail");
		} finally {
			takeSnap();
		}
	}

	public String getText(WebElement ele,String text) {
		String bodyText = ele.getText();
		Assert.assertEquals("Text not found!", bodyText.equals(text));
		reportStep("Text not found", "fail");
		return bodyText;
	}

	public void selectDropDownUsingText(WebElement ele, String value) {
		try {
			Select dd = new Select(ele);
			dd.selectByVisibleText(value);
			System.out.println("The DropDown Is Selected with VisibleText " + value);
		} catch (Exception e) {
			System.err.println("The DropDown Is not Selected with VisibleText " + value);
		} finally {
			takeSnap();
		}
		try {
			Select dd = new Select(ele);
			// dd.selectByIndex(value);
			System.out.println("The DropDown Is Selected with Visibleindex " + value);
		} catch (Exception e) {
			System.err.println("The DropDown Is not Selected with Visibleindex " + value);
		} finally {
			takeSnap();
		}
		try {
			Select dd = new Select(ele);
			dd.selectByValue(value);
			System.out.println("The DropDown Is Selected with Visiblevalue " + value);
		} catch (Exception e) {
			System.err.println("The DropDown Is not Selected with Visiblevalue " + value);
		} finally {
			takeSnap();
		}
	}

	public void selectDropDownUsingIndex(WebElement ele, int index) {
		// TODO Auto-generated method stub

	}

	public boolean verifyTitle(String expectedTitle) {
		// TODO Auto-generated method stub
		return false;
	}

	public void verifyExactText(WebElement ele, String expectedText) {
		// TODO Auto-generated method stub

	}

	public void verifyPartialText(WebElement ele, String expectedText) {
		try {
			String text = ele.getText();
			if (text.equals(expectedText)) {
				//System.out.println("Text matched");
				reportStep("Text matched", "Pass");
			}else
			{
				//System.out.println("Text not matched");
				reportStep("Text not matched", "fail");
			}
		} catch (Exception e) {
			reportStep("Text not matched", "fail");
		} 
		
	}
	public void verifyExactAttribute(WebElement ele, String attribute, String value) {
		// TODO Auto-generated method stub

	}

	public void verifyPartialAttribute(WebElement ele, String attribute, String value) {
		// TODO Auto-generated method stub

	}

	public void verifySelected(WebElement ele) {
		// TODO Auto-generated method stub

	}

	public void verifyDisplayed(WebElement ele) {
		// TODO Auto-generated method stub

	}

	public void switchToWindow(int index) {

		Set<String> allwinodws = driver.getWindowHandles();
		List<String> list = new ArrayList<String>();
		list.addAll(allwinodws);
		driver.switchTo().window(list.get(0));
	}

	private RemoteWebDriver getWebDriver() {
		// TODO Auto-generated method stub
		return null;
	}

	public void switchToFrame(WebElement ele) {
		// TODO Auto-generated method stub

	}

	public void acceptAlert() {

		driver.switchTo().alert().accept();
	}

	public void dismissAlert() {

		driver.switchTo().alert().dismiss();

	}

	public String getAlertText() {

		return null;
	}

	public void takeSnap() {
		File src = driver.getScreenshotAs(OutputType.FILE);
		File des = new File("./snaps/img" + i + ".png");
		try {
			FileUtils.copyFile(src, des);
		} catch (IOException e) {
			System.err.println("IOException");
		}
		i++;
	}

	public void closeBrowser() {
		driver.close();
	}

	public void closeAllBrowsers() {
		driver.quit();

	}
	@Override
	public void acceptAlert(WebElement ele) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String getText(WebElement ele) {
		// TODO Auto-generated method stub
		return null;
	}

}

