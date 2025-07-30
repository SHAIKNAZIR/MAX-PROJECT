package com.max.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;
import org.testng.annotations.*;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.max.utilities.ScreenshotUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
    protected WebDriver driver;
    protected Actions actions;
    protected JavascriptExecutor js;
    protected static ExtentReports extent;
    protected static ExtentTest test;
    protected String mobileNumber;

    @BeforeSuite
    public void setupReport() {
        ExtentSparkReporter spark = new ExtentSparkReporter("extentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(spark);
    }

    @Parameters("browser")
    @BeforeClass
    public void setup(Method method, String browser) throws IOException {
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } 
    else if (browser.equalsIgnoreCase("edge")) {
      //  WebDriverManager.edgedriver().setup();
    	String edgepath=System.getProperty("user.dir");

    	System.setProperty("webdriver.edge.driver", edgepath+"\\msedgedriver.exe");
        driver = new EdgeDriver();
    }
        else {
            throw new IllegalArgumentException("Browser \"" + browser + "\" not recognized.");
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://www.maxfashion.in/in/en/");
        driver.manage().window().maximize();

        actions = new Actions(driver);
        js = (JavascriptExecutor) driver;

    }

    @AfterMethod(alwaysRun = true)
    public void tearDownTest(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) {
            String screenshotPath = ScreenshotUtil.takeScreenshot(driver, result.getName());
            test.fail("Test Failed: " + result.getThrowable(),
                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.pass("Test Passed");
        } else if (result.getStatus() == ITestResult.SKIP) {
            test.skip("Test Skipped: " + result.getThrowable());
        }

    }
    
    @BeforeMethod
    public void login(Method method) throws IOException {
    	if (method.getName().equals("loginTest")) {
            String projectPath = System.getProperty("user.dir");
            Properties prob = new Properties();
            File f1 = new File(projectPath + "//config.properties");
            FileInputStream fis = new FileInputStream(f1);
            prob.load(fis);
            mobileNumber = prob.getProperty("mobileNumber");
        }
    }
    

    @AfterSuite
    public void tearDownExtent() {
        if (driver != null) {
            driver.quit();
        }
        extent.flush();
    }
}