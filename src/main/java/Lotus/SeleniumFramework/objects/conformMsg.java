package Lotus.SeleniumFramework.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import LotusSelenium.AbstractComponent.AbstractComponent;

public class conformMsg extends AbstractComponent {

	WebDriver driver;
	public conformMsg(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".hero-primary")
	WebElement conftext;

	
	public String confmsg() {
		
		return conftext.getText();
	}
	

}
