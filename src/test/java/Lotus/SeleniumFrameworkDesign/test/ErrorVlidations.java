package Lotus.SeleniumFrameworkDesign.test;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Lotus.SeleniumFramework.objects.CartPage;
import Lotus.SeleniumFramework.objects.Checkoutpage;
import Lotus.SeleniumFramework.objects.Login;
import Lotus.SeleniumFramework.objects.ProductCatalogue;
import Lotus.SeleniumFramework.objects.conformMsg;
import Lotus.SeleniumFrameworkDesign.testcomponents.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.asm.Advice.Enter;

public class ErrorVlidations extends BaseTest{



		
	@Test
	public void LoginerrorValidation() throws IOException, InterruptedException {

		String productname = "ZARA COAT 3";
		
		log.logindetails("data@gmail.com", "9110738222@");
		Assert.assertEquals("Incorrect email or password.", log.geterrormsg());
		 
		
	}
	
	
	@Test
	public void ProductErrorValidation() throws InterruptedException
	{
String productname = "ZARA COAT 3";
		
		ProductCatalogue productcatalogue=log.logindetails("data@gmail.com", "Pg9110738222@");
		
		List<WebElement> products = productcatalogue.getproductslist();
		productcatalogue.addproduct(productname);
		CartPage cartpage=productcatalogue.gotocart(); 
		
		Boolean match = cartpage.verifyproductdisplay("ZARA COAT 3");
		Assert.assertTrue(match);
		
		
		
		
		
		
	}
	
	
	
	

}
