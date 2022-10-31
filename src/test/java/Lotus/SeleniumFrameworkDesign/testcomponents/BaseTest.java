package Lotus.SeleniumFrameworkDesign.testcomponents;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import Lotus.SeleniumFramework.objects.Login;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	
	 public WebDriver driver;
	 
	 public Login log;
	
	public WebDriver initializationDriver() throws IOException
	{
				
		
		Properties prop=new Properties();
		
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Lotus\\SeleniumFrameworkDesign\\resources\\Globaldata.properties");
		prop.load(fis);
		String browser = prop.getProperty("browser");
		
		if(browser.equalsIgnoreCase("chrome")) {
						
			WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();
		} else if(browser.equalsIgnoreCase("firefox"))
		{
			//firefox
		}else if(browser.equalsIgnoreCase("edge"))
		{
			
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		return driver;
		
	}
	
	@BeforeMethod
	public Login LaunchApplication() throws IOException {
		driver=initializationDriver();
		
		 log = new Login(driver);
		log.url();
		return log;
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
	
}
