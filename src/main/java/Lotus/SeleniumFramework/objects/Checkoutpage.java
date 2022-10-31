package Lotus.SeleniumFramework.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import LotusSelenium.AbstractComponent.AbstractComponent;

public class Checkoutpage extends AbstractComponent{

	
	WebDriver driver;

	public Checkoutpage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(css=".action__submit")
	WebElement submit;
	
	@FindBy(css = "[placeholder='Select Country']")
	WebElement country;
	
	
	
	@FindBy(xpath="//button[contains(@class,'ta-item')][2]")
	WebElement selectcountry;
	
	
	By result=By.cssSelector(".ta-results");
	
	public void selectcountry(String countryname) {
	 Actions a=new Actions(driver);

			a.sendKeys(country,countryname).build().perform();
			waitForElementToApper(By.cssSelector(".ta-results"));
			selectcountry.click();

	}
	
	public conformMsg submitorder()
	{
		submit.click();
		return new conformMsg(driver);
	}
	
}
