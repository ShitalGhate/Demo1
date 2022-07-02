package com.jbk.test;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import comjbk.page.LoginPage;

public class LoginTest {
	 
	 WebDriver driver;
	LoginPage lp;
	@BeforeClass
	 public void preBrowser()
	     {
		
		System.setProperty("webdrivder.chrome.driver","chromedriver.exe");
	    driver=new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.get("file:///C:/Users/HP/Downloads/javabykiran-Selenium-Softwares/Offline%20Website/index.html");
	    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    lp=new LoginPage(driver);
	    
		
    }
	@Test(priority=2)
	public void verifyTitle()
	{			
		lp.checkTitle();
			 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			Assert.assertEquals(lp.t1, "JavaByKiran | Log in");
	}
	@Test(priority=3)
	public void verifySignInClickable()
	{        lp.checKSignInClickable();
		     driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			 Assert.assertEquals( lp.t1,"Please enter email.");
	}
	@Test(priority=8)
	public void verifyCorrectCredentials()
	{
		lp.correctCredentials();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		Assert.assertEquals(driver.getTitle(),"JavaByKiran | Dashboard");
	}
	
	@Test(priority=6)
	public void verifyNewMemberRegistration()
	{       lp.checKNewMemberRegistration();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			Assert.assertEquals( lp.t1,"Register a new membership");
			
	}
	
	@Test(priority=7)
	public void verifyAlreadyMember()
	{       lp.checKAlreadyMember();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			Assert.assertEquals(lp.t1,"Sign in to start your session");
			
	}
	@Test(priority=4)
	public void verifyBlankCredentials()
	{
		lp.checkBlankCredentials();
		 driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		Assert.assertEquals(lp.t1, "Please enter email.");
		Assert.assertEquals(lp.t2, "Please enter password.");
	}
	 
	
	 @Test(priority=5)
	 public void VerifySpecialCharacter()
		{        lp.checkSpecialCharacter();
				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				Assert.assertEquals(lp.t1, "Please enter email as kiran@gmail.com");
				Assert.assertEquals(lp.t2, "Please enter password 123456");
								
		}
	 @Test(priority=9)
		public void verifyNavigationUser()
		{			
				 lp.checkNavigationUser();
				 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				Assert.assertEquals(lp.t1, "User List");
		}
	 
	 @Test(priority=10)
	 public void verifyNavigationOperators()
	{       lp.checkNavigationOperators();
		   	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			Assert.assertEquals(lp.t1, "Operator List");
	}
	   
	 @Test(priority=11)
	 public void vefrifyNavigationUsefulLinks()
	 {      lp.checkNavigationUsefulLinks();
	   		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	   		Assert.assertEquals(lp.t1, "* Internet Required");
	 }
	 
	 @Test(priority=12)
	    public void checkNavigationDownLoad()
		{        
		 lp.checkNavigationDownLoad();
	 	 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		 Assert.assertEquals(lp.t1, "Downloads List");
		 }
	 
	 @Test(priority=13)
		public void checkNavigationLogout()
		{        
		        lp.checkNavigationLogout();
		    	
		   	    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		   		Assert.assertEquals(lp.t1, "Logout successfully");
		}
	 
	
	 
    @AfterClass
	 public void driverclose()
	 {
		 driver.close();
	 }
}
