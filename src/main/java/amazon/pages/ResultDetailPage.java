package amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ResultDetailPage extends BasePage {

	By hambugerMenu = By.id("nav-hamburger-menu");
	By menuTvAppliance = By.linkText("TV, Appliances, Electronics");
	By subMenuTelevision = By.linkText("Televisions");
	By brandSamsung = By.linkText("Samsung");
	By sortBy = By.id("s-result-sort-select");
	By resultIndex =  By.cssSelector("div[data-index='2']");
	By sectionTitle = By.xpath("//*[@id=\'feature-bullets\']/h1");

	public ResultDetailPage(WebDriver driver) {
		super(driver);
	}

	public WebElement verifySectionTitle() {
		waitFor(sectionTitle);
		System.out.println(driver.findElement(sectionTitle).getText());
		return driver.findElement(sectionTitle);
	}

	public void swithToNewTab() {
		switchToNewTab(1);
	}
}
