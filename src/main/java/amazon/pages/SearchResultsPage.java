package amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResultsPage extends BasePage {

	By hambugerMenu = By.id("nav-hamburger-menu");
	By menuTvAppliance = By.linkText("TV, Appliances, Electronics");
	By subMenuTelevision = By.linkText("Televisions");
	By brandSamsung = By.linkText("Samsung");
	By sortBy = By.id("s-result-sort-select");
	By resultIndex =  By.cssSelector("div[data-index='2']");
	By sectionTitle = By.xpath("//*[@id=\'feature-bullets\']/h1");

	public SearchResultsPage(WebDriver driver) {
		super(driver);
	}

	public void clickFilterCheckbox() {
		waitFor(brandSamsung);
		click(brandSamsung);
	}

	public void sortByPrice() {
		selectBy(sortBy, "Price: High to Low");
	}

	public void openSearchResult() {
		waitFor(resultIndex);
		click(resultIndex);
	}
}
