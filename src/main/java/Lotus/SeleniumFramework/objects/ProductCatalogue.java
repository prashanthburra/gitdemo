package Lotus.SeleniumFramework.objects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import LotusSelenium.AbstractComponent.AbstractComponent;

public class ProductCatalogue extends AbstractComponent {

	WebDriver driver;

	public ProductCatalogue(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		}
	
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	@FindBy(css=".ng-animating")
	WebElement spinner;
	
	By productsby=By.cssSelector(".mb-3");
	By addtocart=By.cssSelector(".card-body button:last-of-type");
	By toastmessage=By.cssSelector("#toast-container");
	
	public List<WebElement> getproductslist() {
		waitForElementToApper(productsby);
		return products;
	}
	
	public WebElement getproductname(String productname)
	{
		WebElement prod = products.stream()
				.filter(product -> product.findElement(By.cssSelector(".mb-3 b")).getText().equals("ZARA COAT 3"))
				.findFirst().orElse(null);
		return prod;
	}
	
	
	public WebElement addproduct(String productname) throws InterruptedException {
		
		WebElement prod = getproductname(productname);
		prod.findElement(addtocart).click();
		waitForElementToApper(toastmessage);
		waitforelementtodisappear(spinner);
		
		return prod;
	}

	
	

}
