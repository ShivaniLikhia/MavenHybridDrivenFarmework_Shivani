package base;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import customException.InvalidLocatorException;

public class ControlActions {
	
	protected static WebDriver driver;
	protected static WebDriverWait wait;
	
	public static void start() {
		System.setProperty("webdriver.chrome.driver",".//src/main/resources/resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://shivanilikhia-trials710.orangehrmlive.com/auth/login");
		wait = new WebDriverWait(driver, 30);
	}
	protected WebElement getElement(String locatorType, String locatorValue, boolean isWaitRequired) {
		locatorType = locatorType.toUpperCase();
		WebElement element = null;
		switch(locatorType) {
		case "XPATH" :
			if(isWaitRequired) {
				element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorValue)));
			}
			else {
				element = driver.findElement(By.xpath(locatorValue));
			}
			break;
		
		case "CSS" :
			if(isWaitRequired) {
				element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locatorValue)));
			}
			else {
				element = driver.findElement(By.cssSelector(locatorValue));
			}
			break;
			
		case "ID" :
			if(isWaitRequired) {
				element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locatorValue)));
			}
			else {
				element = driver.findElement(By.id(locatorValue));
			}
			break;
			
		case "LINKTEXT" :
			if(isWaitRequired) {
				element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(locatorValue)));
			}
			else {
				element = driver.findElement(By.linkText(locatorValue));
			}
			break;
		
		case "PARTIALLINKTEXT" :
			if(isWaitRequired) {
				element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(locatorValue)));
			}
			else {
				element = driver.findElement(By.partialLinkText(locatorValue));
			}
			break;
			
		case "CLASSNAME" :
			if(isWaitRequired) {
				element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(locatorValue)));
			}
			else {
				element = driver.findElement(By.className(locatorValue));
			}
			break;
			
		case "TAGNAME" :
			if(isWaitRequired) {
				element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName(locatorValue)));
			}
			else {
				element = driver.findElement(By.tagName(locatorValue));
			}
			break;
			
		case "NAME" :
			if(isWaitRequired) {
				element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(locatorValue)));
			}
			else {
				element = driver.findElement(By.name(locatorValue));
			}
			break;
			
		default : 
			throw new InvalidLocatorException("Locator Type : " +locatorType+ "is invalid");
		}
		return element; 
	}
	
	
	protected boolean isElementDisplayed(String locatorType, String locatorValue, boolean isWaitRequired) {
		try {
			WebElement e = getElement(locatorType, locatorValue, isWaitRequired);
			return e.isDisplayed();
		}catch(Exception ne) {
			return false;
		}
	}
	
	protected boolean isElementDisplayed(WebElement element) {
		waitForWebElementToBeVisible(element);
		return element.isDisplayed();
	}
	
	private void waitIfRequired(WebElement element, boolean isWaitRequired) {
		if(isWaitRequired) {
			wait.until(ExpectedConditions.visibilityOf(element));
		}
	}
	
	protected List<String> getListOfWebElementText(String Locator){
		List<WebElement> listOfElements = driver.findElements(By.xpath(Locator));
		List<String> lisOfElementsText = new ArrayList<>();
		
		for(WebElement e : listOfElements) {
			lisOfElementsText.add(e.getText());
		}
		return lisOfElementsText;
	}
	
	protected List<String> getListOfWebElements(List<WebElement> list){
		List<String> listOfElements = new ArrayList<>();
		for(WebElement e : list) {
			listOfElements.add(e.getText());
		}
		return listOfElements;
	}
	
	protected void mouseHover(String locatorType, String locatorValue) {
		WebElement e = getElement(locatorType, locatorValue, true);
		mouseHover(e);
	}
	
	protected void mouseHover(WebElement e) {
		Actions action = new Actions(driver);
		action.moveToElement(e).build().perform();
	}
	
	protected WebElement waitForWebElementToBeVisible(String locatorType, String locatorValue) {
		return getElement(locatorType,locatorValue,true);
	}
	
	protected WebElement waitForWebElementToBeVisible(WebElement e) {
		return wait.until(ExpectedConditions.visibilityOf(e));
	}
	
	protected List<WebElement> waitForWebElementsToBeVisible(List<WebElement> list){
		return wait.until(ExpectedConditions.visibilityOfAllElements(list));
	}
	
	protected void setText(String textToBeSent, WebElement element, boolean isWaitRequired) {
		waitIfRequired(element, isWaitRequired);
		element.sendKeys(textToBeSent);	
	}
	
	protected void clickOnElement(WebElement e, boolean isWaitRequired) {
		waitIfRequired(e, isWaitRequired);
		e.click();
	}
	
	protected String getElementText(WebElement e, boolean isWaitRequired) {
		if(isWaitRequired) {
			waitIfRequired(e, isWaitRequired);
			return e.getText();
		}
		else {
			return e.getText();
		}
	}
	
	protected String getElementText(String locatorType, String locatorValue, boolean isWaitRequired) {
		WebElement e = getElement(locatorType,locatorValue,isWaitRequired);
		return e.getAttribute("value");
	}
	
	public static void closeBrowser() {
		driver.close();
	}
	
}
