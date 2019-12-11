package com.tests;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class TestClass003 {
	
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	ExtentTest logger;
	WebDriver driver;
	
	@BeforeTest
	public void startReport()
	{
		System.setProperty("webdriver.chrome.driver","c:\\software\\chromedriver.exe");
		driver = new ChromeDriver();
		String reportPath = System.getProperty("user.dir")+ "/extent-reports/"+ 
		new SimpleDateFormat("dd-mm-yyyy-hh-mm-ss-ms").format(new Date()) + ".html";
	
	htmlReporter = new ExtentHtmlReporter(reportPath);
	extent = new ExtentReports();
	extent = ExtentReports();
	extent.attachReporter(htmlReporter);
	extent.setSystemInfo("Stream","Testing");
	extent.setSystemInfo("Location", "DDC4");
	extent.setSystemInfo("User Name","James Bond");
	htmlReporter.config().setDocumentTitle("Sample Test Report");
	htmlReporter.config().setReportName("Extent Report");
	htmlReporter.config().setTheme(Theme.DARK);
	}

	private ExtentReports ExtentReports() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Test
	public void method1()
	{
		logger =extent.createTest("test method 1");
		logger.log(Status.INFO, MarkupHelper.createLabel("Running Test Method", ExtentColor.GREY));
		Assert.assertTrue(true);
	}
	
	@Test
	public void method2()
	{
		logger =extent.createTest("test method 2");
		logger.log(Status.INFO, MarkupHelper.createLabel("Running Test Method", ExtentColor.GREY));
		driver.get("http://google.com");
		Assert.assertTrue(true);
	}
	
	@Test
	public void method3()
	{
		logger =extent.createTest("test method 1");
		logger.log(Status.INFO, MarkupHelper.createLabel("Running Test Method", ExtentColor.GREY));
		throw new SkipException("Skipping this test!!!");
	}

	@AfterMethod
	public void getResults(ITestResult result) throws IOException
	{
		
		if(result.getStatus()==ITestResult.SUCCESS)
			logger.log(Status.PASS, MarkupHelper.createLabel("test passed"+result.getName(), ExtentColor.GREEN));
		else if (result.getStatus() ==ITestResult.SKIP)
			logger.log(Status.SKIP, MarkupHelper.createLabel("Test skipped"+ result.getName(),ExtentColor.ORANGE));
		else if (result.getStatus() == ITestResult.FAILURE)
		{
			logger.log(Status.FAIL, MarkupHelper.createLabel("Test Failed" + result.getName(),ExtentColor.RED));
		
			TakesScreenshot SnapShot = (TakesScreenshot) driver;
			File source = SnapShot.getScreenshotAs(OutputType.FILE);
			String imagePath = System.getProperty("user.dir") + "/extent-reports/snapshots_" + result.getName() + ".png";
			FileUtils.copyFile(source, new File(imagePath));
			logger.addScreenCaptureFromPath(imagePath,result.getName());
			
		
		}
	}
	
	@AfterTest
	public void endReport()
	{
	
		driver.quit();
		extent.flush();
	}
	}
	
	

