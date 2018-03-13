package pavan;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class test {

	@Test
public void abc(){
	
	System.setProperty("webdriver.gecko.driver", "C:\\Users\\arte262_pavan\\Desktop\\pavan\\geckodriver-v0.18.0-win64\\geckodriver.exe");
	WebDriver driver=new FirefoxDriver();
	//driver.manage().window().maximize();
	driver.get("https://online2pdf.com/pdf2word");
}
	
}
