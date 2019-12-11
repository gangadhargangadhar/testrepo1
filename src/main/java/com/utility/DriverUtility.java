package com.utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverUtility {
	static WebDriver driver;
	public static WebDriver initializeDriver(String browserName)
	{
		if(browserName.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver","c:\\software\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("FireFox"))
		{
			System.setProperty("webdriver.chrome.driver", "c:\\software\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.chrome.driver", "c:\\software\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
	
		}
		else
		{
			System.out.println("Browser not configured yet");
		}
		return driver;
	}
	public static void closeBrowser()
	{
		driver.quit();
		
	}
	}

