package com.max.tests;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;
import com.max.base.BaseClass;
import com.max.pages.Pages;

public class Tests extends BaseClass {
    Pages page;
    // Login Module
    @Test(priority = 1)
    public void loginTest() throws InterruptedException {
        test = extent.createTest("Login Functionality");
        try {
            page = new Pages(driver);
            page.getLoginButton().click();
            page.getPhoneInput().sendKeys(mobileNumber);
            page.clickOtpButton();
        } catch (Exception e) {
            throw e;
        }
    }

    // Mens Module
    @Test(priority = 2)
    public void Mens() throws InterruptedException {
        test = extent.createTest("Mens Product Buying Functionality");
        try {
            page = new Pages(driver);
            Actions actions = new Actions(driver);
            WebElement Ele = page.Mens();
            actions.moveToElement(Ele).perform();
            page.Tshirt();
            page.Size();
            page.MXL();
            page.ML();
            page.MM();
            page.MMin().clear();
            page.MMin().sendKeys("500");
            page.MMax().clear();
            page.MMax().sendKeys("1000");
            page.SizeButton();
            Thread.sleep(3000);
            page.clickFavButtons();
            page.dropdown();
            page.option();
            page.AddtoBasket();
            Thread.sleep(5000);
            page.remove();
        } catch (Exception e) {
            throw e;
        }
    }

    // Womens Module
    @Test(priority = 3)
    public void women() throws InterruptedException {
        test = extent.createTest("Women's Product Buying Functionality");
        try {
            page.gotowomen();
            Thread.sleep(2000);
            Actions a1 = new Actions(driver);
            WebElement Ele1 = page.Womens();
            a1.moveToElement(Ele1).perform();
            page = new Pages(driver);
            page.Wshirts();
            page.Size();
            page.MXL();
            page.ML();
            page.MMin().clear();
            page.MMin().sendKeys("699");
            page.MMax().clear();
            page.MMax().sendKeys("1500");
            page.SizeButton();
            Thread.sleep(3000);
            page.clickFavButtons();
            page.dropdown();
            page.option();
            page.AddtoBasket();
            Thread.sleep(5000);
            page.remove();
        } catch (Exception e) {
            throw e;
        }
    }

    // Kids Module
    @Test(priority = 4)
    public void kids() throws InterruptedException {
        test = extent.createTest("Kids Product Buying Functionality");
        try {
            page = new Pages(driver);
            page.Kids();
            Thread.sleep(2000);
            Actions a2 = new Actions(driver);
            WebElement Ele2 = page.KidsHover();
            a2.moveToElement(Ele2).perform();
            Thread.sleep(1000);
            page.KidsShirt();
            page.ksize();
            page.MXL();
            page.ML();
            page.MMin().clear();
            page.MMin().sendKeys("500");
            page.MMax().clear();
            page.MMax().sendKeys("1000");
            page.SizeButton();
            Thread.sleep(3000);
            page.clickFavButtons();
            page.dropdown();
            page.option();
            page.AddtoBasket();
            Thread.sleep(5000);
            page.remove();
        } catch (Exception e) {
            throw e;
        }
    }

    // Checkout Module
    @Test(priority = 5)
    public void checkoutWithGpay() throws InterruptedException {
        test = extent.createTest("Checkout Functionality");
        try {
            page = new Pages(driver);
            page.clickBasketIcon();
            page.clickCheckout();
            page.scrollDown(0.1);
            Thread.sleep(2000);
            page.clickFinalCheckout();
            page.clickPayment();
            page.scrollDown(0.2);
            Thread.sleep(2000);
            page.selectGpay();
        } catch (Exception e) {
            throw e;
        }
    }
}
