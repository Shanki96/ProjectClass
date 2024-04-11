package com.pom;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.sql.Driver;
import java.time.Duration;
import java.util.List;

public class Baseclass {

	private WebDriver driver;
    JavascriptExecutor js=(JavascriptExecutor)driver;
   
   
     
    public Baseclass(WebDriver driver) {
        this.driver = driver;
        this.js = (JavascriptExecutor) driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        
    }
    public void goToAmazonWebsite() {
        driver.get("https://www.amazon.in/ref=nav_logo");
        driver.manage().window().maximize();
        
    }
    public List<WebElement> getNavigationLinks() {
        return driver.findElements(naviLinks);
    } 
    public String getTextContent(WebElement element) {
        try {
            return (String) js.executeScript("return arguments[0].textContent", element);
        } catch (Exception e) {
            // Retry finding the element
            WebElement refreshedElement = driver.findElement((By) js.executeScript("return arguments[0].parentNode;", element));
            return (String) js.executeScript("return arguments[0].textContent", refreshedElement);
        }
        
    }
    public void performMouseHover(WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element).perform(); 
        
    }
    private By naviLinks = By.xpath("//a[@data-csa-c-slot-id='nav-link-groceries']");
    private By clkFshSkip = By.xpath("//a[text()='Skip']");
    private By clkAmzMiniTv = By.xpath("//a[@data-csa-c-content-id='nav_avod_desktop_topnav']");
    private By clickSell = By.xpath("//a[@data-csa-c-slot-id='nav_cs_2']");
    private By clkBestSeller =By.xpath("//a[@data-csa-c-content-id='nav_cs_bestsellers']");
    private By clickmobi = By.xpath("//a[@data-csa-c-content-id='nav_cs_mobiles']");
    private By tdyDeals = By.xpath("//a[@data-csa-c-content-id='nav_cs_gb']");
    private By clickPrime = By.xpath("//a[@data-csa-c-content-id='nav_cs_primelink_nonmember']");
    private By clickCust = By.xpath("//a[@data-csa-c-content-id='nav_cs_help']");  
	private By clickelec = By.xpath("//a[@data-csa-c-content-id='nav_cs_electronics']");
    private By clicknrelease = By.xpath("//a[@data-csa-c-content-id='nav_cs_newreleases']");
    private By clickhm = By.xpath("//a[@data-csa-c-content-id='nav_cs_home']");
    private By clickFas = By.xpath("//a[@data-csa-c-content-id='nav_cs_fashion']");
    private By clickapay = By.xpath("//a[@data-csa-c-content-id='nav_cs_apay']");
    private By clickgft = By.xpath("//a[@data-csa-c-content-id='nav_cs_giftfinder']");
    private By clickpc = By.xpath("//a[@data-csa-c-content-id='nav_cs_pc']");
    private By clickbks = By.xpath("//a[@data-csa-c-content-id='nav_cs_books']");
    private By clicktys = By.xpath("//a[@data-csa-c-content-id='nav_cs_toys']");
    private By clickHmIm = By.xpath("//a[@data-csa-c-content-id='nav_cs_hi']");
    private By clickauto = By.xpath("//a[@data-csa-c-content-id='nav_cs_automotive']");
    private By clickcoup = By.xpath("//a[@data-csa-c-content-id='nav_cs_coupons']");
    private By clicksport = By.xpath("//a[@data-csa-c-content-id='nav_cs_sports']");
    private By clickbea = By.xpath("//a[@data-csa-c-content-id='nav_cs_beauty']");
    private By clickgc = By.xpath("//a[@data-csa-c-content-id='nav_cs_gc']");
    private By clickHpc = By.xpath("//a[@data-csa-c-content-id='nav_cs_hpc']");
    private By clickVG = By.xpath("//a[@data-csa-c-content-id='nav_cs_video_games']");
    private By clickbaby = By.xpath("//a[@data-csa-c-content-id='nav_cs_baby']");
    private By clickCusPro = By.xpath("//a[@data-csa-c-content-id='nav_cs_custom']");
    private By clickpetsup = By.xpath("//a[@data-csa-c-content-id='nav_cs_pets']");
    private By clickSucSav = By.xpath("//a[@data-csa-c-content-id='nav_cs_sns']");
    private By clickaud = By.xpath("//a[@data-csa-c-content-id='nav_cs_audible']");
    private By clickamazBas = By.xpath("//a[@data-csa-c-content-id='nav_cs_amazonbasics']");
    
    public void clkskip() throws AWTException, InterruptedException {
    	  
        WebElement skip = driver.findElement(clkFshSkip);
        boolean displayed = skip.isDisplayed();
        if(displayed==true) {
         	Robot robot = new Robot();
         	robot.keyPress(KeyEvent.VK_ESCAPE);
        	robot.keyRelease(KeyEvent.VK_ESCAPE);
            Thread.sleep(2000);
         	driver.navigate().back();
        }
		
	}
    
    public void clkMiniTv() throws InterruptedException {
    	Thread.sleep(2000);
        WebElement miniTv = driver.findElement(clkAmzMiniTv);
        miniTv.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));          	
    	driver.navigate().back(); 
    	String text = clkAmzMiniTv.findElement(driver).getText();
    	Assert.assertEquals(text, "Amazon miniTV");
 	    System.out.println(text+" = True");
    }
    
    public void clksell() {
    	WebElement sell= driver.findElement(clickSell);
        sell.click();
        String text = clickSell.findElement(driver).getText();
        Assert.assertEquals(text, "Sell");
  	    System.out.println(text+" = True");
    	}
    public void clkbs() {
    	WebElement bsell= driver.findElement(clkBestSeller);
        bsell.click();
        String text = clkBestSeller.findElement(driver).getText();
        Assert.assertEquals(text, "Best Sellers");
  	   System.out.println(text+" = True");
    	}
    
   public void clkMobi() {
    	WebElement mb= driver.findElement(clickmobi);
       mb.click();
       String text = clickmobi.findElement(driver).getText();
       Assert.assertEquals(text, "Mobiles");
 	   System.out.println(text+" = True");
    	}
   public void clktdy() {
	   	WebElement tdy= driver.findElement(tdyDeals);
	    tdy.click();
	    String text = tdyDeals.findElement(driver).getText();
        Assert.assertEquals(text, "Today's Deals");
  	   System.out.println(text+" = True");
	    	}
   public void clkPrime() {
	    	   
	   WebElement cp= driver.findElement(clickPrime);
	   cp.click();
	   String text = clickPrime.findElement(driver).getText();
       Assert.assertEquals(text, "Prime");
 	   System.out.println(text+" = True");
	    	    	}
   public void clkCus() {
	   
	   WebElement cp= driver.findElement(clickCust);
	   cp.click();
	   String text = clickCust.findElement(driver).getText();
       Assert.assertEquals(text, "Customer Service");
 	   System.out.println(text+" = True");
	    	    	}
   public void clkelect() {
	   	WebElement cu= driver.findElement(clickelec);
	    cu.click();
	    String text = clickelec.findElement(driver).getText();
        Assert.assertEquals(text, "Electronics");
  	   System.out.println(text+" = True");
	    }
   public void clkRelease() {
	   	WebElement cu= driver.findElement(clicknrelease);
	    cu.click();
	    String text = clicknrelease.findElement(driver).getText();
        Assert.assertEquals(text, "New Releases");
  	   System.out.println(text+" = True");
   }
   public void clkhmt() {
	   	WebElement cu= driver.findElement(clickhm);
	    cu.click();
	    String text = clickhm.findElement(driver).getText();
        Assert.assertEquals(text, "Home & Kitchen");
  	   System.out.println(text+" = True");
	    }
   public void clkFas() throws InterruptedException {
	   	WebElement cu= driver.findElement(clickFas);
	   	cu.click();	  
	    String text = clickFas.findElement(driver).getText();
        Assert.assertEquals(text, "Fashion");
  	   System.out.println(text+" = True");
	    }
   public void clkApay() throws InterruptedException {
	   	WebElement cu= driver.findElement(clickapay);
		cu.click();	  
	    String text = clickapay.findElement(driver).getText();
        Assert.assertEquals(text, "Amazon Pay");
  	   System.out.println(text+" = True");
	    }

   public void clkgift() throws InterruptedException {
	   	WebElement cu= driver.findElement(clickgft);
	   	cu.click();	  
	    String text = clickgft.findElement(driver).getText();
        Assert.assertEquals(text, "Gift Ideas");
  	   System.out.println(text+" = True");
	    }
   public void clkPc() throws InterruptedException {
	   	WebElement cu= driver.findElement(clickpc);
	   	cu.click();	  
	    String text = clickpc.findElement(driver).getText();
	    Assert.assertEquals(text, "Computers");
	  	   System.out.println(text+" = True");
        }
	 public void clkBooks() throws InterruptedException {
	   	WebElement cu= driver.findElement(clickbks);
	   	cu.click();	  
	    String text = clickbks.findElement(driver).getText();
        Assert.assertEquals(text, "Books");
  	   System.out.println(text+" = True");
	    }   
	
   public void clkToys() throws InterruptedException {
	   	
	   WebElement element= driver.findElement(clicktys);
	   Actions action = new Actions(driver);
       action.moveToElement(element).perform(); 
       String text = element.getText();
       action.click().perform();
       Assert.assertEquals(text, "Toys & Games");
  	   System.out.println(text+" = True");
  	} 
   public void clkHmIm() throws InterruptedException {
	   	WebElement element= driver.findElement(clickHmIm);
	   	Actions action = new Actions(driver);
	    action.moveToElement(element).perform();  
	    String text = element.getText();
	       action.click().perform();
	       Assert.assertEquals(text, "Home Improvement");
	  	   System.out.println(text+" = True");

		  
    }   
   public void clkAuto() throws InterruptedException {
		WebElement element= driver.findElement(clickauto);
		Actions action = new Actions(driver);
	    action.moveToElement(element).perform();  
	    String text = element.getText();
	       action.click().perform();
	       Assert.assertEquals(text, "Car & Motorbike");
	  	   System.out.println(text+" = True");
		  
		 
		 }
   public void clkCoup() throws InterruptedException {
		WebElement element= driver.findElement(clickcoup);
		Actions action = new Actions(driver);
	    action.moveToElement(element).perform();  
	    String text = element.getText();
	       action.click().perform();
	       Assert.assertEquals(text, "Coupons");
	  	   System.out.println(text+" = True");
		  

	    
		 }
   public void clkSprt() throws InterruptedException {
		WebElement element = driver.findElement(clicksport);
		Actions action = new Actions(driver);
	    action.moveToElement(element).perform(); 
	    String text = element.getText();
	       action.click().perform();
	       Assert.assertEquals(text, "Sports, Fitness & Outdoors");
	  	   System.out.println(text+" = True");
		  

	
		          
		 }
   public void clkBeau() throws InterruptedException {
		WebElement element= driver.findElement(clickbea);
		Actions action = new Actions(driver);
	       action.moveToElement(element).perform();  
	       String text = element.getText();
	       action.click().perform();
	       Assert.assertEquals(text, "Beauty & Personal Care");
	  	   System.out.println(text+" = True");

		  
		 }
   public void clkGc() throws InterruptedException {
		WebElement element= driver.findElement(clickgc);
		Actions action = new Actions(driver);
	       action.moveToElement(element).perform();  
	       String text = element.getText();
	       action.click().perform();
	       Assert.assertEquals(text, "Gift Cards");
	  	   System.out.println(text+" = True");
		  
		 }
   public void clkHPc() throws InterruptedException {
		WebElement element= driver.findElement(clickHpc);
		Actions action = new Actions(driver);
	       action.moveToElement(element).perform(); 
	       String text = element.getText();
	       action.click().perform();
	       Assert.assertEquals(text, "Health, Household & Personal Care");
	  	   System.out.println(text+" = True");
	       
		  
		 }
   public void clkVidGam() throws InterruptedException {
		WebElement element= driver.findElement(clickVG);
		Actions action = new Actions(driver);
	       action.moveToElement(element).perform();  
	       String text = element.getText();
	       action.click().perform();
	       Assert.assertEquals(text, "Video Games");
	  	   System.out.println(text+" = True");
	       
	
		  
		 }
   public void clkBaby() throws InterruptedException {
		WebElement element= driver.findElement(clickbaby);
		Actions action = new Actions(driver);
	       action.moveToElement(element).perform();
	       String text = element.getText();
	       action.click().perform();
	       Assert.assertEquals(text, "Baby");
	  	   System.out.println(text+" = True");
	       
	
		  
		 }
   public void clkCusProduct() throws InterruptedException {
		WebElement element= driver.findElement(clickCusPro);
		Actions action = new Actions(driver);
	       action.moveToElement(element).perform();
	       String text = element.getText();
	       action.click().perform();
	       Assert.assertEquals(text, "Custom Products");
	  	   System.out.println(text+" = True");
	       
		  
		 }
   public void clkPetsupp() throws InterruptedException {
		WebElement element= driver.findElement(clickpetsup);
		Actions action = new Actions(driver);
	       action.moveToElement(element).perform();
	       String text = element.getText();
	       action.click().perform();
	       Assert.assertEquals(text, "Pet Supplies");
	  	   System.out.println(text+" = True");


		  
		 }
   public void clkSucSave() throws InterruptedException {
		WebElement element= driver.findElement(clickSucSav);
		Actions action = new Actions(driver);
	       action.moveToElement(element).perform();  
	       String text = element.getText();
	       action.click().perform();
	       Assert.assertEquals(text, "Subscribe & Save");
	  	   System.out.println(text+" = True");

		  
		 }
   public void clkAud() throws InterruptedException {
		WebElement element= driver.findElement(clickaud);
		Actions action = new Actions(driver);
	       action.moveToElement(element).perform();  
	       String text = element.getText();
	       action.click().perform();
	       Assert.assertEquals(text, "Audible");
	  	   System.out.println(text+" = True");

		  
		 }
   public void clkAmzBasic() throws InterruptedException {
		WebElement element= driver.findElement(clickamazBas);
		Actions action = new Actions(driver);
	       action.moveToElement(element).perform();  
	       String text = element.getText();
	       action.click().perform();
	       Assert.assertEquals(text, "AmazonBasics");
	  	   System.out.println(text+" = True");  
		 }
   


}
