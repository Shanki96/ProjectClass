package com.stepdefinition;

import java.awt.AWTException;
import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import com.pom.Baseclass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AmazonHomePage {
	

	private WebDriver driver;
    private Baseclass baseClass;
    JavascriptExecutor js=(JavascriptExecutor)driver;
  
	@Given("user is on the amazon page")
	public void user_is_on_the_amazon_page() {
    	driver = new ChromeDriver();
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    	
        baseClass = new Baseclass(driver);
        baseClass.goToAmazonWebsite();
        
        js = (JavascriptExecutor) driver; 
        }
	
	@When("user is verify the homepage and user is verify the execution")
	@Test
	public void user_is_verify_the_homepage_and_user_is_verify_the_execution() throws InterruptedException, AWTException {
		List<WebElement> navigationLinks = baseClass.getNavigationLinks();
	       for (WebElement element : navigationLinks) {
	    	   String text = baseClass.getTextContent(element);
//	           System.out.println(text);
	           Assert.assertEquals(text, "Fresh");
	     	   System.out.println(text+" = True");
	           baseClass.performMouseHover(element);
	           element.click();
	           baseClass.clkskip(); 
	          
	           baseClass.clkMiniTv();
	           baseClass.clksell();
	           baseClass.clkbs();
	           baseClass.clkMobi();
	           baseClass.clktdy();
	           baseClass.clkPrime();
	           baseClass.clkCus();
	           baseClass.clkelect();
	           baseClass.clkRelease();
	           baseClass.clkhmt();
	           baseClass.clkFas();
	           baseClass.clkApay();
	           baseClass.clkgift();
	           baseClass.clkPc();
	           baseClass.clkBooks();
	           baseClass.clkToys();
	           baseClass.clkHmIm();
	           baseClass.clkAuto();
	           baseClass.clkCoup();
	           baseClass.clkSprt();
	           baseClass.clkBeau();
	           baseClass.clkGc();
	           baseClass.clkHPc();
	           baseClass.clkVidGam();
	           baseClass.clkBaby();
	           baseClass.clkCusProduct();
	           baseClass.clkPetsupp();
	           baseClass.clkSucSave();
	           baseClass.clkAud();
	           baseClass.clkAmzBasic();
	            driver.quit();
	            }
//	@Then("user should verify after completed execution success msg")
//	public void user_should_verify_after_completed_execution_success_msg() {
//   if (driver!=null) {
//	   
//	   driver.quit();
	
//} 
	
//}
      
	       
	               
		
}}