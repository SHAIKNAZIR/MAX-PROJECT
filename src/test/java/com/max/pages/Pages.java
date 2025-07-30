package com.max.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Pages {
    WebDriver driver;

   
   By Signup=By.id("account-actions-signup");
   By Mobile = By.id("mobileNumber");
   By Submit = By.id("signup-form-submit");
   By Mens=By.linkText("Men");
   By Tshirt=By.linkText("T-Shirts");
   By Size=By.xpath("//*[@aria-label='collapse-icon']");
   By MXL=By.xpath("//*[@id=\"filter-div\"]/div[2]/div[2]/span/div/div/div/div[1]/span/span/input");
   By ML=By.xpath("//*[@id=\"filter-div\"]/div[2]/div[2]/span/div/div/div/div[2]/span/span/input");
   By MM=By.xpath("//*[@id=\"filter-div\"]/div[2]/div[2]/span/div/div/div/div[3]/span/span/input");
   By MMin=By.xpath("//*[@aria-label='minimum-input']");
   By MMax=By.xpath("//*[@aria-label='maximum-input']");
   By SizeButton=By.xpath("//*[@id=\"filter-div\"]/div[2]/div[1]/div[2]/div/div[3]/button/span/span");
   By favButtonOnProduct = By.xpath("//button[contains(@class, 'favButtonOnProduct')]");
   By favIconButton = By.xpath("//button[@aria-label='fav-icon']");
   By dropdown = By.xpath("/html/body/div[1]/main/div[1]/div/div/div[2]/ul/li/div/section/div[2]/span[1]/span/span[1]/span");
   By option=By.xpath("//*[@id=\"account-section-container\"]/div[2]/ul/li/div/section/div[2]/span[1]/span/div/div/span/span/ul/li[4]/span");
   By ATB=By.linkText("Add to Basket");
   By Remove=By.xpath("//*[@id=\"account-section-container\"]/div[2]/ul/li[1]/div/section/div[2]/a[1]");
   By Gotowomen=By.linkText("Women");
   By Women=By.linkText("Women");
   By WShirts=By.xpath("//*[@id=\"Women-category-item-0\"]/div[3]/a");
   By WSizeButton=By.xpath("//*[@id=\\\"filter-div\\\"]/div[2]/div[2]/div/div/button/span/span\"))");
   By WOption=By.xpath("//*[@id=\\\"account-section-container\\\"]/div[2]/ul/li[1]/div/section/div[2]/span[1]/span/div/div/span/span/ul/li[5]/span");
   By KidsHome=By.linkText("Kids");
   By KidsShirt=By.linkText("Shirts");
   By KidsSize=By.xpath("//*[@id=\"filter-div\"]/div[2]/div[2]/div/div/button/span/span");
   By basketIcon = By.id("small-cart-opener-desktop");
   By checkoutBtn = By.xpath("//*[@id=\"small-cart-drop\"]/div/div[2]/div[1]/div[4]/a");
   By finalCheckoutBtn = By.xpath("//*[@id=\"main-part\"]/div/div/div[1]/div[5]/div/div[2]/div/div[2]/div[3]/button/span");
   By paymentBtn = By.xpath("//*[@id=\"qcShippingSelectorCtn\"]/div[2]/div[1]/div/div[2]/div[1]/div/div/label/span[2]/div/button/span");
   By gpayRadioBtn = By.xpath("//*[@id=\"upiPaymentOptionsContainer\"]/div[2]/div/div/label/span[1]/span/input");
 
   
   
   public Pages(WebDriver driver) {
        this.driver = driver;
    }

    
    public WebElement getLoginButton() {
        return driver.findElement(Signup);
    }

    public WebElement getPhoneInput() {
        return driver.findElement(Mobile);
    }

    public void clickOtpButton() {
        driver.findElement(Submit).click();
    }
    
    public WebElement Mens() {
    	return driver.findElement(Mens);
    }
    
    public void Tshirt() {
    	driver.findElement(Tshirt).click();
    }
    
    public void Size() {
    	driver.findElement(Size).click();
    }
    
    public void MXL() {
    	driver.findElement(MXL).click();
    }
    
    public void ML() {
    	driver.findElement(ML).click();
    }
    
    public void MM() {
    	driver.findElement(MM).click();
    }
    
    public WebElement MMin() {
        return driver.findElement(MMin);
    }
    
    public WebElement MMax() {
        return driver.findElement(MMax);
    }
    
    public void SizeButton() {
    	driver.findElement(SizeButton).click();
    }
    
    public void clickFavButtons() throws InterruptedException {
        WebElement favs = driver.findElement(favButtonOnProduct);
        favs.click(); 
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", favs);
        Thread.sleep(500);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", favs);

        WebElement favBtn = driver.findElement(favIconButton);
        favBtn.click();
    }
    
    public void dropdown() {
    	driver.findElement(dropdown).click();
    }
    
    public void option() {
    	driver.findElement(option).click();
    }
    
    public void AddtoBasket() {
    	driver.findElement(ATB).click();
    }
    
    public void remove() {
    	driver.findElement(Remove).click();
    }
    
    public void gotowomen() {
    	driver.findElement(Gotowomen).click();
    }
    
	public WebElement Womens() {	
		return driver.findElement(Women);
	}
	
	public void Wshirts() {
		driver.findElement(WShirts).click();
	}
	public void WSize() {
		driver.findElement(WSizeButton).click();
	}
	public void Woption() {
		driver.findElement(WOption).click();
	}
	
	public void Kids() {
		driver.findElement(KidsHome).click();
	}
	
	public WebElement KidsHover() {	
		return driver.findElement(KidsHome);
	}
	
	public void KidsShirt() {
		driver.findElement(KidsShirt).click();
	}
	
	public void ksize() {
		driver.findElement(KidsSize).click();
	}
	
	public void clickBasketIcon() {
        driver.findElement(basketIcon).click();
    }

    public void clickCheckout() {
        driver.findElement(checkoutBtn).click();
    }
    public void scrollDown(double percent) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, document.body.scrollHeight * " + percent + ");");
    }

    public void clickFinalCheckout() {
        driver.findElement(finalCheckoutBtn).click();
    }

    public void clickPayment() {
        driver.findElement(paymentBtn).click();
    }
    public void selectGpay() {
        driver.findElement(gpayRadioBtn).click();
    }
  
}
