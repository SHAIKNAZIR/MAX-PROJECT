package Max1;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Max_TestNG {

    WebDriver driver;
    Actions actions;
    JavascriptExecutor js;

    ExtentReports extent;
    ExtentTest test;

    @BeforeClass
    public void setup() {
        ExtentSparkReporter spark = new ExtentSparkReporter("extentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(spark);

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.maxfashion.in/in/en/");
        actions = new Actions(driver);
        js = (JavascriptExecutor) driver;
    }

    @Test(priority = 1)
    public void loginWithMobileNumber() throws InterruptedException {
        test = extent.createTest("Login with Mobile Number", "User logs in using mobile number");
        try {
            driver.findElement(By.id("account-actions-signup")).click(); 
            String mobileNumber = ConfigReader.getProperty("mobileNumber");
            driver.findElement(By.id("mobileNumber")).sendKeys(mobileNumber);
            driver.findElement(By.id("signup-form-submit")).click();
            Thread.sleep(15000);
            test.log(Status.PASS, "Login step completed successfully");
        } catch (Exception e) {
        	test.log(Status.FAIL, "Login failed: " + e.getMessage());
            throw e;
        }
    }

    @Test(priority = 2)
    public void buyMenProduct() throws InterruptedException {
        test = extent.createTest("Buy Men Product", "User adds men's product to cart");
        try {
            actions.moveToElement(driver.findElement(By.linkText("Men"))).perform();
            driver.findElement(By.linkText("T-Shirts")).click();

            driver.findElement(By.xpath("//*[@aria-label='collapse-icon']")).click();
            driver.findElement(By.xpath("//*[@id=\"filter-div\"]/div[2]/div[2]/span/div/div/div/div[1]/span/span/input")).click();
            driver.findElement(By.xpath("//*[@id=\"filter-div\"]/div[2]/div[2]/span/div/div/div/div[2]/span/span/input")).click();
            driver.findElement(By.xpath("//*[@id=\"filter-div\"]/div[2]/div[2]/span/div/div/div/div[3]/span/span/input")).click();

            WebElement min = driver.findElement(By.xpath("//*[@aria-label='minimum-input']"));
            min.clear(); min.sendKeys("500");
            WebElement max = driver.findElement(By.xpath("//*[@aria-label='maximum-input']"));
            max.clear(); max.sendKeys("1000");

            driver.findElement(By.xpath("//*[@id=\"filter-div\"]/div[2]/div[1]/div[2]/div/div[3]/button/span/span")).click();

            Thread.sleep(1000);
            WebElement fav = driver.findElement(By.xpath("//button[contains(@class, 'favButtonOnProduct')]"));
            js.executeScript("arguments[0].scrollIntoView(true);", fav);
            Thread.sleep(500);
            js.executeScript("arguments[0].click();", fav);

            driver.findElement(By.xpath("//button[@aria-label='fav-icon']")).click();
            driver.findElement(By.xpath("/html/body/div[1]/main/div[1]/div/div/div[2]/ul/li/div/section/div[2]/span[1]/span/span[1]/span")).click();
            driver.findElement(By.xpath("//*[@id=\"account-section-container\"]/div[2]/ul/li/div/section/div[2]/span[1]/span/div/div/span/span/ul/li[4]/span")).click();
            driver.findElement(By.linkText("Add to Basket")).click();
            Thread.sleep(5000);
            driver.findElement(By.xpath("//*[@id=\"account-section-container\"]/div[2]/ul/li[1]/div/section/div[2]/a[1]")).click();
            test.log(Status.PASS, "Men's product added successfully");
        } catch (Exception e) {
            test.log(Status.FAIL, "Failed to add men's product: " + e.getMessage());
            throw e;
        }
    }

    @Test(priority = 3)
    public void buyWomenProduct() throws InterruptedException {
        test = extent.createTest("Buy Women Product", "User adds women's product to cart");
        try {
            driver.findElement(By.linkText("Women")).click();
            Thread.sleep(2000);
            actions.moveToElement(driver.findElement(By.linkText("Women"))).perform();
            Thread.sleep(1000);
            driver.findElement(By.linkText("Shirts")).click();

            driver.findElement(By.xpath("//*[@id=\"filter-div\"]/div[2]/div[2]/div/div/button/span/span")).click();
            driver.findElement(By.xpath("//*[@id=\"filter-div\"]/div[2]/div[2]/span/div/div/div/div[1]/span/span/input")).click();

            WebElement min = driver.findElement(By.xpath("//*[@aria-label='minimum-input']"));
            min.clear(); min.sendKeys("799");
            WebElement max = driver.findElement(By.xpath("//*[@aria-label='maximum-input']"));
            max.clear(); max.sendKeys("1500");

            driver.findElement(By.xpath("//*[@id=\"filter-div\"]/div[2]/div[2]/div/div/button/span/span")).click();

            Thread.sleep(1000);
            WebElement fav = driver.findElement(By.xpath("//button[contains(@class, 'favButtonOnProduct')]"));
            js.executeScript("arguments[0].scrollIntoView(true);", fav);
            Thread.sleep(500);
            js.executeScript("arguments[0].click();", fav);

            driver.findElement(By.xpath("//button[@aria-label='fav-icon']")).click();
            driver.findElement(By.xpath("//*[@id=\"account-section-container\"]/div[2]/ul/li[1]/div/section/div[2]/span[1]/span/span[1]/span")).click();
            driver.findElement(By.xpath("//*[@id=\"account-section-container\"]/div[2]/ul/li[1]/div/section/div[2]/span[1]/span/div/div/span/span/ul/li[5]/span")).click();
            driver.findElement(By.linkText("Add to Basket")).click();
            Thread.sleep(5000);
            driver.findElement(By.xpath("//*[@id=\"account-section-container\"]/div[2]/ul/li[1]/div/section/div[2]/a[1]")).click();

            test.log(Status.PASS, "Men's product added successfully");
        } catch (Exception e) {
            test.log(Status.FAIL, "Failed to add women's product: " + e.getMessage());
            throw e;
        }
    }

    @Test(priority = 4)
    public void buyKidsProduct() throws InterruptedException {
        test = extent.createTest("Buy Kids Product", "User adds kids product to cart");
        try {
            driver.findElement(By.linkText("Kids")).click();
            Thread.sleep(2000);
            actions.moveToElement(driver.findElement(By.linkText("Kids"))).perform();
            Thread.sleep(1000);
            driver.findElement(By.linkText("Shirts")).click();

            driver.findElement(By.xpath("//*[@id=\"filter-div\"]/div[2]/div[2]/div/div/button/span/span")).click();
            driver.findElement(By.xpath("//*[@id=\"filter-div\"]/div[2]/div[2]/span/div/div/div/div[1]/span/span/input")).click();
            driver.findElement(By.xpath("//*[@id=\"filter-div\"]/div[2]/div[2]/span/div/div/div/div[2]/span/span/input")).click();

            WebElement min = driver.findElement(By.xpath("//*[@aria-label='minimum-input']"));
            min.clear(); min.sendKeys("799");
            WebElement max = driver.findElement(By.xpath("//*[@aria-label='maximum-input']"));
            max.clear(); max.sendKeys("1500");

            driver.findElement(By.xpath("//*[@id=\"filter-div\"]/div[2]/div[1]/div[2]/div/div[3]/button/span/span")).click();

            Thread.sleep(1000);
            WebElement fav = driver.findElement(By.xpath("//button[contains(@class, 'favButtonOnProduct')]"));
            js.executeScript("arguments[0].scrollIntoView(true);", fav);
            Thread.sleep(500);
            js.executeScript("arguments[0].click();", fav);

            driver.findElement(By.xpath("//button[@aria-label='fav-icon']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("/html/body/div[1]/main/div[1]/div/div/div[2]/ul/li/div/section/div[2]/span[1]/span/span[1]/span")).click();
            driver.findElement(By.xpath("//*[@id=\"account-section-container\"]/div[2]/ul/li/div/section/div[2]/span[1]/span/div/div/span/span/ul/li[4]/span")).click();
            driver.findElement(By.linkText("Add to Basket")).click();
            Thread.sleep(5000);
            driver.findElement(By.xpath("//*[@id=\"account-section-container\"]/div[2]/ul/li[1]/div/section/div[2]/a[1]")).click();

            test.log(Status.PASS, "Kids product added successfully");
        } catch (Exception e) {
            test.log(Status.FAIL, "Failed to add kids product: " + e.getMessage());
            throw e;
        }
    }

    @Test(priority = 5)
    public void checkoutCart() throws InterruptedException {
        test = extent.createTest("Checkout Cart", "User proceeds to checkout");
        try {
            WebElement basketIcon = driver.findElement(By.id("small-cart-opener-desktop"));
            basketIcon.click();
            Thread.sleep(2000); 

            WebElement checkout=driver.findElement(By.xpath("//*[@id=\"small-cart-drop\"]/div/div[2]/div[1]/div[4]/a"));
            checkout.click();
            Thread.sleep(3000);

            js.executeScript("window.scrollBy(0, document.body.scrollHeight * 0.1);");
            Thread.sleep(2000);

            WebElement Finalcheckout=driver.findElement(By.xpath("//*[@id=\"main-part\"]/div/div/div[1]/div[5]/div/div[2]/div/div[2]/div[3]/button/span"));
            Finalcheckout.click();

            driver.findElement(By.xpath("//*[@id=\"qcShippingSelectorCtn\"]/div[2]/div[1]/div/div[2]/div[1]/div/div/label/span[2]/div/button/span")).click();

            js.executeScript("window.scrollBy(0, document.body.scrollHeight * 0.2);");
            Thread.sleep(2000);

            driver.findElement(By.xpath("//*[@id=\"upiPaymentOptionsContainer\"]/div[2]/div/div/label/span[1]/span/input")).click();

            test.log(Status.PASS, "Checkout successfully");
        } catch (Exception e) {
            test.log(Status.FAIL, "Failed to Checkout: " + e.getMessage());
            throw e;
        }
    }

    @AfterClass
    public void close() {
        if (driver != null) {
            driver.quit();
        }
        extent.flush();  
    }
}
