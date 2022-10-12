package amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

	By hambugerMenu = By.id("nav-hamburger-menu");
	By menuTvAppliance = By.linkText("TV, Appliances, Electronics");
	By subMenuTelevision = By.linkText("Televisions");
	By brandSamsung = By.linkText("Samsung");
	By sortBy = By.id("s-result-sort-select");
	By resultIndex =  By.cssSelector("div[data-index='2']");
	By sectionTitle = By.xpath("//*[@id=\'feature-bullets\']/h1");

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public void clickHamburgerMenu() {
		waitFor(hambugerMenu);
		click(hambugerMenu);
	}

	public void clickTvApplianceLink() {
		waitFor(menuTvAppliance);
		click(menuTvAppliance);
	}

	public void clickTelevisionLink() {
		waitFor(subMenuTelevision);
		click(subMenuTelevision);
	}
}
