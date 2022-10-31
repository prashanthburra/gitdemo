package Lotus.SeleniumFramework.objects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import LotusSelenium.AbstractComponent.AbstractComponent;

public class Orderpage extends AbstractComponent {

	WebDriver driver;

	public Orderpage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "tr td:nth-child(3)")
	List<WebElement> orderproducts;

	@FindBy(css = ".totalRow button")
	WebElement checkout;

	public Boolean verifyorderdisplay(String productname) {
		Boolean b = orderproducts.stream().anyMatch(cartproduct -> cartproduct.getText().equalsIgnoreCase(productname));
		return b;

	}

}
