import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class webdriverdemo
{
  public static void main(String[] args)
  {
	testCase_001();
	testCase_002();

  }
  
  @Test
  public static void testCase_001() {

		System.setProperty("webdriver.chrome.driver", "/Users/tony/eclipse_workspace/WebDriverDemo/WebDriverBin/chromedriver");
		WebDriver driver = new ChromeDriver();
		
	    //Puts a Implicit wait, Will wait for 10 seconds before throwing exception
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	    //Launch website
		driver.navigate().to("http://www.calculator.net/");
		
		//driver.get("http://www.calculator.net/");
		
		//Maximize the browser
		driver.manage().window().maximize();

	    // Click on Math Calculators
		driver.findElement(By.xpath(".//*[@id='menu']/div[3]/a")).click();
	  
	    // Click on Percent Calculators
		driver.findElement(By.xpath(".//*[@id='menu']/div[4]/div[3]/a")).click();

		// Enter value 10 in the first number of the percent Calculator
	    driver.findElement(By.id("cpar1")).sendKeys("10");

	    // Enter value 50 in the second number of the percent Calculator
	    driver.findElement(By.id("cpar2")).sendKeys("50");
	    
	    // Click Calculate Button
	    driver.findElement(By.xpath(".//*[@id='content']/table/tbody/tr/td[2]/input")).click();

	    // Get the Result Text based on its xpath
	    String result = driver.findElement(By.xpath(".//*[@id='content']/p[2]/span/font/b")).getText();
	    
		//Print a Log In message to the screen
	    System.out.println(" The Result is " + result);
	    
		//Close the Browser.
	    driver.close();    
  }
  
  @Test
  public static void testCase_002() {
	  
	  System.setProperty("webdriver.chrome.driver", "/Users/tony/eclipse_workspace/WebDriverDemo/WebDriverBin/chromedriver");
	  WebDriver driver = new ChromeDriver();
		
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.navigate().to("http://www.baidu.com");
	  driver.manage().window().maximize();
	  driver.findElement(By.id("kw")).sendKeys("Test");
	  driver.findElement(By.id("su")).click();
	  if (driver.findElement(By.linkText("test_百度百科")) != null) {
		  System.out.println("Pass!");
		  System.out.println("Page title is: " + driver.getTitle());
	  }
	  driver.close();
  }
}