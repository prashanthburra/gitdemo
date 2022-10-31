package Lotus.SeleniumFramework.objects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import LotusSelenium.AbstractComponent.AbstractComponent;

public class Login extends AbstractComponent{

	WebDriver driver;

	public Login(WebDriver driver) {
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		}
	
	
	@FindBy(id=("userEmail")) WebElement email;
	@FindBy(id=("userPassword")) WebElement pwd;
	@FindBy(id=("login")) WebElement button;
	
	@FindBy(css=("[class*='flyInOut']")) WebElement errormsg;

	public ProductCatalogue logindetails(String Email,String password)
	{
		email.sendKeys(Email);
		pwd.sendKeys(password);
		button.click();
		ProductCatalogue productcatalogue = new ProductCatalogue(driver);
return productcatalogue;
		
	}
	
	public void url() {
		driver.get("https://rahulshettyacademy.com/client/");
		}
	
	public String geterrormsg()
	{
		waitForWebElementToApper(errormsg);
		return errormsg.getText(); 
	}

	
	
	
	

}
