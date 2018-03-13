package pavan;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.sun.jna.platform.FileUtils;

public class parlleltesting
{
	private WebDriver driver;
	String baseurl = "https://www.amazon.in/";
	
	@Parameters({"abc"})
	@BeforeTest
	public void launchingApp(String abc) throws Exception
	{
	try {
		
		if (abc.equalsIgnoreCase("chrome"))
		{
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\arte262_pavan\\Downloads\\drivers\\chromedriver.exe" );
        driver = new ChromeDriver();
		}
		 if (abc.equalsIgnoreCase("firefox"))
		{
			 System.setProperty("webdriver.gecko.driver", "C:\\Users\\arte262_pavan\\Desktop\\pavan\\geckodriver-v0.18.0-win64\\geckodriver.exe");
				 driver=new FirefoxDriver();
		}
		 if (abc.equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.IE.driver", "C:\\Users\\arte262_pavan\\Downloads\\drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		
		
		
	} catch (WebDriverException e)
	{ 
		System.out.println(e.getMessage());
	}
	}

	@Test
	public void login_TestCase() throws Exception {
		driver.navigate().to(baseurl);
	    WebElement element =  driver.findElement(By.xpath(".//*[@id='nav-link-shopall']/span[2]"));
		Actions act = new Actions(driver);
		act.moveToElement(element).build().perform();
		WebElement element2= driver.findElement(By.xpath(".//*[@id='nav-flyout-shopAll']/div[2]/span[6]/span"));
		Actions act1=new Actions(driver);
		act1.moveToElement(element2).build().perform();
		driver.findElement(By.xpath(".//*[@id='nav-flyout-shopAll']/div[3]/div[6]/div[1]/div/a[2]/span")).click();  
		driver.findElement(By.xpath(".//*[@id='glow-ingress-line2']")).click();  
		
		/*Actions act2=new Actions(driver);
		act2=driver.switchTo().alert().accept();
		act2=driver.switchTo().alert().accept();*/
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		org.apache.commons.io.FileUtils.copyFile(src,new File("./screenshotss/pavan.png")); 
		driver.close();
}

	
	
	

	
	}



