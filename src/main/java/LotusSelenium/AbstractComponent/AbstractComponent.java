package LotusSelenium.AbstractComponent;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Lotus.SeleniumFramework.objects.CartPage;
import Lotus.SeleniumFramework.objects.Orderpage;

public class AbstractComponent {

	WebDriver driver;

	public AbstractComponent(WebDriver driver) {

		this.driver = driver;
		// PageFactory.initElements(driver, this);
	}

	@FindBy(css = "[routerlink*='cart']")
	WebElement cartheader;
	
	
	@FindBy(css = "[routerlink*='myorders']")
	WebElement orderheader;

	public CartPage gotocart() {
		cartheader.click();
		CartPage cartpage = new CartPage(driver);
		return cartpage;

	}

	public void waitForElementToApper(By findBy) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));

	}

	public void waitForWebElementToApper(WebElement findBy) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(findBy));

	}

	public void waitforelementtodisappear(WebElement element) throws InterruptedException {
		Thread.sleep(1000);
		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		// wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));

	}

	public Orderpage gotoOrderpage() {
		orderheader.click();
		Orderpage orderpage = new Orderpage(driver);
		return orderpage;

	}
	
	
}
