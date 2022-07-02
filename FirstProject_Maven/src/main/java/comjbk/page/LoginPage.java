package comjbk.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginPage {
	public WebDriver driver=null;
	public String t1,t2;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void checkTitle()
	{			
			t1=driver.getTitle();
	}
	
	public void checKSignInClickable()
	{       clear_contents();
			driver.findElement(By.xpath("//button")).click();
			t1=driver.findElement(By.xpath("//div[@id='email_error']")).getText();
	}
	
	public void checKAlreadyMember()
	{       clear_contents();
			driver.findElement(By.xpath("//a[text()='I already have a membership']")).click();
		    t1=driver.findElement(By.xpath("//p")).getText();
			
	}
	public void checKNewMemberRegistration()
	{       
			driver.findElement(By.xpath("//a[@href='pages/examples/register.html']")).click();
			t1=driver.findElement(By.xpath("//p")).getText();
			
	}
	public void correctCredentials()
	{   clear_contents();
		WebElement email=driver.findElement(By.id("email"));
		email.sendKeys("kiran@gmail.com");
		WebElement pass=driver.findElement(By.id("password"));
		pass.sendKeys("123456");
		WebElement button=driver.findElement(By.xpath("//button"));
		button.click();
		
	}
	public void checkBlankCredentials()
	{   clear_contents();
		WebElement email=driver.findElement(By.id("email"));
		email.sendKeys("");
		WebElement password=driver.findElement(By.id("password"));
		email.sendKeys("");
		WebElement button=driver.findElement(By.xpath("//button"));
		button.click();
		 t1=driver.findElement(By.xpath("//div[@id='email_error']")).getText();
		 t2=driver.findElement(By.xpath("//div[@id='password_error']")).getText();
		
		
}
	 public void clear_contents()
		{       t1=t2=null;
				driver.findElement(By.xpath("//input[@id='email']")).clear();
				driver.findElement(By.xpath("//input[@id='password']")).clear();
		}	
	 
	 public void checkSpecialCharacter()
		{        clear_contents();
				driver.findElement(By.xpath("//input[@id='email']")).sendKeys("[!@#$%^&*()] ");
				driver.findElement(By.xpath("//input[@id='password']")).sendKeys("[!@#$%^&*()] ");
				driver.findElement(By.xpath("//button")).click();
				t1=driver.findElement(By.xpath("//div[text()='Please enter email as kiran@gmail.com']")).getText();
				t2=driver.findElement(By.xpath("//div[text()='Please enter password 123456']")).getText();
				 //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
					 
}
	 public void checkNavigationUser()
		{			
				driver.findElement(By.xpath("//a[@href='users.html']")).click();
				t1=driver.findElement(By.xpath("//h3")).getText();
				
		}
	 
	
	 public void checkNavigationOperators()
	{
		    driver.findElement(By.xpath("//a[@href='operators.html']//following::span")).click();
			t1=driver.findElement(By.xpath("//h3")).getText();
		}
	   
	
	 public void checkNavigationUsefulLinks()
	 {
	   		driver.findElement(By.xpath("//a[@href='links.html']//following::span")).click();
	   		t1=driver.findElement(By.xpath("//h3")).getText();
	   	 
	 }
	   
	
    public void checkNavigationDownLoad()
	{
 			driver.findElement(By.xpath("//a[@href='downloads.html']//following::span")).click();
	   		t1=driver.findElement(By.xpath("//h3")).getText();
	   	 
	 }
	  
	
	public void checkNavigationLogout()
	{
	    	driver.findElement(By.xpath("//a[@href='logout.html']//following::i[@class='fa fa-power-off']//following::span")).click();
	   		t1=driver.findElement(By.xpath("//p[text()='Logout successfully']")).getText();
	}
	
	
	 
	 
}