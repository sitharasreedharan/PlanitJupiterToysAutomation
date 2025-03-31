package com.utility;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public abstract class BrowserUtility {

	
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	private WebDriverWait wait;
	
	public WebDriver getDriver() {	
		return driver.get();
	}

	public BrowserUtility(WebDriver driver) {
		super();
		this.driver.set(driver);		
	}

	public BrowserUtility(String browserName) {
		if (browserName.equalsIgnoreCase(("chrome"))) {		
			driver.set(new ChromeDriver());
		} 
		else if (browserName.equalsIgnoreCase(("edge"))) {			
			driver.set(new EdgeDriver());
		} 
		else if (browserName.equalsIgnoreCase(("firefox"))) {			
			driver.set(new FirefoxDriver());
		} 
		else {
			System.err.print("Invalid Browser name.Please select chrome or edge or firefox");
		}
	}
	public BrowserUtility(String browserName,boolean isHeadless) {
		 switch (browserName.toLowerCase()) {
         case "chrome":
             initializeChromeDriver(isHeadless);
             break;
         case "edge":
             initializeEdgeDriver(isHeadless);
             break;
         case "firefox":
             initializeFirefoxDriver(isHeadless);
             break;
         default:
             System.err.println("Invalid Browser name. Please select chrome, edge, or firefox.");
             break;
     }
	}


	public void goToWebsite(String url) {
		driver.get().get(url);
	}

	public void maximizeWindow() {
		driver.get().manage().window().maximize();
	}

	public void clickOn(By locator) {		
		driver.get().findElement(locator).click();
	}
	
	
	public void enterText(By locator, String text) {
		driver.get().findElement(locator).sendKeys(text);
	}
	public void enterText(By locator, String text, int waitInSeconds) {
	    WebDriverWait wait = new WebDriverWait(driver.get(), Duration.ofSeconds(waitInSeconds)); 
	    wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(text); 
	    
	}
	
	public WebElement waitForElement(By by, String conditionType, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver.get(), Duration.ofSeconds(timeoutInSeconds));

        switch (conditionType.toLowerCase()) {
            case "visible":
                return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            case "clickable":
                return wait.until(ExpectedConditions.elementToBeClickable(by));
            case "present":
                return wait.until(ExpectedConditions.presenceOfElementLocated(by));
            default:
                throw new IllegalArgumentException("Invalid condition type: " + conditionType + 
                        ". Use 'visible', 'clickable', or 'present'.");
        }
    }
	
	public String getVisibleText(By locator) {
	         
	    	 var elements = driver.get().findElements(locator);	       
	         return !elements.isEmpty() ? elements.get(0).getText() : "";
	    
	}
	public void quit() {
		driver.get().quit();
	}
	
	public WebElement getElement(By locator)
	{
		waitForElement(locator,"visible",3);
		return driver.get().findElement(locator);
	}
	
	private void initializeChromeDriver(boolean isHeadless) {
        ChromeOptions options = new ChromeOptions();
        if (isHeadless) {
            options.addArguments("--headless");  
            options.addArguments("--disable-gpu"); 
            options.addArguments("--window-size=1920x1080");  
        }
        driver.set(new ChromeDriver(options));
        wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30));
    }

    private void initializeEdgeDriver(boolean isHeadless) {
        EdgeOptions options = new EdgeOptions();
        if (isHeadless) {
            options.addArguments("--headless");
            options.addArguments("--disable-gpu");
            options.addArguments("--window-size=1920x1080");
        }
        driver.set(new EdgeDriver(options));
        wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30));
    }

    private void initializeFirefoxDriver(boolean isHeadless) {
        FirefoxOptions options = new FirefoxOptions();
        if (isHeadless) {
            options.addArguments("--headless");
        }
        driver.set(new FirefoxDriver(options));
        wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30));
    }
	
}



