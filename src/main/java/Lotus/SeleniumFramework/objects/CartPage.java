package Lotus.SeleniumFramework.objects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import LotusSelenium.AbstractComponent.AbstractComponent;

public class CartPage extends AbstractComponent {

	WebDriver driver;

	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".cartSection h3")
	List<WebElement> cartproducts;

	@FindBy(css = ".totalRow button")
	WebElement checkout;
	
	
	public Boolean verifyproductdisplay(String productname)
{
		Boolean b = cartproducts.stream().anyMatch(cartproduct -> cartproduct.getText().equalsIgnoreCase(productname));
		return b;

}
	
	public  Checkoutpage Checkout()
	{
		checkout.click();
		return  new Checkoutpage(driver);
		
	}
	

}
